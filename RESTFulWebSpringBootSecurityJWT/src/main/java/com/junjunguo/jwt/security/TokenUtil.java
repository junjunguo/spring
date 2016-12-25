package com.junjunguo.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Jwt token utilities.
 */
@Component
public class TokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    /**
     * The Claim key username.
     */
    static final String CLAIM_KEY_USERNAME = "sub";
    /**
     * The Claim key audience.
     */
    static final String CLAIM_KEY_AUDIENCE = "audience";
    /**
     * The Claim key created.
     */
    static final String CLAIM_KEY_CREATED  = "created";

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB     = "web";
    private static final String AUDIENCE_MOBILE  = "mobile";
    private static final String AUDIENCE_TABLET  = "tablet";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Gets username from token.
     *
     * @param token the token
     * @return the username from token
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * Gets created date from token.
     *
     * @param token the token
     * @return the created date from token
     */
    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }


    /**
     * Gets expiration date from token.
     *
     * @param token the token
     * @return the expiration date from token
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * Gets audience from token. Audience: web, mobile, tablet and unknown.
     *
     * @param token the token
     * @return the audience from token
     */
    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = getClaimsFromToken(token);
            audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
        } catch (Exception e) {
            audience = null;
        }
        return audience;
    }

    /**
     * Get claims from token
     *
     * @param token token
     * @return Claims form the given token
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                         .setSigningKey(secret)
                         .parseClaimsJws(token)
                         .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * @return expiration date for a token
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    /**
     * @param device {@link Device}
     * @return generated audience for we, tablet, and mobile
     */
    private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }

    /**
     * Ignore token expiration for tablet and mobile.
     *
     * @param token auth token
     * @return if the token expiration can be ignored.
     */
    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    /**
     * Generate access(authentication) token
     *
     * @param userDetails {@link UserDetails}
     * @param device      {@link Device}
     * @return generated access token
     */
    public String generateToken(UserDetails userDetails, Device device) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
//        claims.put(CLAIM_KEY_AUDIENCE, generateAudience(device));
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * Use {@link Jwts} to generate token
     *
     * @param claims {@link Map}
     * @return generated token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                   .setClaims(claims)
                   .setExpiration(generateExpirationDate())
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact();
    }


    /**
     * Can token be refreshed boolean.
     *
     * @param token             the token
     * @param lastPasswordReset the last password reset
     * @return the boolean
     */
    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
               && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    /**
     * Refresh token string.
     *
     * @param token the token
     * @return the string
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * Validate token boolean.
     *
     * @param token       the token
     * @param userDetails the user details
     * @return the boolean
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        if (!getUsernameFromToken(token).equals(userDetails.getUsername())) return false; // correct user check

        if (isTokenExpired(token)) return false; // expiration check

        UserDetailsImpl user = (UserDetailsImpl) userDetails;
        if (isCreatedBeforeLastPasswordReset(getCreatedDateFromToken(token), user.getLastPasswordResetDate()))
            return false; // check

        return true;
    }
}
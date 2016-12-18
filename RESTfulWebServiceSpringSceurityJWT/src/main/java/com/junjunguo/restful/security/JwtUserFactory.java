package com.junjunguo.restful.security;

import com.junjunguo.restful.model.entity.User;
//import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
//                user.getId(),
                user.getName(),
//                user.getFirstname(),
//                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
//                mapToGrantedAuthorities(user.getAuthorities()),
                null,
                true,
//                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

//    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
//        return authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .collect(Collectors.toList());
//    }
}

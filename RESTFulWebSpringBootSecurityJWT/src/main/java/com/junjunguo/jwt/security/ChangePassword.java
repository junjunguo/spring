package com.junjunguo.jwt.security;

/**
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 25/12/2016.
 */
public class ChangePassword {

    private String email;
    private String oldPassword;
    private String newPassword;

    public ChangePassword() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

package com.mail.gl.mail_provider.util;

import org.apache.commons.codec.digest.Crypt;
public final class BCryptPasswordEncoder {
    public boolean authenticate(String password, String token) {
        return cryptPassword(password).equals(token);
    }
    public String cryptPassword(String passwordToHash){
        final String salt = "$6$rounds=123123$FooBarBaz";
        return Crypt.crypt(passwordToHash,salt);
    }
}

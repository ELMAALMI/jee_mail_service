package com.mail.elmaalmi.billal.util;

import java.security.MessageDigest;
import java.util.Base64;

public final class BCryptPasswordEncoder {
    public boolean authenticate(String password, String token) {
        return cryptPassword(password).equals(token);
    }
    public String cryptPassword(String passwordToHash){
       try {
           byte[] password_ = passwordToHash.getBytes();
           byte[] salt = "dovecot".getBytes();
           MessageDigest digest = MessageDigest.getInstance("SHA-512");
           digest.reset();
           digest.update(salt);
           byte[] hashed = digest.digest(password_);
           String hashed_password = Base64.getEncoder().encodeToString(hashed);
           return "{SHA512-CRYPT}$6$dovecot$"+hashed_password;
       }catch (Exception e){
            e.printStackTrace();
       }
        return null;
    }
}

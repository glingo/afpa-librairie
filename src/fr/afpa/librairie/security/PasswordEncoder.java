/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afpa.librairie.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author cdi305
 */
public class PasswordEncoder {
    
    private final MessageDigest digester;

    public PasswordEncoder() throws NoSuchAlgorithmException {
        this(MessageDigest.getInstance("MD5"));
    }

    public PasswordEncoder(MessageDigest digester) {
        this.digester = digester;
    }
    
    public String encode(String password) {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = digester.digest(uniqueKey);

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        
        return hashString.toString();
    }
    
    
}

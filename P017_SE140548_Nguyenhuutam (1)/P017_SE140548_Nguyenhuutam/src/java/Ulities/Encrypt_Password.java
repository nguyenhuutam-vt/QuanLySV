/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ASUS
 */
public class Encrypt_Password {
    
    public static String encrypt(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");    //khai bao hasing
        // 123asd
        // 123 - byte[] -->  1as10ds5a4fas4fasd
        // Change this to UTF-16 if needed
        md.update(password.getBytes(StandardCharsets.UTF_8));   // change text to byte[]010105015
             //update - add                                               // md.update(text) --> nghia la add byte[] text vao diget
        byte[] digest = md.digest();    // hashing mang byte[] trong md
                        // digest() --> hashing
        String hex = String.format("%064x", new BigInteger(1, digest)); // hexa - 181318181489486486484484684864 -  fa2vVB5sa5v1a5s
        // BigInteger(signum, matipulation) // chuyen doi mang byte da dc hashing thanh -1,0,1
        
        return hex;
    }
}

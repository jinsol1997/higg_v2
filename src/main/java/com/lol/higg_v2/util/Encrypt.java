package com.lol.higg_v2.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class Encrypt {


    public static String getSalt() {


        SecureRandom r = new SecureRandom();
        byte[] salt = new byte[10];

        r.nextBytes(salt);

        StringBuffer sb = new StringBuffer();

        for (byte b : salt) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }


    public static String getEncrypt(String pw, String salt) {
        String result = "";

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            md.update((pw + salt).getBytes());
            byte[] pwdsalt = md.digest();

            StringBuffer sb = new StringBuffer();

            for (byte b : pwdsalt) {
                sb.append(String.format("%02x", b));
            }

            result = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}

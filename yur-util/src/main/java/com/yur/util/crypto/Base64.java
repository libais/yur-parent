package com.yur.util.crypto;

public class Base64 {


    public static String ENCODE(byte[] bs) {
        if (bs == null)
            return null;
        byte[] b = org.apache.commons.codec.binary.Base64.encodeBase64(bs);
        try {
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static byte[] DECODE(String s) {
        if (s == null)
            return null;
        return org.apache.commons.codec.binary.Base64.decodeBase64(s);
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static String decode(String s) {
        if (s == null)
            return null;
        byte[] b = org.apache.commons.codec.binary.Base64.decodeBase64(s);
        try {
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static String encode(String s) {
        if (s == null)
            return null;
        byte[] b = org.apache.commons.codec.binary.Base64.encodeBase64(s.getBytes());
        try {
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

}

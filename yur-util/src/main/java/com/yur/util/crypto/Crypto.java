package com.yur.util.crypto;

public class Crypto {

    public static final String KEY = "com.yur";

    /**
     * 加密
     * @param text
     * @param key
     * @return
     */
    public static String encrypt(String text, String key) {
        byte[] bs = RC4.encry_RC4_byte(text, key);
        return Base64.ENCODE(bs);
    }

    /**
     * 解密
     * @param cipher
     * @param key
     * @return
     */
    public static String decrypt(String cipher, String key) {
        byte[] bs = Base64.DECODE(cipher);
        return RC4.decry_RC4(bs, key);
    }

    public static void main(String[] args) throws Exception {
        String str = "123456";
        String t = "";
        System.out.println("加密后：" + (t = encrypt(str, KEY)));
        System.out.println("解密后：" + decrypt(t, KEY));
        System.out.println("解密后：" + decrypt("123456", KEY));
    }


}

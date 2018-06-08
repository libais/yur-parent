package com.yur.util.crypto;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

    public String encryptoMD5(String username, String password){
        return DigestUtils.md5Hex(username + password);
    }
}

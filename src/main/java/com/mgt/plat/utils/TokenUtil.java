/*
 * @Description: 
 * @version: 
 * @Author: JupSat
 * @email: jupsat@163.com
 * @Date: 2023-01-28 16:25:42
 * @LastEditors: JupSat
 * @LastEditTime: 2023-01-28 17:29:13
 */
package com.mgt.plat.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * package name：com.mgt.plat.utils
 * description：
 * user：JupSat
 * modification time：2023-01-28 16:25
 * modified content：
 **/
public class TokenUtil {
    private static final long EXPIRE_TIME = 1000 * 60 * 30;
    private static final String TOKEN_SECRET = "token_secret";

    public static String createToken(String username, String password) {
        String token = "";
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(date)
                    .sign(algorithm);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            System.out.println("校验失败");
            return false;
        }
    }
}

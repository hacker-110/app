package com.example.app.config.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.app.exception.Errors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 */
public class JwtUtil {

    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000; // 一天 24 * 60 * 60 * 1000

    /**
     * jwt 密钥
     */
    private static final String SECRET = "jwt_secret";

    /**
     * 生成签名，五分钟后过期
     *
     * @param username
     * @return
     */
    public static String sign(String username ,String openid, String avatarUrl) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm =  Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将 username 保存到 token 里面
                    .withClaim("username", username)
                    .withClaim("openid", openid)
                    .withClaim("avatarUrl", avatarUrl)
                    // 五分钟后token过期
                    .withExpiresAt(date)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }



    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            token = token.replace("Bearer ", "");
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            throw new Errors( 401,"token 无效，请重新获取");
        }
    }
    //解码token
    public static Map<String , Object> DecodedJWT(String token) {
        token = token.replace("Bearer ", "");
        // 创建一个验证的对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
//        System.out.println(verify.getClaim("id").asInt());
//        System.out.println(verify.getClaim("username").asString());
//        System.out.println("过期时间：" + verify.getExpiresAt());
        Map<String , Object> map = new HashMap<>();
        map.put("username" , verify.getClaim("username").asString());
        map.put("openid" , verify.getClaim("openid").asString());
        map.put("avatarUrl" , verify.getClaim("avatarUrl").asString());
        return  map ;
    }

}

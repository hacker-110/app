package com.example.app.service.utils;

import com.example.app.config.token.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class HttptokenId {
    public   Map<String, Object> tokenId(){
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("Authorization");
            Map<String, Object> user = JwtUtil.DecodedJWT(token);
            return user;
        }
        return null;
    }
}

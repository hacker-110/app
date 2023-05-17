package com.example.app.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.app.config.token.JwtUtil;
import com.example.app.dto.StateDTO;
import com.example.app.dto.WeCharUserInfoDTO;
import com.example.app.mapper.LoginMapper;
import com.example.app.service.impl.UitlImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

//登录
@Service
public class LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private UitlImpl loginImpl;
    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    //获取token 和 返回用户信息
    private Map <String , Object> getMap ( WeCharUserInfoDTO user){
        String token = JwtUtil.sign(user.getNickName(), user.getOpenid(),user.getAvatarUrl());
        Map<String , Object> map  = new HashMap<>();
        map.put("token", token);
        map.put("user", user);
        return  map;
    }
    public StateDTO  getWeChartUserInfo(WeCharUserInfoDTO weCharUserInfoDTO){
        // 构造获取access_token的URL
        String accessTokenUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret
                + "&js_code=" + weCharUserInfoDTO.getCode() + "&grant_type=authorization_code";
        // 发送HTTP GET请求，获取access_token和openid
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(accessTokenUrl, String.class);
        JSONObject json = JSON.parseObject(result);
//        String accessToken = json.getString("session_key");
        String openid = json.getString("openid");
        WeCharUserInfoDTO user =  loginImpl.searchLoginList(openid);
        if(user != null){
            return StateDTO.success(200, getMap(user));
        }
        else  {
            weCharUserInfoDTO.setOpenid(openid);
            loginMapper.addWeCharUserInfo(weCharUserInfoDTO);
            WeCharUserInfoDTO users =  loginImpl.searchLoginList(weCharUserInfoDTO.getOpenid());
            return StateDTO.success(200, getMap(users));
        }

    }



}

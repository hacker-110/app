package com.example.app.mapper;


import com.example.app.dto.WeCharUserInfoDTO;
//登录
public interface LoginMapper {
    //新增微信用户
Integer addWeCharUserInfo (WeCharUserInfoDTO weCharUserInfoDTO);
}

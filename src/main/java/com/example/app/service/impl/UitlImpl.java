package com.example.app.service.impl;

import com.example.app.dto.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UitlImpl {
    //查询用户是否存在
    @Select("select id,openid , nickName ,gender ,city ,avatarUrl,user_id from wx_userInfo where openid = #{openid}")
    WeCharUserInfoDTO searchLoginList(String openid);

    //获取banner图地址
    @Select("select id ,bannerUrl , bannerName from wx_homeBanner ")
    List<WeCharBannerDTO>  selectHomeBanner();

    //获取商品分类
    @Select("select id, moduleName  from wx_classification ")
    List<ClassifyDTO>  selectClassifyList();


    //商品详情
    @Select("select id, name ,price ,introduce , img_url  from wx_classifyList where id = #{id}")
    ClassifyListDTO selectClassifyDetails( Integer id);

    //订单列表
    @Select("select id  , name , price, num ,img_url,state ,create_time from pc_orderList where   openid = #{openid} ")
    List<OrderListDTO>  selectOrderListDTO( String openid);

    //订单列表新增
    @Insert("insert into pc_orderList ( openid , name , price , num  , img_url , state , nickName , avatarUrl) values ( #{openid} , #{name} , #{price} , #{num}  , #{img_url}  , #{state} , #{nickName} , #{avatarUrl})")
    Integer insertOrderList(OrderListDTO orderListDTO);
}

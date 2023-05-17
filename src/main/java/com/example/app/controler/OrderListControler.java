package com.example.app.controler;

import com.example.app.config.token.JwtToken;
import com.example.app.dto.OrderListDTO;
import com.example.app.dto.StateDTO;
import com.example.app.exception.Errors;
import com.example.app.service.OrderListService;
import com.example.app.service.utils.HttptokenId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app/order")
@Api(tags = "小程序订单")
public class OrderListControler {
    @Autowired
    private HttptokenId httptokenId;

    @Autowired
    OrderListService orderListService;

    @ApiOperation(value = "订单列表")
    @GetMapping("/orderList")
    @JwtToken
    public StateDTO<List<OrderListDTO>> orderList(){
        return StateDTO.success(200,orderListService.OrderLists((String) httptokenId.tokenId().get("openid")));
    }


    @ApiOperation(value = "新增订单")
    @PostMapping("/addOrderList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "商品名称",required = true),
            @ApiImplicitParam(name = "price",value = "商品价格",required = true),
            @ApiImplicitParam(name = "num",value = "购买数量",required = true),
            @ApiImplicitParam(name = "img_url",value = "商品图片",required = true),
            @ApiImplicitParam(name = "state",value = "商品分类状态",required = true)
    })
    @JwtToken
    public StateDTO addOrderList(@RequestBody OrderListDTO orderListDTO){
        orderListDTO.setNickName((String) httptokenId.tokenId().get("username"));
        orderListDTO.setAvatarUrl((String) httptokenId.tokenId().get("avatarUrl"));
        orderListDTO.setOpenid((String) httptokenId.tokenId().get("openid"));
        Integer num = orderListService.addtOrderLists(orderListDTO);
        if (num == 0){
            throw  new Errors(500,"新增失败");
        }
        else {
            return StateDTO.success(200,"");
        }
    }
}

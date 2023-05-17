package com.example.app.service;

import com.example.app.dto.OrderListDTO;
import com.example.app.service.impl.UitlImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderListService {

    @Resource
    UitlImpl uitlImpl;
    //订单列表
    public  List<OrderListDTO> OrderLists(String openid){
        List<OrderListDTO>  list = uitlImpl.selectOrderListDTO(openid);
        return list;
    }

    //订单列表新增
    public  Integer addtOrderLists(OrderListDTO orderListDTO){
        return uitlImpl.insertOrderList(orderListDTO);
    }
}

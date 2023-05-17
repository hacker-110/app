package com.example.app.controler;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//购物车
@RestController
@RequestMapping("/api/app/cart")
@Api(tags = "购物车")
public class CartControler {
}

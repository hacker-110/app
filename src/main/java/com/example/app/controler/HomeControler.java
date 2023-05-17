package com.example.app.controler;

import com.example.app.config.token.JwtToken;
import com.example.app.dto.StateDTO;
import com.example.app.dto.WeCharBannerDTO;
import com.example.app.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//首页
@RestController
@RequestMapping("/api/app/home")
@Api(tags = "小程序首页")
public class HomeControler {

    @Autowired
    private HomeService homeService;


    @ApiOperation(value = "获取banner图地址")
    @GetMapping("/banner")
    @JwtToken
    public StateDTO<List<WeCharBannerDTO>> homeBanner(){
        return StateDTO.success(200 ,    homeService.homeBanner());
    }
}

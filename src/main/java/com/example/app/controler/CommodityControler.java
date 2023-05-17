package com.example.app.controler;

import com.example.app.config.token.JwtToken;
import com.example.app.dto.ClassifyDTO;
import com.example.app.dto.ClassifyListDTO;
import com.example.app.dto.ClassifyMapDTO;
import com.example.app.dto.StateDTO;
import com.example.app.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//商品分类
@RestController
@RequestMapping("/api/app/commodity")
@Api(tags = "小程序商品分类")
public class CommodityControler {

    @Autowired
    private CommodityService commodityService;

    @ApiOperation(value = "商品分类菜单栏")
    @GetMapping("/Classify")
    @JwtToken
    public StateDTO<List<ClassifyDTO>> getClassify(){
        return  StateDTO.success(200 ,  commodityService.ClassifyList());
    }

    @ApiOperation(value = "商品列表")
    @GetMapping("/ClassifyList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品分类id"),
    })
    @JwtToken
    public StateDTO<List<ClassifyMapDTO> > getClassifyList(
            @RequestParam(value = "id" ,required = false) Integer id){
        List<ClassifyMapDTO>  list = commodityService.ClassifyLists(id);
        return  StateDTO.success(200 , list);
    }

    @ApiOperation(value = "商品详情")
    @GetMapping("/ClassifyDetails")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",required = true),
    })
    @JwtToken
    public StateDTO<ClassifyListDTO> getClassifyDetails(
            @RequestParam(value = "id" ) Integer id){
        ClassifyListDTO list = commodityService.ClassifyDetails(id);
        return  StateDTO.success(200 , list);
    }
}

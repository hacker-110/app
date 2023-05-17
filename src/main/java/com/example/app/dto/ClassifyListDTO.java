package com.example.app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClassifyListDTO {
    @ApiModelProperty(value = "商品名称")
    private  String  name;
    @ApiModelProperty(value = "商品价格")
    private  String  price;
    @ApiModelProperty(value = "商品描述")
    private  String  introduce;
    @ApiModelProperty(value = "商品图片")
    private  String  img_url;
    @ApiModelProperty(value = "是否置顶")
    private  String  top;
}

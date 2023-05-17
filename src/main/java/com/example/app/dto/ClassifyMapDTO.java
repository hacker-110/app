package com.example.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
@ApiModel("商品列表")
public class ClassifyMapDTO {
    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "商品分类名称")
    private  String  moduleName;
    @ApiModelProperty(value = "商品分类列表")
    private List<ClassifyListDTO> categoryList;

}

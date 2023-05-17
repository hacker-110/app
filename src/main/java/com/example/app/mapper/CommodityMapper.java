package com.example.app.mapper;

import com.example.app.dto.ClassifyMapDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//商品分类
public interface CommodityMapper {

    //商品列表
    List<ClassifyMapDTO> ClassifyList(
            @Param("id") Integer id);
}

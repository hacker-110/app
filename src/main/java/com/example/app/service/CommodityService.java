package com.example.app.service;

import com.example.app.dto.ClassifyDTO;
import com.example.app.dto.ClassifyListDTO;
import com.example.app.dto.ClassifyMapDTO;
import com.example.app.mapper.CommodityMapper;
import com.example.app.service.impl.UitlImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//商品分类
@Service
public class CommodityService {

    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private UitlImpl uitlImpl;
    //商品列表
    public List<ClassifyMapDTO> ClassifyLists(
            Integer id){
        return commodityMapper.ClassifyList( id );
    }

    //商品分类菜单栏
    public List<ClassifyDTO> ClassifyList(){
        List<ClassifyDTO> classifyList =  uitlImpl.selectClassifyList();
        return classifyList;
    }

    //商品详情
    public ClassifyListDTO ClassifyDetails( Integer id ){
        ClassifyListDTO classifyList =  uitlImpl.selectClassifyDetails(  id);
        return classifyList;
    }
}

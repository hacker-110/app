package com.example.app.service;

import com.example.app.dto.WeCharBannerDTO;
import com.example.app.service.impl.UitlImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//首页
@Service
public class HomeService {
    @Resource
    private UitlImpl uitlImpl;

    public List<WeCharBannerDTO> homeBanner() {
           List<WeCharBannerDTO>  banner = uitlImpl.selectHomeBanner();
        return banner;
    }
}

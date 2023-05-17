package com.example.app.controler;


import com.example.app.dto.StateDTO;
import com.example.app.dto.WeCharUserInfoDTO;
import com.example.app.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//登录
@RestController
@RequestMapping("/api/app")
@Api(tags = "小程序登录")
public class LoginControler {
    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "code码", required = true),
            @ApiImplicitParam(name = "nickName", value = "微信用户昵称", required = true),
            @ApiImplicitParam(name = "gender", value = "微信用户性别", required = true),
            @ApiImplicitParam(name = "city", value = "微信用户所在地址"),
            @ApiImplicitParam(name = "avatarUrl", value = "微信用户头像地址", required = true)
    })
  @PostMapping("/login")
  public StateDTO<WeCharUserInfoDTO> login(@RequestBody WeCharUserInfoDTO weCharUserInfoDTO)  {
      return  loginService.getWeChartUserInfo(weCharUserInfoDTO);
      }
}

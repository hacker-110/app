package com.example.app.controler;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//个人中心
@RestController
@RequestMapping("/api/app/personal")
@Api(tags = "个人中心")
public class PersonalControler {
}

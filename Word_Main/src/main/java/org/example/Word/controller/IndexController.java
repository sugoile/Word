package org.example.Word.controller;

import org.example.Word.Po.AdminRegister_PO;
import org.example.Word.api.REData;
import org.example.Word.config.JasyptUtils;
import org.example.Word.dto.AdminInfo_Param;
import org.example.Word.mapper.UAdminMapper;
import org.example.Word.model.UAdmin;
import org.example.Word.service.IndexService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @des:
 * @package: org.example.Word.controller
 * @author: xsg
 * @date: 2021/4/19
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/login")
    public REData Login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        AdminInfo_Param result = indexService.login(username, password);
        if (result == null) {
            return REData.failed("没有该账号或账号密码出错");
        }else {
            return REData.success("登录成功", result);
        }
    }

    @PostMapping("/register")
    public REData Register(@RequestParam("username") String username, @RequestParam("password") String password) {
        int result = indexService.Register(username, password);
        if (result < 0) {
            return REData.failed("注册失败,账号已存在");
        }else if (result == 0) {
            return REData.failed("注册失败");
        }
        else {
            return REData.success("注册成功", result);
        }
    }

//    @GetMapping("/test")
//    public long test(){
//        UAdmin uAdmin = new UAdmin();
//        uAdmin.setUsername("1111");
//        uAdmin.setPassword("2222");
//        int count = uAdminMapper.insertSelective(uAdmin);
//        long s = uAdmin.getId();
//        System.out.println(count + "==========" + s);
//        return s;
//    }

//    @GetMapping("/test")
//    public long test(){
//
//
//        String username = jasyptUtils.encryptPwd("");
//
//        System.out.println(username);
//        System.out.println(jasyptUtils.decyptPwd(username));
//        return 0;
//    }

}

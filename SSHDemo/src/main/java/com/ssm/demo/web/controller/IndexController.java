package com.ssm.demo.web.controller;

import com.ssm.demo.core.dto.DocDto;
import com.ssm.demo.web.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * user:ouym
 * date: 2016/11/30
 * time: 13:26
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}

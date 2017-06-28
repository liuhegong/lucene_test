package com.ssm.demo.web.controller;

import com.ssm.demo.core.constants.MyConstant;
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
 * date: 2015/7/31
 * time: 13:26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IndexService indexService;

    @RequestMapping("/index")
    public String index(@RequestParam("wd")String wd, Model model){

        //建立索引
        //indexService.createIndex(MyConstant.DATA_PATH);
        if (wd.trim().equals("")){
            return "redirect:/index/index";
        }

        List<DocDto> docDtoList = indexService.searchIndex(wd,model);
        if (!StringUtils.isEmpty(wd)) {
            model.addAttribute("query",wd);
        }
        model.addAttribute("docDtoList",docDtoList);
        model.addAttribute("listSize",docDtoList.size());
        return "result";
    }
}

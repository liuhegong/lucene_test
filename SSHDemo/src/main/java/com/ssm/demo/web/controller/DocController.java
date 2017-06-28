package com.ssm.demo.web.controller;

import com.ssm.demo.core.util.MyFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

/**
 * user:ouym
 * date: 2016/11/30
 * time: 13:26
 */
@Controller
@RequestMapping("/doc")
public class DocController {


    @RequestMapping("/view")
    public String index(@RequestParam("path")String path, Model model){
        String content = MyFileUtil.doc2String(new File(path));
        String docName = new File(path).getName();
        model.addAttribute("content",content);
        model.addAttribute("docName",docName);
        return "doc";
    }
}

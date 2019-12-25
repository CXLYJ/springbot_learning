package com.lyj.controller;

import com.lyj.entity.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyj on 2018/10/23.
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @GetMapping("/getBlogger")
    public String getBlogger(Model model){
        Blogger blogger = new Blogger(1L,"李依金","123456");
        model.addAttribute("blogger",blogger);
        return "blogger";
    }

    @GetMapping("/getList")
    public String getList(Model model) {
        Blogger blogger1 = new Blogger(1L, "李依金", "123456");
        Blogger blogger2 = new Blogger(2L, "李依金", "123456");
        List<Blogger> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }

}

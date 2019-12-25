package com.lyj.controller;

import com.lyj.lucence.ChineseSearcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lyj on 2018/11/1.
 */
@Controller
@RequestMapping("/lucene")
public class LuceneController {

    @RequestMapping("/test")
    public String test(Model model){
        //索引所在的目录
        String indexDir = "C:\\lucene";
        // 要查询的字符
        String q = "南京文明";
//        String q = "南京文化";
        try {
            List<String> list = ChineseSearcher.search(indexDir,q);
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "result";
    }

}

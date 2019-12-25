package com.lyj.controller;

import com.lyj.entity.Order;
import com.lyj.repository.OrderJPA;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyj on 2018/11/2.
 */
@Controller
@RequestMapping(value = "/jpa")
@Api(value = "springDataJpa测试")
public class JPAController {

    @Resource
    private OrderJPA orderJPA;

    @GetMapping("/orderAdd")
    public String orderAdd(){
        return  "orderAdd";
    }

    /**
     * 新增用户
     * @param order
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(Order order, Model model){
        Order orderList = orderJPA.save(order);
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Order> orderList = orderJPA.findAll();
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "list/{id}",method = RequestMethod.GET)
    public String OrderById(@PathVariable(value = "id") Long id,Model model){
        //版本的不同换成getOne查询了之前是findOne
        model.addAttribute("orderList",orderJPA.getOne(id));
        return "orderList";
    }

    /**
     * 删除用户信息，删除信息后返回剩余信息
     * */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id,Model model) {
        orderJPA.deleteById(id);
        List<Order> orderList = orderJPA.findAll();
        model.addAttribute("orderList",orderList);
        return "orderList";
    }

}

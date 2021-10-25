package com.hl.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hl2333
 */
@Controller
public class HomeController {
    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }
}

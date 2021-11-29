package com.hl.goods.controller;

import com.hl.goods.bean.Needs;
import com.hl.goods.bean.User;
import com.hl.goods.dao.NeedsDao;
import com.hl.goods.service.NeedsService;
import com.hl.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private NeedsService needsService;

    @Autowired
    private UserService userService;

    @GetMapping("homePage")
    public ModelAndView home(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        List<Needs> all = needsService.findAll();
        mv.addObject("needs", all);
        mv.addObject("users", userService.findAll());
        mv.setViewName("user/home");
        return mv;
    }


    @GetMapping("detail")
    public ModelAndView detail(Integer id, ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        Needs need = needsService.findById(id);
        mv.setViewName("user/detail");
        mv.addObject("need", need);
        mv.addObject("users", userService.findAll());
        return mv;
    }

    @GetMapping("article")
    public ModelAndView article(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        mv.setViewName("user/article");
        return mv;
    }

    @GetMapping("timeline")
    public ModelAndView timeline(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        mv.setViewName("user/timeline");
        return mv;
    }

    @GetMapping("about")
    public ModelAndView about(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        mv.setViewName("user/about");
        return mv;
    }


    private User getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User)request.getSession().getAttribute("user");
    }
}

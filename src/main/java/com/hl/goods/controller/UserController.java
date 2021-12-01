package com.hl.goods.controller;

import com.hl.goods.bean.Comment;
import com.hl.goods.bean.Goods;
import com.hl.goods.bean.Needs;
import com.hl.goods.bean.User;
import com.hl.goods.dao.NeedsDao;
import com.hl.goods.service.CommentService;
import com.hl.goods.service.GoodsService;
import com.hl.goods.service.NeedsService;
import com.hl.goods.service.UserService;
import com.hl.goods.util.TimeEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private CommentService commentService;

    @Autowired
    private GoodsService goodsService;


    @GetMapping("addNeed")
    public ModelAndView toAddNeed(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        mv.setViewName("user/addNeed");
        return mv;
    }

    @PostMapping("addNeed")
    public ModelAndView addNeed(Needs need, ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        need.setSolved(0);
        need.setCreateTime(TimeEncode.getTime());
        need.setUserId(user.getId());
        need.setChecked(0);
        needsService.save(need);
        mv.setViewName("redirect:/user/homePage");
        return mv;
    }

    @GetMapping("homePage")
    public ModelAndView home(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        List<Needs> all = needsService.findChecked(1);
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
        List<Comment> comments = commentService.findByNeedId(id);
        mv.setViewName("user/detail");
        mv.addObject("need", need);
        mv.addObject("comments", comments);
        mv.addObject("users", userService.findAll());
        return mv;
    }

    @PostMapping("comment")
    public ModelAndView comment(String editorContent, Integer id, ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        commentService.save(editorContent, id, user.getId());
        mv.setViewName("redirect:/user/detail?id=" + id);
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


    @GetMapping("addGood")
    public ModelAndView toAddGood(ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        mv.setViewName("user/addGood");
        return mv;
    }

    @PostMapping("addGood")
    public ModelAndView addGood(Goods good, ModelAndView mv) {
        User user = getUser();
        if (user == null) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录，无法进行操作");
            return mv;
        }
        goodsService.save(good, user);
        mv.setViewName("redirect:/user/homePage");
        return mv;
    }

    private User getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User)request.getSession().getAttribute("user");
    }
}

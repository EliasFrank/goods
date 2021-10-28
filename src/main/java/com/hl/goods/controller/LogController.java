package com.hl.goods.controller;

import com.hl.goods.bean.User;
import com.hl.goods.service.UserService;
import com.hl.goods.util.PasswordEncoder;
import com.hl.goods.util.TimeEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LogController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User form){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (form.getTel() == null || form.getTel().trim().equals("") || form.getPassword() == null || "".equals(form.getPassword().trim())) {
            request.setAttribute("error", "账号或密码不能为空");
            return "index";
        }
        User user = userService.findByTel(form.getTel());
        if (user == null || !user.getTel().equals(form.getTel()) ||
                !PasswordEncoder.matches(user.getPassword(), form.getPassword())){
            request.setAttribute("error", "账号或密码错误");
            return "index";
        }
        request.getSession().setAttribute("user", user);
        if (user.getRole() == 0)
            return "user/start";
        return "admin/center";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().invalidate();
        return "logout";
    }

    @PostMapping("/register")
    public String register(User user) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (user.getTel() == null || "".equals(user.getTel().trim())
                || user.getPassword() == null || "".equals(user.getPassword().trim())
                || user.getName() == null || "".equals(user.getName().trim()) ) {
            request.setAttribute("error", "不能有空字段，请重新输入");
            return "index";
        }
        user.setCreateTime(TimeEncode.getTime());
        user.setPassword(PasswordEncoder.encode(user.getPassword()));

        userService.save(user);
        request.setAttribute("error", "账号注册成功，请登录");
        return "index";
    }
}

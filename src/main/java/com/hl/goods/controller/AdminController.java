package com.hl.goods.controller;

import com.hl.goods.bean.*;
import com.hl.goods.dao.DepositoryDao;
import com.hl.goods.dao.UserDao;
import com.hl.goods.service.*;
import com.hl.goods.util.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hl2333
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private NeedsService needsService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AllService allService;

    @Autowired
    private DepositoryService depositoryService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("goodCheck")
//    @Transactional(rollbackFor = {Exception.class})
    public ModelAndView goodCheck(Integer id, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }

        goodsService.goodCheck(id);

        List<Goods> goods = goodsService.findAll();
        mv.addObject("goods", goods);
        mv.addObject("count", goods.size());
        mv.setViewName("admin/admin-role");
        return mv;
    }
    @GetMapping("goods")
    public ModelAndView goods(ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }

        List<Goods> goods = goodsService.findAll();
//        List<User> users = userService.findByGoods(goods);
        List<User> users = userService.findAll();
        mv.addObject("goods", goods);
        mv.addObject("users", users);
        mv.addObject("count", goods.size());
        mv.setViewName("admin/admin-role");
        return mv;
    }
    @GetMapping("allGoods")
    public ModelAndView allGoods(ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }

        List<All> all = allService.findAll();
        List<Depository> deps = depositoryService.findAll();
        mv.addObject("goods", all);
        mv.addObject("deps", deps);
        mv.addObject("count", all.size());
        mv.setViewName("admin/admin-cate");
        return mv;
    }
    @PostMapping("searchGoods")
    public ModelAndView searchGoods(String name, ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }

        List<All> all = allService.findByNameLike(name);
        List<Depository> deps = depositoryService.findAll();
        mv.addObject("goods", all);
        mv.addObject("deps", deps);
        mv.addObject("count", all.size());
        mv.setViewName("admin/admin-cate");
        return mv;
    }
    @PostMapping("goods")
    public ModelAndView goodsByName(@Param("username") String username, ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
//        logger.debug(username);
        List<Goods> goods = goodsService.findByName(username);
//        List<User> users = userService.findByGoods(goods);
        List<User> users = userService.findAll();
        mv.addObject("goods", goods);
        mv.addObject("users", users);
        mv.addObject("count", goods.size());
        mv.setViewName("admin/admin-role");
        return mv;
    }
    @PostMapping("depEdit")
    public ModelAndView depEditer(Depository depository, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        Depository origin = depositoryService.findById(depository.getId());
        origin.setName(depository.getName());
        origin.setDesc(depository.getDesc());
        origin.setLocation(depository.getLocation());
        depositoryService.save(origin);
        mv.setViewName("redirect:/admin/depository");
        return mv;
    }
    @GetMapping("depEdit")
    public ModelAndView depEdit(ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        Depository depository = depositoryService.findById(user.getDepositoryId());
        mv.addObject("dep", depository);
        mv.setViewName("admin/admin-edit");
        return mv;
    }
    @PostMapping("modify")
    public ModelAndView modify(String tel, String name, String password, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        user.setTel(tel);
        user.setName(name);
        user.setPassword(PasswordEncoder.encode(password));
        userService.save(user);
        mv.setViewName("admin/center");
        return mv;
    }
    @GetMapping("checked")
    public ModelAndView checked(Integer id, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        Needs need = needsService.findById(id);
        need.setChecked(1);
        needsService.save(need);
        mv.setViewName("redirect:getAllNeeds");
        return mv;
    }
    @GetMapping("solved")
    public ModelAndView solved(Integer id, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        Needs need = needsService.findById(id);
        need.setSolved(1);
        needsService.save(need);
        mv.setViewName("redirect:getAllNeeds");
        return mv;
    }
    @GetMapping("getAllNeeds")
    public ModelAndView getAllNeeds(ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }

        List<Needs> needs = needsService.findAll();
        mv.addObject("needs", needs);
        mv.addObject("count", needs.size());
        mv.setViewName("admin/order-list");
        return mv;
    }
    @PostMapping("status")
    public ModelAndView getAllByStatus(Integer check, Integer solved, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        List<Needs> needs = needsService.getAllByStatus(check, solved);
        mv.addObject("needs", needs);
        mv.addObject("count", needs.size());
        mv.setViewName("admin/order-list");
        return mv;
    }
    @GetMapping("remakePassword")
    public ModelAndView remakePassword(Integer id, ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        user = userService.findById(id);
        user.setPassword(PasswordEncoder.encode("123"));
        userService.save(user);
        mv.setViewName("redirect:user");
        return mv;
    }

    @GetMapping("user")
    public ModelAndView getUserList(ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        List<User> users = userService.findByRole(0);
        mv.addObject("users", users);
        mv.addObject("count", users.size());
        mv.setViewName("admin/member-list");
        return mv;
    }

    @GetMapping("depository")
    public ModelAndView getDepository(ModelAndView mv){
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        Depository depository = depositoryService.findById(user.getDepositoryId());
        mv.addObject("dep", depository);
        mv.setViewName("admin/admin-list");
        return mv;
    }

    @PostMapping("findByName")
    public ModelAndView findByName(String name, ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("redirect:/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        if (name == null || "".equals(name.trim())) {
            mv.setViewName("redirect:/admin/user");
            return mv;
        }
        List<User> users = userService.findByNameLikeAndRole(name, 0);
        mv.addObject("users", users);
        mv.addObject("count", users.size());
        mv.setViewName("admin/member-list");
        return mv;
    }

    @GetMapping("center")
    public ModelAndView center(ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("redirect:/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        mv.setViewName("admin/center");
        return mv;
    }

    @GetMapping("userInfo")
    public ModelAndView userInfo(ModelAndView mv) {
        User user = getUser();
        if (user == null || user.getRole() == 0) {
            mv.setViewName("redirect:/index");
            mv.addObject("error", "你还未登录或者没有管理员权限");
            return mv;
        }
        mv.addObject(user);
        mv.setViewName("admin/member-edit");
        return mv;
    }
    private User getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (User)request.getSession().getAttribute("user");
    }
}

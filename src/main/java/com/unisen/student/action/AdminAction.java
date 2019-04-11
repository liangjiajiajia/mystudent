package com.unisen.student.action;

import com.unisen.student.po.Admin;
import com.unisen.student.service.impl.AdminServiceImpl;
import com.unisen.utils.MD5Code;
import com.unisen.utils.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/pages/back/*")
public class AdminAction extends DefaultAction {

    @Resource
    private AdminServiceImpl adminService;


    public ModelAndView login2(HttpServletRequest request, Admin admin){

        // 实现登录密码加盐操作
        admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
        Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
        if (vo != null){
            //super.setMsgAndPath(mav,"admin.insert.success","admin.login.success");
            request.getSession().setAttribute("email",vo.getEmail());
            request.getSession().setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate())); // 取得最后一次登录日期操作
            System.out.println(admin);
            return null;
        }else{
            //super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
        }
        return null;
    }

    //@RequestMapping(value = "admin_login",method = RequestMethod.POST)
    public String login2(Admin admin, HttpSession session, Model model) {
        // 实现登录密码加盐操作
        admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
        Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
        admin.setLastdate(new Date());
        this.adminService.updateAdmin(admin);
        if (vo != null){
            //super.setMsgAndPath(mav,"admin.insert.success","admin.login.success");
            //request.getSession().setAttribute("email",vo.getEmail());
            //request.getSession().setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate())); // 取得最后一次登录日期操作

            session.setAttribute("email", vo.getEmail());
            session.setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate()));

            System.out.println(admin);

//            return "/pages/back/hellojava.jsp";
            return "/pages/back/index.jsp";
        }else{
            return "/login.jsp";
            //super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
        }


    }

    @RequestMapping(value = "admin_login",method = RequestMethod.POST)
    public ModelAndView login(Admin admin, HttpSession session){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pages/forward.jsp");
        // 实现登录密码加盐操作
        admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
        Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
        admin.setLastdate(new Date());
        this.adminService.updateAdmin(admin);

        if (vo != null) {

//            mav.setViewName("/pages/back/index.jsp");
            mav.addObject("msg", "登录成功！");
            mav.addObject("path", "/pages/back/index.jsp");
            session.setAttribute("email", vo.getEmail());
            session.setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate()));
            System.out.println(admin);
        }else{
            mav.addObject("msg", "登录失败！");
            //super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
        }

        return mav;
    }

//    @RequestMapping(value = "admin_login")
//    public ModelAndView login(HttpServletRequest request,Admin admin){
//        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
//        try {
//            // 实现登录密码加盐操作
//            admin.setPassword(new MD5Code().getMD5ofStr(admin.getPassword()+admin.getEmail()));
//            Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
//            if (vo != null){
//                super.setMsgAndPath(mav,"admin.insert.success","admin.login.success");
//                request.getSession().setAttribute("email",vo.getEmail());
//                request.getSession().setAttribute("lastdate",new SimpleDateFormat("yyyy-MM-dd").format(vo.getLastdate())); // 取得最后一次登录日期操作
//            }else{
//                super.setMsgAndPath(mav,"admin.insert.failure","admin.login.failure");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mav;
//    }


    @Override
    public String getText() {
        return "管理员";
    }
}

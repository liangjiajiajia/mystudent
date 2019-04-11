package com.unisen.student.action;

import com.unisen.student.po.Classes;
import com.unisen.student.service.IClassService;
import com.unisen.student.service.impl.ClassServiceImpl;
import com.unisen.utils.ObjectToJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pages/back/classes")
public class ClassAction {

    @Resource
    IClassService classService;

    @RequestMapping("classes_list")
    public void classList(HttpServletResponse response) throws IOException {

//        return classService.classList();
        response.getWriter().print(ObjectToJSON.convertorListToJson("allClasses", classService.classList()));

    }

    @RequestMapping("classes_insert")
    public String insertClass(Classes classes) {
        System.out.println("=======");
        System.out.println(classes);
        classService.insertClass(classes);
        return "classes_insert.jsp";
    }


}

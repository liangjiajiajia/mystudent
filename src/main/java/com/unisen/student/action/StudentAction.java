package com.unisen.student.action;

import com.unisen.student.po.Student;
import com.unisen.student.service.IStudentService;
import com.unisen.utils.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/student")
public class StudentAction extends DefaultAction {


    @Resource
    IStudentService studentService;

    @RequestMapping("student_insert")
    public String insertStudent(Student student) {
        System.out.println("+++++++++++++" + student);
        studentService.insertStudent(student);

        return "student_insert.jsp";
    }

    @RequestMapping("student_list")
    public void selctStudentPage(HttpServletRequest request, HttpServletResponse response) {
//       return studentService.selectStudentPage(curentPage, lineCount);
        try {
            Map<String,Object> map = this.studentService.selectStudentPage(super.getCurrentPage(),super.getLineSize());
            List<Student> all = (List<Student>) map.get("allStudent");
            Integer allRecorders = (Integer) map.get("studentCount");
            super.printObjectToListSplit(response,"allStudent",all,allRecorders);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getText() {
        return null;
    }
}

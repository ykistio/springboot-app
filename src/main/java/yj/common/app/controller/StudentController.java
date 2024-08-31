package yj.common.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yj.common.app.entity.student.Student;
import yj.common.app.service.student.StudentService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @Model: 应用 -
 * @Description: TODO
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping("/")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStutdent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);
    }
}

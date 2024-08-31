package yj.common.app.service.student;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yj.common.app.dao.student.StudentRepository;
import yj.common.app.entity.student.Student;

import java.time.LocalDate;
import java.util.*;

/**
 * @Model: 应用 -
 * @Description:
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<Student> getStudents() {
        Boolean aa = redisTemplate.hasKey("AA");
        if (aa) {
            String studentStr = redisTemplate.opsForValue().get("AA");
            Student student = JSONObject.parseObject(studentStr, Student.class);
            return Collections.singletonList(student);
        }
        return studentRepository.findAll();
    }

    public void addNewStutdent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        String studentStr = JSONObject.toJSONString(student);
        redisTemplate.opsForValue().set("AA", studentStr);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + " does not exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id " + id + " does not exists"));
        if (name != null && !name.isEmpty()
                && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && !email.isEmpty()
                && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}

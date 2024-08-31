package yj.common.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yj.common.app.dao.student.StudentRepository;
import yj.common.app.entity.student.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @Model: 应用 -
 * @Description: TODO
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student kate = new Student(1L, "kate", "kate@gmail.com", LocalDate.of(1995, 1, 1));
            Student riven = new Student(2L, "riven", "riven@gmail.com", LocalDate.of(2004, 1, 1));
            Student zed = new Student(3L, "zed", "zed@gmail.com", LocalDate.of(1999, 1, 1));
            Student jj = new Student(4L, "jj", "jj@gmail.com", LocalDate.of(2003, 1, 1));
            List<Student> list = Arrays.asList(kate, riven, zed, jj);
            studentRepository.saveAll(list);
        };
    }
}

package yj.common.app.dao.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import yj.common.app.entity.student.Student;

import java.util.Optional;

/**
 * @Description: 学生Dao
 * @Author: hyk
 * @Date: 2024/8/31
 **/
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // select * from student where email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}

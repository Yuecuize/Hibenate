package demo.Dao;

import demo.Entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Repository
public interface StudentDao {
    Collection<Student> getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void removeStudent(Student student);
    Student getStudentById(long id);
}

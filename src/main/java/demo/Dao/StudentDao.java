package demo.Dao;

import demo.Entity.Address;
import demo.Entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Repository
public interface StudentDao {
    Collection<Student> getAllStudents();
    void addStudent(Student student);
    void addStudent(Student student, Address address);
    void updateStudent(Student student);
    void removeStudentById(int id);
    Student getStudentById(int id);
}

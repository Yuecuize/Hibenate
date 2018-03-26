package demo.Service;

import demo.Dao.StudentDao;
import demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeData") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional
    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    @Transactional
    public void addStudent(Student student){
        this.studentDao.addStudent(student);
    }
    @Transactional
    public Student getStudentById(long id){
        return this.studentDao.getStudentById(id);
    };
}

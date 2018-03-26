package demo.Dao;

import demo.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("StudentDao")
@Qualifier("Postgres")
public class PgStudentDao implements StudentDao {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Collection<Student> getAllStudents() {
        Query query = em.createQuery("SELECT e FROM Student e");
        return (Collection<Student>)query.getResultList();
    }

    @Override
    public void addStudent(Student student) {
        Student student_test = new Student(22,"peter","math",100);
        em.merge(student_test);
    }

    @Override
    public void updateStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void removeStudent(Student student) {
        em.remove(student);
    }

    @Override
    public Student getStudentById(long id) {
        Student student = em.find(Student.class, id);
    //    Student student = null;
        if(student!=null){
            return student;
        }
        else {
                 Student backup = new Student(22,"peter","math",100);
                return backup;
            }

    }
}

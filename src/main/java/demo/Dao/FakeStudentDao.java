package demo.Dao;

import demo.Entity.Address;
import demo.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDao implements StudentDao {
    private static Map<Integer,Student> studentHashMap;
    private static Map<Integer,Address> addressHashMap;
    static {
        addressHashMap = new HashMap<Integer,Address>(){
            {
                put(1,new Address("Lille","France"));
                put(2,new Address("Shanghai","China"));
                put(3,new Address("NewYork","U.S"));
            }

        };
        studentHashMap = new HashMap<Integer,Student>(){
            {
                put(1,new Student(1,"Said","Computer Science",99,addressHashMap.get(1)));
                put(2,new Student(2,"Alex","Finance",88,addressHashMap.get(2)));
                put(3,new Student(3,"Anna","Math",77,addressHashMap.get(3)));
            }
        };


    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentHashMap.values();
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void removeStudent(Student student) {

    }

    @Override
    public Student getStudentById(long id) {
        return null;
    }
}

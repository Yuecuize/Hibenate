package demo.Controller;

import demo.Entity.Address;
import demo.Entity.Student;
import demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public String getAllStudent(Model model){
        Collection<Student> res = studentService.getAllStudents();
        model.addAttribute("student",res);
        return "studentsView";
    }

    @GetMapping("/addstudent")
    public String addStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("address",new Address());
        return "addStudent";
    }

    public String addStudent(@ModelAttribute Student student){
        return "addStudent";
    }

    @PutMapping(value = "/addstudent")
    public void addStudent(@ModelAttribute Student student,@ModelAttribute Address address){
        this.studentService.addStudent(student);
    }
    @GetMapping(value = "/get/{id}")
    public Student getStudentById(@PathVariable("id")long id){
        return this.studentService.getStudentById(id);
    }
}

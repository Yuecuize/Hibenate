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

    @PostMapping(value = "/addstudent")
    public String addStudent(@ModelAttribute("student") Student student,@ModelAttribute("address") Address address, Model model){
        this.studentService.addStudent(student,address);
        return "success";
    }

    public String addStudent(@ModelAttribute Student student){
        return "addStudent";
    }

    @PostMapping(value = "/get")
    public String getStudentById(@RequestParam("id") int id, Model model){

        return "redirect:/student/get/"+id;
    }

    @GetMapping(value = "/get/{id}")
    public String getStudentById(@PathVariable("id")int id,@ModelAttribute("student") Student student,Model model){
        student = this.studentService.getStudentById(id);
        model.addAttribute(student);
        return "studentsView";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudentById(@PathVariable("id") int id, Model model){
        this.studentService.removeStudentById(id);
        return "redirect:/student/all";
    }
}

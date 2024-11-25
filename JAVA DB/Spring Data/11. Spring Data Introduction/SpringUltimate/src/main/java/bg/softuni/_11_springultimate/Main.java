package bg.softuni._11_springultimate;

import bg.softuni._11_springultimate.entities.Student;
import bg.softuni._11_springultimate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final StudentService studentService;

    public Main(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Working in Spring");
//        studentService.register(new Student("Pesho"));

        Student fromDb = studentService.get(1);
        studentService.get(5);
    }
}

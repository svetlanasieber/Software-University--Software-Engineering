package bg.softuni._11_springultimate.service;

import bg.softuni._11_springultimate.entities.Student;
import bg.softuni._11_springultimate.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void register(Student student) {
        System.out.println("Register the student");
        studentRepository.save(student);
    }

    @Override
    public Student get(int id) {
        Optional<Student> byId = studentRepository.findById(id);

        return byId.orElseThrow(EntityNotFoundException::new);
    }
}

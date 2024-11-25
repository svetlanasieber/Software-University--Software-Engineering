package bg.softuni._11_springultimate.service;

import bg.softuni._11_springultimate.entities.Student;

public interface StudentService {
    void register(Student student);

    Student get(int id);
}

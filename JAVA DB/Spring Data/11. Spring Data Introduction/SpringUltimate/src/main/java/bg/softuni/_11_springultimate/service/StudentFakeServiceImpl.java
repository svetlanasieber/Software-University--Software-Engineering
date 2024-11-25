package bg.softuni._11_springultimate.service;

import bg.softuni._11_springultimate.entities.Student;

//@Service // Exception: there will be 2 beans and Spring cannot decide by itself
public class StudentFakeServiceImpl implements StudentService {
    @Override
    public void register(Student pesho) {
        System.out.println("Fake");
    }

    @Override
    public Student get(int id) {
        return null;
    }
}

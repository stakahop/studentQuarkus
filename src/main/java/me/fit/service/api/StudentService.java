package me.fit.service.api;

import java.util.List;

import me.fit.model.Student;

public interface StudentService {
	
	public void createStudent(Student student);

	public void updateStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public List<Student> getStudentsByName(String name);
	
	public Student getStudentById(Long id);
}

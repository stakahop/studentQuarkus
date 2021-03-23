package me.student.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import me.fit.model.Student;
import me.fit.service.api.StudentService;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

	@Inject
	EntityManager em;

	@Transactional
	public void createStudent(Student student) {
		em.persist(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		em.merge(student);
	}

	@Transactional
	public List<Student> getAllStudents() {

		List<Student> students = em.createNamedQuery(Student.GET_ALL_STUDENTS, Student.class).getResultList();

		return students;
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		List<Student> students = em.createNamedQuery(Student.GET_STUDENTS_BY_NAME, Student.class)
				.setParameter("ime", name).getResultList();
		return students;
	}

	@Override
	public Student getStudentById(Long id) {
		return em.find(Student.class, id);
	}

}

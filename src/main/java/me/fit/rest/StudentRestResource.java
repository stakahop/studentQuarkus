package me.fit.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.model.Student;
import me.fit.service.api.StudentService;

@Path("/rest")
public class StudentRestResource {

	@Inject
	private StudentService studentService;
	
	@Inject
	EntityManager em;

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello RESTEasy";
	}

	@POST
	@Path("addStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) {
		studentService.createStudent(student);
		return Response.ok().build();
	}
	
	@GET
	@Path("getAllStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return Response.ok(students).build();
	}
	
	@GET
	@Path("getStudentsByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentsByName(@QueryParam("name") String name) {
		List<Student> students = studentService.getStudentsByName(name);
		return Response.ok(students).build();
	}
	
	@POST
	@Path("updateStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getStudentsByName(Student student) {
		
		System.out.println("STUDENT: " + student.toString());
		studentService.updateStudent(student);
		
		return Response.ok().build();
	}

}
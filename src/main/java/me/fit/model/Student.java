package me.fit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries({ @NamedQuery(name = Student.GET_ALL_STUDENTS, query = "Select s from Student s"),
		@NamedQuery(name = Student.GET_STUDENTS_BY_NAME, query = "Select s from Student s where s.ime = :ime") })
public class Student {

	public static final String GET_ALL_STUDENTS = "Student.getAllStudents";
	public static final String GET_STUDENTS_BY_NAME = "Student.getStudentsByName";

	@Id
	@SequenceGenerator(name = "studetSequence", sequenceName = "student_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "studetSequence")
	private Long id;
	private String ime;
	private String prezime;
	private String telefon;
	private String email;

	public Student() {
		super();
	}

	public Student(Long id, String ime, String prezime, String telefon, String email) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
	}

	public Student(String ime, String prezime, String telefon, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", telefon=" + telefon + ", email="
				+ email + "]";
	}

}

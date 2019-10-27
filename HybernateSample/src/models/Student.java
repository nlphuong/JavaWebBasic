package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {

	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="StudentId")
	private Integer id;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="Gender")
	private byte gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	@Column(name="PlaceOfBirth")
	private String placeOfBirth;
	@Column(name="Subject")
	private String subject;
	
	
	
	public Student(Integer id) {
		super();
		this.id = id;
	}
	public Student() {
		super();
	}
	public Student(Integer id, String firstName, String lastName, byte gender, Date dateOfBirth, String placeOfBirth,
			String subject) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.subject = subject;
	}
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public byte getGender() {
		return gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public String getSubject() {
		return subject;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}

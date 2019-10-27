package model;

import java.util.Date;

public class Student {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private byte gender;
	private Date dateOfBirth;
	private String placeOfBirth;
	private String Subject;
	private Boolean TimeSheet[];
	public Student(Integer id, String firstName, String lastName, byte gender, Date dateOfBirth, String placeOfBirth,
			String subject) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		Subject = subject;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getSubject() {
		return Subject;
	}
	public Boolean[] getTimeSheet() {
		return TimeSheet;
	}
	public void setTimeSheet(Boolean[] timeSheet) {
		TimeSheet = timeSheet;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	
	
}

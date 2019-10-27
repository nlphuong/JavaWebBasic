package models;

import java.sql.Time;
import java.util.Date;

public class Attendance {

	private int studentId;
	private Date dated;
	private Time timed;
	public Attendance() {
		super();
	}
	
	public Attendance(int studentId, Date dated) {
		super();
		this.studentId = studentId;
		this.dated = dated;
	}

	public int getStudentId() {
		return studentId;
	}
	public Date getDated() {
		return dated;
	}
	public Time getTimed() {
		return timed;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public void setTimed(Time timed) {
		this.timed = timed;
	}
	
	
	
}

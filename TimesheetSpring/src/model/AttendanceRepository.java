package model;

public class AttendanceRepository extends BaseRepository {
	
	public int add(Attendance obj) {
		return jdbc.update("CALL AddAttendance(?,?)",
				obj.getStudentId(),obj.getDated());
	}
}

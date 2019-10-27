package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceRepository extends baseRepository {
	public int add(Attendance obj) {
		open();
		try {
			PreparedStatement pstmt = connection.prepareStatement("{CALL AddAttendance(?,?)}");
			pstmt.setInt(1, obj.getStudentId());
			pstmt.setDate(2, to(obj.getDated()));
			int ret = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}

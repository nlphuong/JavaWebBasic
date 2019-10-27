package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class StudentRepository extends baseRepository{
	
	public Map<Integer, Boolean[]> getTimesheets(Date start, Date end){
		open();
		String sql = "{CALL getTimeSheet(?,?)}";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, to(start));//error
			pstmt.setDate(2, to(end));
			ResultSet rs = pstmt.executeQuery();
			Map<Integer, Boolean[]> map = new HashMap<Integer, Boolean[]>();
			while(rs.next()) {
				int key = rs.getInt("StudentId");
				if(!map.containsKey(key)) {
					map.put(key, new Boolean[7]);
				}
				int day = (rs.getInt("Day")+5)%7;
				map.get(key)[day]=true;
			}
			rs.close();
			pstmt.close();
			connection.close();
			return map;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Student fetch(ResultSet rs) throws SQLException {
		return new Student(rs.getInt("Studentid"), 
				rs.getString("FirstName"), 
				rs.getString("LastName"), 
				rs.getByte("Gender"), 
				rs.getDate("DateOfBirth"), 
				rs.getString("PlaceOfBirth"), 
				rs.getString("Subject"));
	}
	
	public List<Student> getStudents(Date start, Date end){
		Map<Integer, Boolean[]> map = getTimesheets(start, end);
		open();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("{CALL GetStudents()}");
			List<Student> list = new ArrayList<Student>();
			while(rs.next()) {
				Student obj = fetch(rs);
				obj.setTimesheet(map.get(obj.getId()));
				list.add(obj);
			}
			rs.close();
			stmt.close();
			connection.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

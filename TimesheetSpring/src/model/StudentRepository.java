package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class StudentRepository extends BaseRepository {
	
	private Student fetch(ResultSet rs) throws SQLException {
		return new Student(rs.getInt("StudentId"), 
				rs.getString("FirstName"), 
				rs.getString("LastName"), 
				rs.getByte("Gender"),
				rs.getDate("DateOfBirth"), 
				rs.getString("PlaceOfBirth"), 
				rs.getString("Subject"));
	}
	
	public Map<Integer, Boolean[]> getTimeSheet(Date start, Date end){
		return jdbc.query("{CALL GetTimeSheet(?,?)}", (rs)->{
			Map<Integer, Boolean[]> map = new HashMap<Integer, Boolean[]>();
			while(rs.next()) {
				int key = rs.getInt("StudentId");
				if(!map.containsKey(key)) {
					map.put(key, new Boolean[7]);
				}
				int day = (rs.getInt("Day")+5)%7;
				map.get(key)[day]=true;
			}
			return map;
		},start,end);
		/*return jdbc.query("{CALL GetTimeSheet(?,?)}", new ResultSetExtractor<Map<Integer, Boolean[]>>(){

			@Override
			public Map<Integer, Boolean[]> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Map<Integer, Boolean[]> map = new HashMap<Integer, Boolean[]>();
				while(rs.next()) {
					int key = rs.getInt("StudentId");
					if(!map.containsKey(key)) {
						map.put(key, new Boolean[7]);
					}
					int day = (rs.getInt("Day")+5)%7;
					map.get(key)[day]=true;
				}
				return map;
			}
			
		},start,end);*/
	}
	
	public List<Student> getStudents(Date start, Date end){
		Map<Integer, Boolean[]> map = getTimeSheet(start, end);
		return jdbc.query("SELECT * FROM Student", (rs, index) ->{
			Student obj = fetch(rs);
			obj.setTimeSheet(map.get(obj.getId()));
			return obj;
		});
		/*Map<Integer, Boolean[]> map = getTimeSheet(start, end);
		
		return jdbc.query("SELECT * FROM Student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int index) throws SQLException {
				Student obj = fetch(rs);
				obj.setTimeSheet(map.get(obj.getId()));
				return obj;
			}
		});*/
	}
}

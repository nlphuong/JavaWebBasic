package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Attendance;
import model.AttendanceRepository;

@Controller
public class AttendanceController {

	AttendanceRepository repository = new AttendanceRepository();
	
	@PostMapping("/attendance/add.html")
	public @ResponseBody String add(int id, String d) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int ret =0;
		try {
			Date dated = df.parse(d);
			Attendance obj = new Attendance(id, dated);
			ret = repository.add(obj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(ret);
	}
}

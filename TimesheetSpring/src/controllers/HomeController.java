package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.StudentRepository;

@Controller
public class HomeController {

	StudentRepository repository = new StudentRepository();

	@GetMapping("/")
	public String index(Model m) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date start = calendar.getTime();

		String[] dates = new String[7];
		Date end = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < 7; i++) {
			end = calendar.getTime();
			calendar.add(Calendar.DAY_OF_WEEK, 1);
			dates[i] = df.format(end);
		}
		String[] gender = new String[] {"Nam","Nữ"};
		m.addAttribute("gender", gender);
		m.addAttribute("dates", dates);
		m.addAttribute("list", repository.getStudents(start, end));
		return "home/index";
	}

}

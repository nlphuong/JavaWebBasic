package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.StudentRepository;

@WebServlet("/home.html")
public class homeController extends baseController {

	StudentRepository repository = new StudentRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();//singleton pattern
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date start = calendar.getTime();
		System.out.println(start);
		String[] dates = new String[7];
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date end = null;
		for(int i = 0; i<7;i++) {
			end = calendar.getTime();
			dates[i] = df.format(end);
			calendar.add(Calendar.DAY_OF_WEEK, 1);
		}
		
		String[] gender = new String[] {"Nam","Nữ"};
		req.setAttribute("dates", dates);
		req.setAttribute("gender", gender);
		req.setAttribute("list", repository.getStudents(start, end));
		render("home/index", req, resp);
	}
}

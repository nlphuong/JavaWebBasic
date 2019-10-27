package controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import models.Pair;
import models.Student;
import models.StudentRepository;

@Controller
public class StudentsController {

	StudentRepository repository = new StudentRepository();
	
	@GetMapping("/student.html")
	public String index(Model m) {
		m.addAttribute("list", repository.getStudents());
		return "student/index";
	}
	@GetMapping("/student/add.html")
	public String add() {
		return "student/add";
	}
	@PostMapping("/student/add.html")
	public String add(Student obj) {
		repository.add(obj);
		return "redirect:/student.html";
	}
	@GetMapping("/student/delete/{id}.html")
	public String delete(@PathVariable int id) {
		repository.delete(id);
		return "redirect:/student.html";
	}
	
	
	@GetMapping("/student/edit/{id}.html")
	public String edit(@PathVariable int id, Model m) {
		List<Pair> genders = new LinkedList<Pair>();
		genders.add(new Pair(0, "Nam"));
		genders.add(new Pair(1, "Nu"));
		
		m.addAttribute("genders", genders);
		m.addAttribute("o",repository.getStudentById(id));
		return "student/edit";
	}
	@PostMapping("/student/edit/{id}.html")
	public String edit(Student obj,@PathVariable int id) {
		repository.edit(obj);
		return "redirect:/student.html";
	}
}

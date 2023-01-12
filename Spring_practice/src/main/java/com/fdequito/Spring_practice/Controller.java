package com.fdequito.Spring_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private ArrayList<Integer> gen_num;
	private Random rand;
	private final Employee_data chow = new Employee_data();

	@RequestMapping("/Greetings")
	public String Greetings() {
		return "hello good morning";
	}
	
	@RequestMapping("/Display_employee_data")
	public List<Employee> Display(){
		return chow.emp();
	}
	
	@RequestMapping("lotto_number_generator")
	public ArrayList<Integer> lotto(){
		gen_num = new ArrayList<>();
		rand = new Random();
		for (int i = 0; i < 6; i++) {
			int x=rand.nextInt(1, 58);
			gen_num.add(x);
		}
		return gen_num;
	}
}

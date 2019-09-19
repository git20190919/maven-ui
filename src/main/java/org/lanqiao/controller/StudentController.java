package org.lanqiao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	static List<Student> list = new ArrayList<>();
	static {
		for(long i = 1l; i<=20; i++) {
			Student student = new Student(i,"张三",23,"男");
			list.add(student);
		}
	}
	@RequestMapping("/data/show")
	@ResponseBody
	public Map<String,Object> getAllStudent(int page,int rows){
		System.out.println(page);
		System.out.println(rows);//select * from student limit start,pagesize    start=(page-1)*rows
		Map<String,Object> map = new HashMap<String, Object>();
		List<Student> list2 = new ArrayList<>();
		for(int i=(page-1)*rows;i<rows*page;i++) {
			list2.add(list.get(i));
		}
		map.put("total", 18);
		map.put("rows", list2);
		
		return map;
	}
}

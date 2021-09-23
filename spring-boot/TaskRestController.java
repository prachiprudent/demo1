package com.example.demo.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UI.TaskDTO;
import com.example.demo.repository.TaskEntity;
import com.example.demo.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("task")
public class TaskRestController {

	@Autowired
	TaskService service;
	
	
	@PostMapping("add")
	public void addTask(@RequestBody TaskDTO obj)
	{
		
	service.createNewTask(obj);
	}
	
	
	@GetMapping("getTasks/{selectedDate}")
	public List<TaskEntity> getTaskForTheDate(@PathVariable String selectedDate)
	{
				System.out.println("here");
		return  service.getAllTasks(selectedDate);
	}
	
	
}

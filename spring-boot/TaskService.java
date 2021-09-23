package com.example.demo.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UI.TaskDTO;
import com.example.demo.repository.TaskEntity;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repo;
	
	
	
	
	public List<TaskEntity> getAllTasks(String selectedDate)
	{
	
		//Map<String,String> map = new HashMap<String,String>();
		
		System.out.println("******** "+selectedDate);
		String[] arr =selectedDate.split(" ");
		int month=-1;
		switch(arr[1])
		{
		case "Jan" :  month =0; break;
		case "Feb" : month =1; break;
		case "Mar" : month =2; break;
		case "Apr" : month =3; break;
		case "May" : month =4; break;
		case "Jun" : month =5; break;
		case "Jul" : month =6; break;
		case "Aug" : month =7; break;
		case "Sep" : month =8; break;
		case "Oct" : month =9; break;
		case "Nov" : month =10; break;
		case "Dec" : month =11; break;
		
		}
		
		GregorianCalendar gc= new GregorianCalendar(Integer.parseInt(arr[3]),month,Integer.parseInt(arr[2]));
		Date d = new Date(gc.getTimeInMillis());

		
		List<TaskEntity> tasks  = repo.findByTaskDate(d);
		
		//tasks.stream().forEach((task)->{map.put(task.getTaskTime(),task.getTaskDesc());});
		
		return tasks;
		
		
	}
	
	public void createNewTask(TaskDTO dto)
	{
		long t = dto.getTaskDate().getTime();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(t);
		
		String time = gc.get(Calendar.HOUR_OF_DAY) +":"+ (gc.get(Calendar.MINUTE)<=9? "0"+gc.get(Calendar.MINUTE):gc.get(Calendar.MINUTE));
		System.out.println("time="+gc.get(Calendar.HOUR_OF_DAY) +":"+ gc.get(Calendar.MINUTE));
		System.out.println("here add..."+dto.getTaskDate().getTime());
		
		TaskEntity entity =new TaskEntity();
		entity.setTaskDate(dto.getTaskDate());
		entity.setTaskDesc(dto.getTaskDesc());
		entity.setTaskTime(time);
		repo.save(entity);
	}
	
}

package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{
	
	public List<TaskEntity> findByTaskDate(Date date);

}

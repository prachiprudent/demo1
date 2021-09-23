package com.example.demo.repository;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Task")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private int taskId;
	
	@Column(name="task_description")
	private String taskDesc;
	
	@Column(name="task_startdate")
	private Date taskDate;
	
	@Column(name="task_starttime")
	private String taskTime;
	
	public TaskEntity() {
		// TODO Auto-generated constructor stub
	}

	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}
	
	public String getTaskTime() {
		return taskTime;
	}
	
	public int getTaskId() {
		return taskId;
	}
	

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	@Override
	public String toString() {
		return "TaskEntity [taskId=" + taskId + ", taskDesc=" + taskDesc + ", taskDate=" + taskDate + ", taskTime="
				+ taskTime + "]";
	}

		
}

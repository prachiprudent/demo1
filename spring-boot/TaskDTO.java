package com.example.demo.UI;

import java.sql.Date;

public class TaskDTO {
	
	private String taskDesc;
	private Date taskDate;
	
	
	public TaskDTO() {
		
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
		return "TaskDTO [taskDesc=" + taskDesc + ", taskDate=" + taskDate + "]";
	}


	public TaskDTO(String taskDesc, Date taskDate) {
		super();
		this.taskDesc = taskDesc;
		this.taskDate = taskDate;
	}
	
	
	

}

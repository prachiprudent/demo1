import React from "react";
import  DatePicker from "react-datepicker";
import TimePicker from "react-timepicker";
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import './createtask.css';
import ShowTask from "./showTask";

 class CreateTask extends React.Component
{
    constructor()
    {
        super();
        this.state={
            taskDesc:'',
            taskDate:new Date(),
            arr:[],
            descerror:''

        }
    }

    handleChange=(selectedDate)=>
    {
            this.setState({taskDate:selectedDate})
    }



    getData=()=>{
        fetch("http://localhost:8080/task/getTasks/"+this.state.taskDate, {
            "method": "GET", 
          })
          .then(response => {return response.json()})
          .then(response => {
            console.log(response)
            this.setState({arr:response})
          })
          .catch(err => { console.log(err); 
          });


    }

    validate=()=>
    {
        if(!this.state.taskDesc)
        {
        this.setState({descerror:"Description cannot be empty"})
        return false;
        }   
        return true
    }

    saveTask=()=>{

        if(this.validate()){

        console.log(this.state.taskDesc+"  "+this.state.taskDate)

        fetch("http://localhost:8080/task/add", {
            "method": "POST",
            "headers":{'Content-Type':'application/json'},
            "body": JSON.stringify({
             taskDesc: this.state.taskDesc,
             taskDate: this.state.taskDate,
           })
          })
        }
    }



    render=()=>
    {
        return (<div className='c1 '>
           <div className="form-group purple-border">
                <label htmlFor="task-desc">Enter Task Description</label>
                <textarea className="form-control"
                 id="task-desc" 
                 rows="3"
                 onBlur={(event)=>{this.setState({taskDesc:event.target.value})}}
                onChange={()=>{this.setState({descerror:''})}}
                >
                </textarea>
                </div>
            <span className="text-danger">{this.state.descerror} </span>
            <div className="form-group purple-border">
            <label htmlFor="task-date">Date of Task</label>
            <DatePicker name="task-date" className="form-control"
            selected={this.state.taskDate}
            onChange={this.handleChange}
            showTimeSelect
            dateFormat="dd/MMM/yyyy HH:mm"
            onBlur={(event)=>{this.setState({taskDate:event.target.value})}}
            ></DatePicker> 
            </div>

            <p>
            <button className='btn btn-primary b1'onClick={this.getData}>show-tasks-for-date</button>
            <button className='btn btn-primary b1' onClick={this.saveTask}>save-task</button>
            </p>

            
            <ShowTask row_data={this.state.arr}></ShowTask>
            
        </div>);
    }

}   

export default CreateTask
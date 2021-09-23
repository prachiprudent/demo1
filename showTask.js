import React from "react"
import 'bootstrap/dist/css/bootstrap.min.css';

class ShowTask extends React.Component
{
    constructor(props)
    {
        super(props)
    }

    rows=()=>{
        
        var rows_data = this.props.row_data
        console.log(this.props.row_data)
        var rows =[]
        for(var i=0;i<rows_data.length;i++)
        {
            console.log(rows_data[i].taskTime+" "+rows_data[i].taskDesc)
            rows.push(<tr><td>{rows_data[i].taskTime}</td><td>{rows_data[i].taskDesc}</td></tr>)
        }
        

        return rows
    }

    render=()=>{
        return  <div>
        <table className="table table-striped">
     <thead>
    <tr key="1">
      <th scope="col">Time</th>
      <th scope="col">Task Scheduled</th>
    </tr>
    </thead>
    <tbody>
              {this.rows()}
    </tbody>
        </table>
        </div> 
    }

}

export default ShowTask
//PATIENT ALL APPOINTMENTS NAVBAR COMPONENT RENDER

import React, { useState, useEffect } from 'react';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';

// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../Styles/PatientAppointments.css'

import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

function PatientAppointments(props){

    const id = props.id;

    function DayTask({inputTime,inputDoctorName}){
        const [time, setTime] = useState(inputTime);
        const [DoctorName, setPatientName] = useState(inputDoctorName);
    
        return(
            <div className="day-task-rounded-rectangle" style={{ height: '60px' , backgroundColor : 'white' , width: '45%', position: 'relative' ,left:"28%"}}>
                <p className='PatientTimeSlot'><b>Time Slot</b> : {time}</p> <p className='DoctorName'><b>Doctor Name</b> : {DoctorName}</p>
            </div>
        );
    }
    
    function DateStamp({initDate}){
        const [date, setDate] = useState(initDate);
    
        return(
            <div className="container">
                 <div >
                 <p>{date.toString()}</p>
                </div>
            </div>
           
        );
    }
    
    function Day({inputDate,inputTasks}){
        const [date, setDate] = useState(inputDate);
        const [tasks, setItem] = useState(inputTasks);
    
        return(
            <div style={{ height: '20%' }}>
                <DateStamp initDate={date}/>
                {tasks.map(item => (
                <ul>
                    <DayTask inputTime={item.time} inputDoctorName={item.doctorName}/>
                </ul>
                ))}
            </div>
        );
    }

  const sampleTaskList= 
    [
        {
            id: "Tuesday : 11/12/2023",
            value:
            [{
                time:"9AM - 10AM",
                doctorName:"A",
            },
            {
                time:"12PM - 1PM",
                doctorName:"Pranoy Pranoy Dev Dev",
            },
            {
                time:"1PM - 2PM",
                doctorName:"PD",
            },
        ]
        },
        {
            id: "Thursday : 13/12/2023",
            value:
            [{
                time:"9AM - 10AM",
                doctorName:"A'",
            },
            {
                time:"1PM - 2PM",
                doctorName:"B'",
            }]
        },
        {
            id: "Thursday : 13/12/2023",
            value:
            [{
                time:"9AM - 10AM",
                doctorName:"A'",
            },
            {
                time:"1PM - 2PM",
                doctorName:"B'",
            }]
        },
        {
            id: "Thursday : 13/12/2023",
            value:
            [{
                time:"9AM - 10AM",
                doctorName:"A'",
            },
            {
                time:"1PM - 2PM",
                doctorName:"B'",
            }]
        }
    ];


  const taskList = sampleTaskList;

  return (
    <div className="daily-schedule-container">
        {taskList.map(item => (
            <React.Fragment key={item.id}>
                <Day inputDate={item.id} inputTasks={item.value} />
            </React.Fragment>
        ))}      
    </div>
  );
}

export default PatientAppointments;
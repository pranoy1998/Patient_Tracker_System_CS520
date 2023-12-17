//DOCTOR ALL APPOINTMENTS NAVBAR COMPONENT RENDER

import React, { useState, useEffect } from 'react';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';

// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../Styles/Appointment.css'

import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

function Appointments(props){

    function DayTask({inputTime,inputPatientName,inputPatientId}){
        const [time, setTime] = useState(inputTime);
        const [patientName, setPatientName] = useState(inputPatientName);
        const [patientId, setPatientId] = useState(inputPatientId);
    
        return(
            <div className="day-task-rounded-rectangle" style={{ height: '60px' , backgroundColor : 'white' , width: '60%', position: 'relative' ,left:"17%"}}>
                <p className='TimeSlot'><b>Time Slot</b> : {time}</p> <p className='PatientName'><b>Patient Name</b> : {patientName}</p> <p className='PatientId'><Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:props.id,UI:"PatientInfo",patientId:patientId,token:props.token}}>View Record</Link></p>
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
                    <DayTask inputTime={item.time} inputPatientName={item.patientName} inputPatientId={item.patientId}/>
                </ul>
                ))}
            </div>
        );
    }

    const taskList = [];
    axios.get('http://localhost:8000/doctors/'+props.id+'/appointments',
    { headers:{token : props.token},params:{id : props.id}}
    ).then(response => {
      taskList = response.data.list;
    })
    .catch(error => {
      console.error(error);
    });

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

export default Appointments;
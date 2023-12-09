import React, { useState, useEffect } from 'react';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';

// SLOT COMPONENT
function DayTask({inputTime,inputPatientName,inputPatientId}){
    // CHANGE IT TO DATE LATER
    const [time, setTime] = useState(inputTime);
    const [patientName, setPatientName] = useState(inputPatientName);
    const [patientId, setPatientId] = useState(inputPatientId);

    return(
        <div className="day-task-rounded-rectangle" style={{ height: '20%' }}>
                <p>{time} | {patientName} {patientId}</p>
        </div>
    );
}

// DATE STAMP
function DateStamp({initDate}){
    // CHANGE IT TO DATE LATER
    const [date, setDate] = useState(initDate);

    return(
        <div className="container">
             <div >
             <p>{date.toString()}</p>
            </div>
        </div>
       
    );
}

// DATE STAMP
function Day({inputDate,inputTasks}){
    // CHANGE IT TO DATE LATER
    const [date, setDate] = useState(inputDate);
    const [tasks, setItem] = useState(inputTasks);

    console.log("Tasks: ",tasks);
    return(
        <div className="day-appointments-container" style={{ height: '20%' }}>
            <DateStamp initDate={date}/>
        {/* <p>{data.message}</p> */}
        {/* <p>{data.value}</p> */}
        {/* Other child component UI */}

        {/* INCLUDE DATE COMPONENT */}
        {/* LIST OF SLOTS */}
        {/* <li> */}
            {tasks.map(item => (
            <ul>
                <DayTask inputTime={item.time} inputPatientName={item.patientName} inputPatientId={item.patientId}/>
            </ul>
            ))}
        {/* </li> */}
        </div>
    );
}

function Appointments({ inputTaskList }) {
  // Initialize state in the child component
  const [data, setData] = useState(inputTaskList);
  // Sample data array

//   const location = useLocation();
//   console.log(location.state.message);

  const sampleTaskList= 
    [
        {
            id: new Date(2011,11,1).toString(),
            value:
            [{
                time:"9 AM",// improve later
                patientName:"Alex",
                patientId:"123"
            },
            {
                time:"10 AM",// improve later
                patientName:"Alexis",
                patientId:"133"
            },
            {
                time:"11 AM",// improve later
                patientName:"Alexis",
                patientId:"133"
            },
            {
                time:"12 PM",// improve later
                patientName:"Alexis",
                patientId:"133"
            },
            {
                time:"1 PM",// improve later
                patientName:"Alexis",
                patientId:"133"
            },
        ]
        },// task list for that day
        {
            id: new Date(2011,11,2).toString(),
            value:
            [{
                time:"9 AM",// improve later
                patientName:"Alex",
                patientId:"123"
            },
            {
                time:"9 AM",// improve later
                patientName:"Alexis",
                patientId:"133"
            }]
        },// task list for that day
        {
            id: new Date(2011,11,3).toString(),
            value:
            [{
                time:"9 AM",// improve later
                patientName:"Alex",
                patientId:"123"
            },
            {
                time:"9 AM",// improve later
                patientName:"Alexis",
                patientId:"133"
            }]
        },// task list for that day
    ];


  const taskList = sampleTaskList; // day wise task list
  /*
  {
    "Monday":[{},{}],// task list for that day
    "Tuesday":[{},{}],
  }
  */
  useEffect(() => {
    // 
  }, [data]);

  return (
    <div className="daily-schedule-container">
      {/* <p>{data.message}</p> */}
      {/* <p>{data.value}</p> */}
      {/* Other child component UI */}

      {/* INCLUDE DATE COMPONENT */}
      {/* LIST OF SLOTS */}
      {/* <li> */}
        {taskList.map(item => (
            <React.Fragment key={item.id}>
                <Day inputDate={item.id} inputTasks={item.value} />
            </React.Fragment>
        ))}
      {/* </li> */}
      
    </div>
  );
}

export default Appointments;
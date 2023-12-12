// import React, { useState, useEffect } from 'react';

// // SLOT COMPONENT
// function Slots({itemName}){
//     // CHANGE IT TO DATE LATER
//     const [slotTime, setSlotTime] = useState(itemName.id);
//     const [slotData, setSlotData] = useState(itemName.itemName);

//     return(
//         <div className="container">
//              <div className="rounded-rectangle" style={{ width: '15%', margin: '0 auto', backgroundColor: 'white' }}>
//                 <p>{slotTime}</p>
//             </div>
//             <div className="rounded-rectangle" style={{ width: '50%', margin: '0 auto', backgroundColor: 'white' }}>
//                 <p>{slotData}</p>
//             </div>
//         </div>
//     );
// }

// // DATE STAMP
// function DateStamp({initDate}){
//     // CHANGE IT TO DATE LATER
//     const [date, setDate] = useState(initDate);

//     return(
//         <div className="container">
//              <div >
//              <p>{date.toDateString()}</p>
//             </div>
//         </div>
       
//     );
// }

// function DailySchedule(props){

//   const id = props.id;

//   const data = {
//       item:  [
//         { id: 9, itemName: 'Task 1' },
//         { id: 10, itemName: 'Task 2' },
//         { id: 11, itemName: 'Task 3' },
//         { id: 12, itemName: 'Task 4' },
//         { id: 1, itemName: 'Task 5' },
//         { id: 2, itemName: 'Task 6' },
//         { id: 3, itemName: 'Task 7' },
//         { id: 4, itemName: 'Task 8' },
//         { id: 5, itemName: 'Task 9' },
//         { id: 6, itemName: 'Task 10' },],
//       date:new Date(2021,11,12)
//     };

 
//   // Sample data array
//   const items = data.item;
//   const date = data.date;

//   useEffect(() => {
//     // 
//   }, [data]);

//   return (
//     <div className="daily-schedule-container">
//         <DateStamp initDate={date}/>
//       {/* <p>{data.message}</p> */}
//       {/* <p>{data.value}</p> */}
//       {/* Other child component UI */}

//       {/* INCLUDE DATE COMPONENT */}
//       {/* LIST OF SLOTS */}
//       {/* <li> */}
//         {items.map(item => (
//           <ul key={item.id}>
//             <Slots itemName={item} />
//           </ul>
//         ))}
//       {/* </li> */}
      
//     </div>
//   );
// }

// export default DailySchedule;

import React, { useState, useEffect } from 'react';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './Appointment.css'
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

function DailySchedule(props){

    function DayTask({inputTime,inputPatientName,inputPatientId}){
        const [time, setTime] = useState(inputTime);
        const [patientName, setPatientName] = useState(inputPatientName);
        const [patientId, setPatientId] = useState(inputPatientId);
    
        return(
            <div className="day-task-rounded-rectangle" style={{ height: '60px' , backgroundColor : 'white' , width: '60%', position: 'relative' ,left:"17%"}}>
                <p className='TimeSlot'><b>Time Slot</b> : {time}</p> <p className='PatientName'><b>Patient Name</b> : {patientName}</p> <p className='PatientId'><b>Patient Id</b> : <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:props.id,UI:"PatientInfo",patientId:patientId}}>{patientId}</Link></p>
            </div>
        );
    }
    
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
    
    function Day({inputDate,inputTasks}){
        const [date, setDate] = useState(inputDate);
        const [tasks, setItem] = useState(inputTasks);
    
        return(
            <div /*className="day-appointments-container"*/ style={{ height: '20%' }}>
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

  const sampleTaskList= 
    [
        {
            id: "Tuesday : 11/12/2023",
            value:
            [{
                time:"9AM - 10AM",
                patientName:"A",
                patientId:"1"
            },
            {
                time:"12PM - 1PM",
                patientName:"Pranoy Pranoy Dev Dev",
                patientId:"2"
            },
            {
                time:"1PM - 2PM",
                patientName:"PD",
                patientId:"3"
            },
            {
              time:"3PM - 4PM",
              patientName:"Pranooy...",
              patientId:"13"
            },
            {
              time:"5PM - 6PM",
              patientName:"PD",
              patientId:"3122"
            },
            {
              time:"6PM - 7PM",
              patientName:"PD",
              patientId:"31"
            }
        ]
        }
    ];


  const taskList = sampleTaskList;

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
    </div>
  );
}

export default DailySchedule;
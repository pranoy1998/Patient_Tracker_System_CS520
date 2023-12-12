import React from 'react';
import './App.css';
import './Slot.css';
import './DailySchedule.css';
//import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Link, Routes } from 'react-router-dom';

import Login from './Login';

import PatientLanding from './Patient_Landing';
import DoctorLanding from './Doctor_Landing';

import DailySchedule from './DailySchedule';
import Appointments from './Appointment';
import PatientList from './PatientList';
import PatientInfo from './PatientInfo';

import MyInfo from './MyInfo';
import PatientAppointments from './PatientAppointments';

function App() {

  // const DailyScheduleData= {
  //   item:  [
  //     { id: 9, itemName: 'Task 1' },
  //     { id: 10, itemName: 'Task 2' },
  //     { id: 11, itemName: 'Task 3' },
  //     { id: 12, itemName: 'Task 4' },
  //     { id: 1, itemName: 'Task 5' },
  //     { id: 2, itemName: 'Task 6' },
  //     { id: 3, itemName: 'Task 7' },
  //     { id: 4, itemName: 'Task 8' },
  //     { id: 5, itemName: 'Task 9' },
  //     { id: 6, itemName: 'Task 10' },],
  //   date:new Date(2021,11,12)
  // };
  // const ds = <DailySchedule initData={DailyScheduleData}/>;
  // const aps = <Appointments />;
  // const pl = <PatientList/>;
  // const pi = <PatientInfo/>;

  return (

    <Router>
      <Routes>

        <Route exact path="/" element={<Login/>}/>

        <Route path='/PatientLanding' exact={true} element={<PatientLanding/>}/>
        <Route path='/DoctorLanding' exact={true} element={<DoctorLanding/>}/>

        <Route path='/Appointments' exact={true} element={<Appointments/>}/>
        <Route path='/DailySchedule' exact={true} element={<DailySchedule/>}/>
        <Route path='/PatientList' exact={true} element={<PatientList/>}/>
        <Route path='/PatientInfo' exact={true} element={<PatientInfo/>}/>

        <Route path='/MyInfo' exact={true} element={<MyInfo/>}/>
        <Route path='/PatientAppointments' exact={true} element={<PatientAppointments/>}/>

      </Routes>
    </Router>

    // <div className="App">
    //   {/* <Login /> */}
    //   <Router>
    //   <div>
    //     <nav>
    //       <ul>
    //         <li>
    //           <Link to="/">Login</Link>
    //         </li>
    //         <li>
    //           <Link to="/DailySchedule">Daily Schedule</Link>
    //         </li>
    //         <li>
    //           <Link to="/Appointments">Appointments</Link>
    //         </li>
    //         <li>
    //           <Link to="/PatientList">PatientList</Link>
    //         </li>
    //         <li>
    //           <Link to="/PatientInformation">PatientInformation</Link>
    //         </li>
    //         {/* <li>
    //           <Link to="/Login">Contact</Link>
    //         </li> */}
    //       </ul>
    //     </nav>

    //     <hr />
    //     <Routes>
    //       <Route path="/" exact component={Login} />
    //       <Route path="/DailySchedule" element={ds} />
    //       <Route path="/Appointments" element={aps} />
    //       <Route path="/PatientList" element={pl}/>
    //       <Route path="/PatientInformation" element={pi}/>
    //       {/* <Route path="/patientList/`{var}`" element={aps Input={}} /> */}
    //     </Routes>
       
    //     {/* <Route path="/Login" component={Login} /> */}
    //   </div>
    // </Router>

    //   {/* <DailySchedule initData={DailyScheduleData}/> */}
    // </div>

  );
}

export default App;
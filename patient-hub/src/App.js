//Main App.js loader

import React from 'react';
import './Styles/App.css';
import './Styles/Slot.css';
import './Styles/DailySchedule.css';
import { BrowserRouter as Router, Switch, Route, Link, Routes } from 'react-router-dom';

import Login from './Landing Components/Login';

import PatientLanding from './Landing Components/Patient_Landing';
import DoctorLanding from './Landing Components/Doctor_Landing';

import DailySchedule from './NavBar Components/DailySchedule';
import Appointments from './NavBar Components/Appointment';
import PatientList from './NavBar Components/PatientList';
import PatientInfo from './NavBar Components/PatientInfo';

import PatientAppointments from './NavBar Components/PatientAppointments';

function App() {

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

        <Route path='/PatientAppointments' exact={true} element={<PatientAppointments/>}/>

      </Routes>
    </Router>
  );
}

export default App;
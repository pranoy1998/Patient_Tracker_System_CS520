import React from 'react';
import './App.css';
import './Slot.css';
import './DailySchedule.css';
import { BrowserRouter as Router, Switch, Route, Link, Routes } from 'react-router-dom';

import Login from './Login';

import PatientLanding from './Patient_Landing';
import DoctorLanding from './Doctor_Landing';

import DailySchedule from './DailySchedule';
import Appointments from './Appointment';
import PatientList from './PatientList';
import PatientInfo from './PatientInfo';

import PatientAppointments from './PatientAppointments';

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
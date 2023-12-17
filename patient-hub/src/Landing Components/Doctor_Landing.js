//DOCTOR LANDING UI COMPONENT RENDER

import React from 'react';
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import { useState } from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import { NavLink } from 'react-router-dom';
import '../Styles/Patient_Landing.css'
import Appointments from '../NavBar Components/Appointment';
import DailySchedule from '../NavBar Components/DailySchedule';
import PatientList from '../NavBar Components/PatientList';
import PatientInfo from '../NavBar Components/PatientInfo';

const DoctorLanding = ({}) => {
  
  const location = useLocation();
  const id = location.state.id;
  const token = location.state.token;

  return (
    <div class="main">

  <div>
    <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse">
      <div class="list-group">

        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"DailySchedule",token:token}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Daily Schedule</span>
        </button>
        </Link>
        
        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"Appointment",token:token}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Appointments</span>
        </button>
        </Link>

        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"PatientList",token:token}}>
        <button className="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Patients</span>
        </button>
        </Link>

        <Link to='/' style={{ textDecoration:'none'}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Logout</span>
        </button>
        </Link>

      </div>
    </nav>
  </div>
  <div className='topnavbar'>
    <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light fixed-top">
      <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
        aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
      </button>
      <h1 class="navbar-brand">
        Doctor Portal
      </h1>
    </nav>
  </div>
  
  <div class="maincontent">
    {location.state.UI == "Appointment" ? <Appointments id={id} token={token}/>:<></>}
    {location.state.UI == "DailySchedule" ? <DailySchedule id={id} token={token}/>:<></>}
    {location.state.UI == "PatientList" ? <PatientList id={id} token={token}/>:<></>}
    {location.state.UI == "PatientInfo" ? <PatientInfo id={location.state.patientId} UI="DoctorView" token={token}/>:<></>}
  </div>

</div>
);
};

export default DoctorLanding;
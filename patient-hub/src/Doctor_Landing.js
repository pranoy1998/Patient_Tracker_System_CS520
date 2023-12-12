import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import { useState } from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import {
  CDBSidebar,
  CDBSidebarContent,
  CDBSidebarFooter,
  CDBSidebarHeader,
  CDBSidebarMenu,
  CDBSidebarMenuItem,
} from 'cdbreact';
import { NavLink } from 'react-router-dom';
import './Patient_Landing.css'
import Appointments from './Appointment';
import DailySchedule from './DailySchedule';
import PatientList from './PatientList';
import PatientInfo from './PatientInfo';

const DoctorLanding = ({}) => {
  
  const location = useLocation();
  const id = location.state.id;
  console.log(location.state);

  // const LogOut = () => {
  //   const navigate = useNavigate();
  //   navigate('/PatientLanding');
  // };  

  const myState = {
    id: id,
    UI: ""
  };

  return (
    <div class="main">

<div>
<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse">
    {/* <div class="position-sticky"> */}
      <div class="list-group">

        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"DailySchedule"}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Daily Schedule</span>
        </button>
        </Link>
        
        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"Appointment"}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Appointments</span>
        </button>
        </Link>

        <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"PatientList"}}>
        <button className="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Patients</span>
        </button>
        </Link>

        <Link to='/' style={{ textDecoration: 'none' }}>
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
    {location.state.UI == "Appointment" ? <Appointments id={id}/>:<></>}
    {/* {location.state.UI == "DailySchedule" ? <DailySchedule/>:<></>} */}
    {/* {location.state.UI == "PatientList" ? <PatientList/>:<></>} */}
    {/* {location.state.UI == "PatientInfo" ? <PatientInfo/>:<></>} */}
    </div>
  </div>
  );
};

export default DoctorLanding;
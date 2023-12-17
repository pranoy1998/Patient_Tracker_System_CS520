//PATIENT LANDING UI COMPONENT RENDER

import React from 'react';

// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

import { useLocation } from 'react-router-dom';

import '../Styles/Patient_Landing.css'
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import PatientAppointments from '../NavBar Components/PatientAppointments';
import PatientInfo from '../NavBar Components/PatientInfo';

const PatientLanding = ({}) => {

  const location = useLocation();
  const id = location.state.id;
  const token = location.state.token;

  return (
    <div class="main">

<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse">
      <div class="list-group">

        <Link to='/PatientLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"PatientInfo",patientId:id,token:token}}>
        <a href="#" class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>My Info</span>
        </a>
        </Link>
      
        <Link to='/PatientLanding' style={{ textDecoration: 'none' }} state={{id:id,UI:"Appointment",token:token}}>
        <a href="#" class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Appointments</span>
        </a>
        </Link>
      
        <Link to="/" style={{ textDecoration: 'none' }}>
        <a class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <span>Logout</span>
        </a>
        </Link>
      
      </div>
  </nav>

    <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light fixed-top">
      <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
        aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
      </button>
      <h1 class="navbar-brand">
        Patient Portal
      </h1>
    </nav>

    <div class="maincontent">
      {location.state.UI == "PatientInfo" ? <PatientInfo id={id} UI="PatientView" token={token}/>:<></>}
      {location.state.UI == "Appointment" ? <PatientAppointments id={id} token={token}/>:<></>}
    </div>

  </div>
  );
};

export default PatientLanding;
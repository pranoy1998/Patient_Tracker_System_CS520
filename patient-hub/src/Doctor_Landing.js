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

const DoctorLanding = ({}) => {
  
  const location = useLocation();
  const id = location.state.id;
  //alert(id);

  // const LogOut = () => {
  //   const navigate = useNavigate();
  //   navigate('/PatientLanding');
  // };  

  return (
    <div class="main">

<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse">
    {/* <div class="position-sticky"> */}
      <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Daily Schedule</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Appointments</span>
        </a>
        <a href="#" class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Patients</span>
        </a>
        <Link to="/Appointments" style={{ textDecoration: 'none' }} state={{message:'Hey!'}}>
        <button class="list-group-item list-group-item-action py-2 ripple" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i><span>Logout</span>
        </button>
        </Link>
      </div>
  </nav>

  {/* <Link to={{ pathname: '/', state: {message: 'Hey!'} }}></Link> */}

    <nav id="main-navbar" class="navbar navbar-expand-lg navbar-light fixed-top">
      <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
        aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
      </button>
      <h1 class="navbar-brand">
        Doctor Portal
      </h1>
    </nav>

    <div class="maincontent">
    <h1>Component Loading........</h1>
    </div>
  </div>
  );
};

export default DoctorLanding;
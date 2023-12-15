import {
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCheckbox,
  MDBBtn,
  MDBIcon,
  MDBTextArea
} from 'mdb-react-ui-kit';
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
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
import './PatientInfo.css'
import Appointments from './Appointment';
import DailySchedule from './DailySchedule';
import PatientList from './PatientList';

const SingleTextBox = (props) => {
  
  const [text, setText] = useState(props.labelValue);
  const handleTextChange = (event) => {
    setText(event.target.value);
  };

  return(

    <div className='input-container'>
      <MDBRow>
        <MDBCol className="mx-2">
          <label style={{'font-size': 17.5}}>{props.labelInput}</label>
          <div>
          {
            !props.inputTypeTextArea[props.labelInput] && <MDBInput value={props.labelValue}  readOnly={props.readOnlyCheck[props.labelInput]} />
          }
          {
            (props.inputTypeTextArea[props.labelInput] && !props.readOnlyCheck[props.labelInput]) && <textarea
            value={text}
            onChange={handleTextChange}
            rows="4"
            cols="55"
            placeholder={props.labelValue}
          />
          }
          {
            (props.inputTypeTextArea[props.labelInput] && props.readOnlyCheck[props.labelInput]) && <textarea
            value={props.labelValue}
            rows="4"
            cols="55"
          />
          }
          </div>
        </MDBCol>
      </MDBRow>
    </div>

  );
}

export default function PatientInfo() {
  const location = useLocation();
  const id = location.state.id;

  const readOnlyCheck = {
    "Patient Name" : true,
    "Patient Age":true,
    "Patient Id":true,
    "Medical History":true,
    "Current Medications":true,
    "Previous Diagnosis":true,
    "Doctor Notes":false,
    "Patient Notes":true
  }
  const inputTypeTextArea = {
    "Doctor Notes":true,
    "Patient Notes":true
  }

  const fields = ["Patient Name",
    "Patient Age",
    "Patient Id",
    "Medical History",
    "Current Medications",
    "Previous Diagnosis",
    "Doctor Notes",
    "Patient Notes"
  ];
  const fieldValues = ["Alex",
  "23",
  "P12345",
  "TB",
  "axylone",
  "Sed",
  "* patient depressed \n * needs help \n * no money",
  "N/A"
]


  return (

    <div className="main">
      {/* SideBar CSS Code */}
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
    {/* Top Bar code */}
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
    
    <div className="maincontent">
      {fields.map((fieldName,index) => {
        console.log("field:", fieldName)
        console.log("index: ",index)
        return SingleTextBox({
          'labelInput':fieldName,
          'labelValue':fieldValues[index],
          'readOnlyCheck':readOnlyCheck,
          'inputTypeTextArea':inputTypeTextArea
        })
      })}
    </div>
  
  </div>

    
  );
}
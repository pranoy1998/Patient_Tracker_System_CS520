import React, { useState, useEffect } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import {
  CDBSidebar,
  CDBSidebarContent,
  CDBSidebarFooter,
  CDBSidebarHeader,
  CDBSidebarMenu,
  CDBSidebarMenuItem,
} from 'cdbreact';
import {
  MDBRow,
  MDBCol,
  MDBInput,
  MDBCheckbox,
  MDBBtn,
  MDBIcon,
  MDBTextArea
} from 'mdb-react-ui-kit';
import './PatientInfo.css'

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
          rows="3"
          cols="63"
          placeholder={props.labelValue}
        />
        }
        {
          (props.inputTypeTextArea[props.labelInput] && props.readOnlyCheck[props.labelInput]) && <textarea
          value={props.labelValue}
          rows="3"
          cols="63"
        />
        }
        </div>
      </MDBCol>
    </MDBRow>
  </div>
  );
}

function PatientInfo(props){

  const id = props.id;
  const view = props.UI;

  const [file, setFile] = useState()

  function handleChange(event) {
    setFile(event.target.files[0]);
  }

  if(file){
    console.log(file);
  }

  var readOnlyCheck = {
    "PATIENT NAME" : true,
    "PATIENT AGE":true,
    "PATIENT ID":true,
    "MEDICAL HISTORY":true,
    "CURRENT MEDICATIONS":true,
    "PREVIOUS DIAGNOSIS":true,
    "DOCTOR NOTES":true,
    "PATIENT NOTES":true
  }

  var inputTypeTextArea = {
    "DOCTOR NOTES":true,
    "PATIENT NOTES":true
  }

  if(view == "DoctorView"){
    readOnlyCheck['DOCTOR NOTES'] = false;
  }

  if(view == "PatientView"){
    readOnlyCheck['PATIENT NOTES'] = false;
  }

  const fields = ["PATIENT NAME",
    "PATIENT AGE",
    "PATIENT ID",
    "MEDICAL HISTORY",
    "CURRENT MEDICATIONS",
    "PREVIOUS DIAGNOSIS",
    "DOCTOR NOTES",
    "PATIENT NOTES"
  ];

  const fieldValues = [
  "Alex",
  "23",
  "P12345",
  "TB",
  "axylone",
  "xyz",
  "Patient depressed \n needs help",
  "N/A"
];

  return (

    <div>

      {fields.map((fieldName,index) => {
        return SingleTextBox({
          'labelInput':fieldName,
          'labelValue':fieldValues[index],
          'readOnlyCheck':readOnlyCheck,
          'inputTypeTextArea':inputTypeTextArea
        })
      })}

      <div className='Upload'>
        <input type="file" onChange={handleChange}/>
        <button type="submit" className="btn btn-outline-primary">Upload</button>
      </div>

    </div>
    
  );
}

export default PatientInfo;
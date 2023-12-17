//PATIENT INFO VIEW COMPONENT RENDER.....FOR NOTH DOCTOR AND PATIENT VIEW

import React, { useState, useEffect } from 'react';
// import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
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
import '../Styles/PatientInfo.css'

const SingleTextBox = (props) => {
  console.log("Props: ")
  console.log(props)
  const [text, setText] = useState(props.labelValue);
  var editable = false;
  if(props.UI == 'PatientView' && props.labelInput == 'PATIENT NOTES'){
    editable = true;
  }
  if(props.UI == 'DoctorView' && props.labelInput == 'DOCTOR NOTES'){
    editable = true;
  }

  const handleTextChange = (event) => {
    setText(event.target.value);
  };

  const saveInfo = () => {
    if(props.UI == 'DoctorView'){
      axios.get('http://localhost:8000/patients/' + props.patientId + '/doctornotes',
  {headers:{token : props.token}, params:{notes : fieldValues[6]}}
  ).then(response => {
    //response
  })
  .catch(error => {
    console.error(error);
  });
    }else{
      axios.get('http://localhost:8000/patients/' + props.patientId + '/patientnotes',
  {headers:{token : props.token}, params:{notes : fieldValues[7]}}
  ).then(response => {
    //response
  })
  .catch(error => {
    console.error(error);
  });
    }

  }

  return(
  <div className='input-container'>
    <MDBRow>
      <MDBCol className="mx-2">
        <label style={{'font-size': 17.5}}>{props.labelInput}</label>
        <div>
        {
          !props.inputTypeTextArea[props.labelInput] && <MDBInput value={props.labelValue}  readOnly={true} />
        }
        {
          (props.inputTypeTextArea[props.labelInput] && editable) && 
          <div>
            <textarea
              value={text}
              onChange={handleTextChange}
              rows="3"
              cols="63"
              placeholder={props.labelValue}
            />
            <button type="submit" className="btn btn-outline-primary" onClick={saveInfo}>Save Info</button>
           </div>
          (props.inputTypeTextArea[props.labelInput] && editable) && 
          <div>
            <textarea
              value={text}
              onChange={handleTextChange}
              rows="3"
              cols="63"
              placeholder={props.labelValue}
            />
            <button type="submit" className="btn btn-outline-primary" onClick={saveInfo}>Save Info</button>
           </div>
        }
        {
          (props.inputTypeTextArea[props.labelInput] && !editable) && 
          <div>
            <textarea
              value={text}
              rows="3"
              cols="63"
              placeholder={props.labelValue}
            />
           </div>
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

  var inputTypeTextArea = {
    "DOCTOR NOTES":true,
    "PATIENT NOTES":true
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

  var fieldValues = [];
  axios.get('http://localhost:8000/patients/' + props.patientId,
  {headers:{token : props.token}, params:{id : props.patientId}}
  ).then(response => {
    fieldValues = response.data.list;
  })
  .catch(error => {
    console.error(error);
  });

  return (
    <div>
      {fields.map((fieldName,index) => {
        return SingleTextBox({
          'labelInput':fieldName,
          'labelValue':fieldValues[index],
          'inputTypeTextArea':inputTypeTextArea,
          'UI':view
        })
      })}
    </div>
  );
}

export default PatientInfo;
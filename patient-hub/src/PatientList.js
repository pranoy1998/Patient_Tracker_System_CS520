import React, { useState, useEffect } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody, MDBCol } from 'mdb-react-ui-kit';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './PatientList.css'

// function Patient({PatientId,PatientName}){
//     const pid = PatientId;
//     const pname= PatientName;
//     return(
//         <tr className='custom-divider'>
//           {/* <th scope='row'>1</th> */}
//           <td>{pid}</td>
//           <td>{pname}</td>
//           <td><Link to="/{pid}">View</Link></td>
//         </tr>
//     );
// }

function PatientList(props){

    const id = props.id;

    function PatientEntry({inputPatientId,inputPatientName}){
      const [NamePatient, setPatientName] = useState(inputPatientName);
      const [IdPatient, setPatientId] = useState(inputPatientId);
    
    return(
        <ul>
          <div className="day-task-rounded-rectangle" style={{ height: '60px' , backgroundColor : 'white' , width: '38%', position: 'relative' ,left:"27%"}}>
              <p className='PatientListName'><b>Patient Name</b> : {NamePatient}</p> <p className='PatientListId'><b>Patient Id</b> : <Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:props.id,UI:"PatientInfo",patientId:IdPatient}}>{IdPatient}</Link></p>
          </div>
        </ul>
      );
    }

    //Fetch all Patient List....under this Doctor...using Doctor ID
    const patientlist=[
        {
            Name:"Pranoy",
            id:"1",
        },{
            Name:"Pranoy Pranoy Dev Dev",
            id:"2",
        },{
            Name:"PD",
            id:"3",
        }
    ];

  return (
    <div>
    
    <MDBCol md="6" style={{marginLeft:"36%" , marginTop:"10px", width:"22%"}}>
      <div className="active-pink-3 active-pink-4 mb-4">
        <input className="form-control" type="text" placeholder="--Please search using Name or Id--" aria-label="Search" />
      </div>
    </MDBCol>

    {/* <MDBTable align="middle"> */}
      {/* <MDBTableHead>
        <tr>
          <th scope='col'>#</th>
          <th scope='col'>First</th>
          <th scope='col'>Handle</th>
        </tr>
      </MDBTableHead> */}
      {/* <MDBTableBody> */}
        {/* {patientlist.map(item =>{
                return <Patient PatientId={item.id} PatientName={item.PatientName}></Patient>
        })} */}

        {patientlist.map(item => (
            <React.Fragment key={item.id}>
                <PatientEntry inputPatientId={item.id} inputPatientName={item.Name}/>
            </React.Fragment>
        ))}

      {/* </MDBTableBody> */}
    {/* </MDBTable> */}

    </div>
  );
}

export default PatientList;
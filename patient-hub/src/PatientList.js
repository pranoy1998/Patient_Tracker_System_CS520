import React from 'react';
import { MDBTable, MDBTableHead, MDBTableBody } from 'mdb-react-ui-kit';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

function Patient({PatientId,PatientName}){
    const pid = PatientId;
    const pname= PatientName;
    console.log("Pid", pid)
    return(
        <tr className='custom-divider'>
          {/* <th scope='row'>1</th> */}
          <td>{pid}</td>
          <td>{pname}</td>
          <td><Link to="/{pid}">View</Link></td>
        </tr>
    );
}

export default function PatientList({patientList}) {
    const plist=[
        {
            id:"1",
            PatientName:"Alex",
        },{
            id:"2",
            PatientName:"Alexis",
        },{
            id:"3",
            PatientName:"Alexa",
        }
    ];
    console.log(plist)
  return (
    <MDBTable align="middle">
      <MDBTableHead>
        <tr>
          <th scope='col'>#</th>
          <th scope='col'>First</th>
          <th scope='col'>Last</th>
          <th scope='col'>Handle</th>
        </tr>
      </MDBTableHead>
      <MDBTableBody>
        {plist.map(item =>{
                return <Patient PatientId={item.id} PatientName={item.PatientName}></Patient>
        })}
      </MDBTableBody>
    </MDBTable>
  );
}
//DOCTOR PATIENT LIST NAVBAR COMPONENT RENDER
import React, { useState, useEffect } from 'react';
import { MDBTable, MDBTableHead, MDBTableBody, MDBCol } from 'mdb-react-ui-kit';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../Styles/PatientList.css'


function PatientList(props){

  const patientlist = [];
  axios.get('http://localhost:8000/doctors/' + props.id + '/patients',
  {headers:{token : props.token}, params:{id : props.id}}
  ).then(response => {
    patientlist = response.data.list;
  })
  .catch(error => {
    console.error(error);
  });

  const id = props.id;
  function PatientEntry({inputPatientId,inputPatientName}){
      const [NamePatient, setPatientName] = useState(inputPatientName);
      const [IdPatient, setPatientId] = useState(inputPatientId);
   
    return(
        <ul>
          <div className="day-task-rounded-rectangle" style={{ height: '60px' , backgroundColor : 'white' , width: '38%', position: 'relative' ,left:"27%"}}>
              <p className='PatientListName'><b>Patient Name</b> : {NamePatient}</p> <p className='PatientListId'><Link to='/DoctorLanding' style={{ textDecoration: 'none' }} state={{id:props.id,UI:"PatientInfo",patientId:IdPatient}}>View Record</Link></p>
          </div>
        </ul>
      );
    }

    const [searchInput, setSearchInput] = useState("");

    const handleChange = (e) => {
      e.preventDefault();
      setSearchInput(e.target.value);
    };

    var filteredList = patientlist;

    if (searchInput.length > 0){
      filteredList = patientlist.filter(patient => patient.Name.toLowerCase().includes(searchInput.toLowerCase()));
    };

  return (
    <div>
    
    <MDBCol md="6" style={{marginLeft:"36%" , marginTop:"10px", width:"22%"}}>
      <div className="active-pink-3 active-pink-4 mb-4">
        <input style={{textAlign: 'center'}} className = "form-control" type = "text" placeholder = " -- Please search using Name -- " aria-label = "Search" onChange={handleChange} value={searchInput} />
      </div>
    </MDBCol>

        {filteredList.map(item => (
            <React.Fragment key={item.id}>
                <PatientEntry inputPatientId={item.id} inputPatientName={item.Name}/>
            </React.Fragment>
        ))}

    </div>
  );
}

export default PatientList;
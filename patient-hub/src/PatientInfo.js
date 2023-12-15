import React, { useState, useEffect } from 'react';

export default function PatientInfo(props){

  const [file, setFile] = useState()

  function handleChange(event) {
    setFile(event.target.files[0]);
  }

  if(file){
    console.log(file);
  }

  return(
    <div>
      <h1>Here at Patients Info Page for patientid : {props.id}</h1>

    <div className="m-3">
        <input type="file" onChange={handleChange}/>
        <button type="submit" className="btn btn-outline-primary">Upload</button>
    </div>

    </div>
  );
  }
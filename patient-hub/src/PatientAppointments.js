import React from 'react';

const PatientAppointments = (props) => {

    const id = props.id;

    return (
        <div class="main">
            <h1>Appointments Page for patient : {props.id} </h1>
        </div>
    );
  };
  
  export default PatientAppointments;
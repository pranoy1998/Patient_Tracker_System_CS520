import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';

const DoctorLanding = ({}) => {
  
  const location = useLocation();
  const id = location.state.id;

  //alert(id);

  return (
    <div>
      <h1>Hello Doctor</h1>
    </div>
  );
};

export default DoctorLanding;
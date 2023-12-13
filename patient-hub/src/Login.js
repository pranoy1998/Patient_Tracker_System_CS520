import React, { useEffect, useState } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './Login.css';
import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Routes, Link } from 'react-router-dom';
import {MDBBtn,MDBContainer,MDBRow,MDBCol,MDBInput} from 'mdb-react-ui-kit';
import PatientLanding from './Patient_Landing';
import DoctorLanding from './Doctor_Landing';

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState('');
  var [loginsuccess, setSuccess] = useState('');
  const navigate = useNavigate();

  //const location = useLocation();
  // //if(location.state){
     //console.log(location.state);
  // //}

  const handleLogin = () => {

      //Using DB Auth API.....to set up response and id values
      if(username == "Pranoy"){
        var response = "Success";
      }else{
        var response = "Failure";
      }
      const id = "12321";

      // const history = useHistory();

      // const handleNavigate = () => {
      //   // Pass the variable in the state object
      //   history.push('/PatientLanding', { unique_id: patient_unique_id });
      // };

      if(response == "Failure"){
        //navigate('.');
        setSuccess(0);
        return;
      }

      // if(response == "Success"){
      //   setSuccess(1);
      // }

      if(userType == "Patient" && response == "Success"){
        const targetUrl = '/PatientLanding';
        navigate(targetUrl,{state:{id : id, UI: "PatientLanding"}});
      }

      if(userType == "Doctor"  && response == "Success"){
        const targetUrl = '/DoctorLanding';
        navigate(targetUrl, {state:{id : id, UI: "DoctorLanding"}});
      }

    // //Redirecting based on userType
    // if (userType === 'Patient') {
    //   history.push('/Patient_Landing');
    // } else if (userType === 'Doctor') {
    //   history.push('/Doctor_Landing');
    // }
  };

  return (
    // <Router>
    <div className='login'>
    {/* <div className="Banner">
      <h2>Welcome to the Patient Hub....Tracking health at your fingertips</h2>
    </div>
    <div className="login-container">
      <form>
        <div className="mb-3" style={{ display: 'flex', alignItems: 'center' }}>
          <label htmlFor="username" className="form-label" style={{ marginRight: '9%', fontWeight: 'bold'}}>
            Username
          </label>
          <input
            type="text"
            className="form-control"
            id="username"
            value={username}
            placeholder="Please enter your username"
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="mb-3" style={{ display: 'flex', alignItems: 'center' }}>
          <label htmlFor="password" className="form-label" style={{ marginRight: '10%', fontWeight: 'bold' }}>
            Password
          </label>
          <input
            type="password"
            className="form-control"
            id="password"
            value={password}
            placeholder="Please enter your password"
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div className="mb-3" style={{ display: 'flex', alignItems: 'center' }}>
          <label htmlFor="userType" className="form-label" style={{ marginRight: '9.5%', fontWeight: 'bold' }}>
            User Type
          </label>
          <select
            className="form-control"
            id="userType"
            value={userType}
            onChange={(e) => setUserType(e.target.value)}
            required
          >
            <option value="" disabled hidden>
              Please select from below options
            </option>
            <option value="Patient">Patient</option>
            <option value="Doctor">Doctor</option>
          </select>
        </div>
        <button type="button" className="btn btn-primary" onClick={handleLogin}>
        Login
        </button>
      </form>
    </div> */}

    <div className="Banner">
      <h2>Welcome to the Patient Hub....Tracking health at your fingertips</h2>
    </div>

    <div className="Auth-form-container">
      <form className="Auth-form">
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>User Name</label>
            <input
              className="form-control mt-1"
              type="text"
              id="username"
              value={username}
              placeholder="-- Please enter your username --"
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              className="form-control mt-1"
              type="password"
              id="password"
              value={password}
              placeholder="-- Please enter your password --"
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-group mt-3">
            <label>User Type</label>
          <select
            className="form-control"
            id="userType"
            value={userType}
            onChange={(e) => setUserType(e.target.value)}
            required
          >
            <option value="" disabled hidden>
              -- Please select an option --
            </option>
            <option value="Patient">Patient</option>
            <option value="Doctor">Doctor</option>
          </select>
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary" onClick={handleLogin}>
              Submit
            </button>
          </div>
          {loginsuccess == 0 && window.location.href == "http://localhost:3000/?" ? <p class="authfailed">Invalid Credentials !!....Please try again</p>:<></>}
        </div>
      </form>
    </div>
    </div>

  /* /*  { <Routes>
        <Route path="/PatientLanding"></Route>
        <Route path="/DoctorLanding"></Route>
    </Routes> */

    // </Router> */}
  );
};

export default Login;
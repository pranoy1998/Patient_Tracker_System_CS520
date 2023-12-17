//ON LOAD LOGIN UI COMPONENT RENDER
import React, { useEffect, useState } from 'react';

import '../Styles/Login.css';

import { useHistory ,useNavigate, useLocation } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Routes, Link } from 'react-router-dom';
import {MDBBtn,MDBContainer,MDBRow,MDBCol,MDBInput} from 'mdb-react-ui-kit';
import axios from 'axios';

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState('');
  var [loginsuccess, setSuccess] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {

    var id;
    var token;
    var response_msg;

    axios.post('http://localhost:8000/login',
    {
      username: username,
      password: password,
      role: userType
    }
    ).then(response => {
      token = response.data.token;
      id = response.data.userid;
      response_msg = response.data.message;
    })
    .catch(error => {
      console.error(error);
    });
    
    if(response_msg == "Authentication Failure"){
      setSuccess(0);
      return;
    }

      if(userType == "Patient" && response_msg == "Success" && token){
        const targetUrl = '/PatientLanding';
        navigate(targetUrl,{state:{id : id, UI: "PatientLanding" , token : token}});
      }

      if(userType == "Doctor"  && response_msg == "Success" && token){
        const targetUrl = '/DoctorLanding';
        navigate(targetUrl, {state:{id : id, UI: "DoctorLanding", token : token}});
      }
  };

  return (
    <div className='login'>

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
  );
};

export default Login;
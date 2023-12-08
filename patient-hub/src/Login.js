import React, { useEffect, useState } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './Login.css';
import { useHistory ,useNavigate } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Routes, Link } from 'react-router-dom';
//import {MDBBtn,MDBContainer,MDBRow,MDBCol,MDBInput} from 'mdb-react-ui-kit';
import PatientLanding from './Patient_Landing';
import DoctorLanding from './Doctor_Landing';

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState('');
  const navigate = useNavigate();
  var loginsuccess = 1;

  const handleLogin = () => {
      
      var response = "Failure";
    
      if(response == "Failure"){
        loginsuccess = 0;
      }

      if(response == "Success"){
        loginsuccess = 1;
      }

      if(userType == "Patient"){
        const targetUrl = '/PatientLanding';
        navigate(targetUrl);
      }

      if(userType == "patient"){
        const targetUrl = '/DoctorLanding';
        navigate(targetUrl);
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
          {/* <p className="forgot-password text-right mt-2">
            Forgot <a href="#">password?</a>
          </p> */}
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
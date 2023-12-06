import React, { useState } from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './Login.css';
import { useHistory } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
//import {MDBBtn,MDBContainer,MDBRow,MDBCol,MDBInput} from 'mdb-react-ui-kit';
import PatientLanding from './Patient_Landing';
import DoctorLanding from './Doctor_Landing';

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState('');
  const history = useHistory();

  const handleLogin = () => {   
    if (!username || !password || !userType){
        alert('Please fill out all fields to proceed');
        return;
      }

    // Redirecting based on userType
    if (userType === 'Patient') {
      history.push('/Patient_Landing');
    } else if (userType === 'Doctor') {
      history.push('/Doctor_Landing');
    }
  };

  return (
    <Router>
    <div className='login'>
    <div className="Banner">
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
            <option value="patient">Patient</option>
            <option value="doctor">Doctor</option>
          </select>
        </div>
        <button type="button" className="btn btn-primary" onClick={handleLogin}>
          Login
        </button>
      </form>
    </div>

    </div>

    <Switch>
        <Route path="/Patient_Landing">
          <PatientLanding />
        </Route>
        <Route path="/Doctor_Landing">
          <DoctorLanding />
        </Route>
      </Switch>

    </Router>
  );
};

export default Login;
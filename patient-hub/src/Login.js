import React, { useState } from 'react';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState(''); // Initialize user type

  const handleLogin = () => {
    // Add your login logic here
    console.log('Username: ' + username);
    console.log('Password: ' + password);
    console.log('User Type: ' + userType);
  }

  return (
    <div className="login-container">
      <h2>Welcome to the Patient Hub</h2>
      <div className="input-container">
        <label>Username:</label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div className="input-container">
        <label>Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div className="input-container">
        <label>User Type:</label>
        <select
          value={userType}
          onChange={(e) => setUserType(e.target.value)}
        >
          <option value="">Select User Type</option>
          <option value="Patient">Patient</option>
          <option value="Doctor">Doctor</option>
        </select>
      </div>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;
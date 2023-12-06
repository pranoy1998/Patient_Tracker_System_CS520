import React from 'react';
import './App.css';
import Login from './Login';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useHistory } from 'react-router-dom';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Login />
    </div>
  );
}

export default App;
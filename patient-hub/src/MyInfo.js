import React from 'react';

const MyInfo = (props) => {
    
    const id = props.id;
    
    return (
        <div class="main">
            <h1>MyInfo Page for patient : {props.id} </h1>
        </div>
    );
  };
  
  export default MyInfo;
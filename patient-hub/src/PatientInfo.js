import React from 'react';
import {
  MDBInput,
  MDBCol,
  MDBRow,
  MDBCheckbox,
  MDBBtn,
  MDBIcon
} from 'mdb-react-ui-kit';

export default function PatientInfo() {
  return (
    <form>
      <MDBRow className='mb-4'>
        <MDBCol>
        <MDBInput label='Example label' id='form1' type='text' />
        </MDBCol>
        <MDBCol>
          <MDBInput id='form3Example2' label='Last name' />
        </MDBCol>
      </MDBRow>
      <MDBInput className='mb-4' type='email' id='form3Example3' label='Email address' />
      <MDBInput className='mb-4' type='password' id='form3Example4' label='Password' />

      <MDBBtn type='submit' className='mb-4' block>
        Save
      </MDBBtn>
    </form>
  );
}
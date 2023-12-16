import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import { BrowserRouter } from 'react-router-dom'; // Import BrowserRouter
import DoctorLanding from './Landing Components/Doctor_Landing';
import Login from './Landing Components/Login';
import PatientLanding from './Landing Components/Patient_Landing';

// Mock the react-router-dom's useLocation
jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useLocation: jest.fn(),
}));

describe('DoctorLanding Component', () => {
  it('renders DoctorLanding component correctly', () => {
    // Mock the useLocation hook
    const mockLocation = {
      state: { id: 'someId', UI: 'Appointment' },
    };
    require('react-router-dom').useLocation.mockReturnValue(mockLocation);

    render(
      // Wrap DoctorLanding in BrowserRouter
      <BrowserRouter>
        <DoctorLanding />
      </BrowserRouter>
    );

    // Add your assertions based on your UI
    expect(screen.getByText('Doctor Portal')).toBeInTheDocument();
    expect(screen.getByText('Daily Schedule')).toBeInTheDocument();
    expect(screen.getByText('Appointments')).toBeInTheDocument();
    expect(screen.getByText('Patients')).toBeInTheDocument();
    expect(screen.getByText('Logout')).toBeInTheDocument();
  });

  // Add additional tests as needed
});

describe('Login Component', () => {
  it('renders Login component correctly', () => {
    render(
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );

    // Add your assertions based on your UI
    expect(screen.getByText('Sign In')).toBeInTheDocument();
    expect(screen.getByText('Submit')).toBeInTheDocument();
  });
  // Add additional tests as needed
});

// describe('PatientLanding Component', () => {
//   it('renders PatientLanding component correctly', () => {
//     // Mock the useLocation hook
//     const mockLocation = {
//       state: { id: 'someId', UI: 'PatientInfo' },
//     };
//     require('react-router-dom').useLocation.mockReturnValue(mockLocation);

//     render(
//       <BrowserRouter>
//         <PatientLanding />
//       </BrowserRouter>
//     );

//     // Add your assertions based on your UI
//     expect(screen.getByText('My Info')).toBeInTheDocument();
//     expect(screen.getByText('Appointments')).toBeInTheDocument();
//     expect(screen.getByText('Logout')).toBeInTheDocument();
//     expect(screen.getByText('Patient Portal')).toBeInTheDocument();
//     // Add more assertions based on your UI components
//   });

//   // it('handles navigation to PatientInfo correctly', () => {
//   //   const mockNavigate = jest.fn();
//   //   require('react-router-dom').useNavigate.mockReturnValue(mockNavigate);

//   //   render(
//   //     <BrowserRouter>
//   //       <PatientLanding />
//   //     </BrowserRouter>
//   //   );

//   //   fireEvent.click(screen.getByText('My Info'));

//   //   // Ensure the navigate function is called with the correct arguments
//   //   expect(mockNavigate).toHaveBeenCalledWith('/PatientLanding', {
//   //     state: { id: 'someId', UI: 'PatientInfo', patientId: 'someId' },
//   //   });
//   // });

//   // it('handles navigation to Appointments correctly', () => {
//   //   const mockNavigate = jest.fn();
//   //   require('react-router-dom').useNavigate.mockReturnValue(mockNavigate);

//   //   render(
//   //     <BrowserRouter>
//   //       <PatientLanding />
//   //     </BrowserRouter>
//   //   );

//   //   fireEvent.click(screen.getByText('Appointments'));

//   //   // Ensure the navigate function is called with the correct arguments
//   //   expect(mockNavigate).toHaveBeenCalledWith('/PatientLanding', {
//   //     state: { id: 'someId', UI: 'Appointment' },
//   //   });
//   // });

//   // Add more tests based on your component's behavior
// });

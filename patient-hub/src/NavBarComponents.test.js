import React from 'react';
import { render, screen, getByLabelText } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import { BrowserRouter } from 'react-router-dom';
import Appointments from './NavBar Components/Appointment'; // Change the path accordingly
import DailySchedule from './NavBar Components/DailySchedule';
import PatientAppointments from './NavBar Components/PatientAppointments';
import PatientInfo from './NavBar Components/PatientInfo';
import PatientList from './NavBar Components/PatientList';
import 'intersection-observer';

// Mock the react-router-dom's useLocation for this specific test
jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useLocation: jest.fn(),
}));

describe('Appointments Component', () => {
  it('renders Appointments component correctly', () => {
    // Mock the useLocation hook for this specific test
    const mockLocation = {
      state: { id: 'someId', UI: 'Appointment' },
    };
    require('react-router-dom').useLocation.mockReturnValue(mockLocation);

    // Sample task list for testing
    const sampleTaskList = [
      {
        id: 'Tuesday : 11/12/2023',
        value: [
          {
            time: '9AM - 10AM',
            patientName: 'PD',
            patientId: '1',
          },
          // Add more tasks as needed
        ],
      },
      // Add more dates with tasks as needed
    ];

    render(
      // Wrap Appointments in BrowserRouter for testing
      <BrowserRouter>
        <Appointments id={mockLocation.state.id} />
      </BrowserRouter>
    );

    // Add your assertions based on your UI
    // Example: Check if the component renders the patient names correctly
    expect(screen.getByText("Tuesday : 11/12/2023")).toBeInTheDocument();
    // Add more assertions based on your UI components
  });
});


describe('DailySchedule Component', () => {
    it("renders today's appointments component correctly", () => {
      // Mock the useLocation hook for this specific test
      const mockLocation = {
        state: { id: 'someId', UI: 'Appointment' },
      };
      require('react-router-dom').useLocation.mockReturnValue(mockLocation);
  
      // Sample task list for testing
      const sampleTaskList = [
        {
          id: 'Tuesday : 11/12/2023',
          value: [
            {
              time: '9AM - 10AM',
              patientName: 'A',
              patientId: '1',
            },
            // Add more tasks as needed
          ],
        },
        // Add more dates with tasks as needed
      ];
  
      render(
        // Wrap DailySchedule in BrowserRouter for testing
        <BrowserRouter>
          <DailySchedule id={mockLocation.state.id} />
        </BrowserRouter>
      );
  
      // Add your assertions based on your UI
      // Example: Check if the component renders the patient names correctly
      expect(screen.getByText('Tuesday : 11/12/2023')).toBeInTheDocument();
      // Add more assertions based on your UI components
    });
  });

  describe('PatientAppointments Component', () => {
    const sampleTaskList = [
      "A","B","C","D"
    ];
  
    it('renders without crashing', () => {
      render(
        <BrowserRouter>
          <PatientAppointments taskList={sampleTaskList} />
        </BrowserRouter>
      );
    });
  
    it('renders the correct number of Day components', () => {
      const { getAllByTestId } = render(
        <BrowserRouter>
          <PatientAppointments taskList={sampleTaskList} />
        </BrowserRouter>
      );
  
      const dayComponents = getAllByTestId('test');
      expect(dayComponents.length).toBe(sampleTaskList.length);
    });
  });

  describe('PatientInfo Component', () => {
    const mockId = 'mockId';
    const mockUI = 'PatientView';
  
    it('renders without crashing', () => {
      render(<PatientInfo id={mockId} UI={mockUI} />);
    });
  
    it('renders input fields correctly', () => {
      render(<PatientInfo id={mockId} UI={mockUI} />);
  
      expect(screen.getByText("MEDICAL HISTORY")).toBeInTheDocument();
  
      // Add more assertions for other input fields as needed
    });
  });

describe('PatientList Component', () => {
    const mockId = 'mockId';
  
    it('renders without crashing', () => {
      render(
        <BrowserRouter>
          <PatientList id={mockId} />
        </BrowserRouter>
      );
    });
  
    it('displays patient entries correctly', () => {
      const { getByText } = render(
        <BrowserRouter>
          <PatientList id={mockId} />
        </BrowserRouter>
      );
  
    //   expect(screen.getByText(/Patient Name.*Pranoy/).closest('.PatientListName')).toHaveTextContent('Pranoy');
    const patientNameElements = screen.getAllByText("Patient Name");
    
    expect(patientNameElements[0]).toBeInTheDocument();

    });
  
    // it('filters patients based on search input', () => {
    //   const { getByPlaceholderText, getByText } = render(
    //     <BrowserRouter>
    //       <PatientList id={mockId} />
    //     </BrowserRouter>
    //   );
  
    //   const searchInput = getByPlaceholderText(/please search using name/i);
  
    //   fireEvent.change(searchInput, { target: { value: 'Pranoy' } });
  
    //   const filteredPatient = getByText(/Pranoy/i);
    //   const nonFilteredPatient = getByText(/PD/i);
  
    //   expect(filteredPatient).toBeInTheDocument();
    //   expect(nonFilteredPatient).not.toBeInTheDocument();
    // });
  
    // it('navigates to the patient record on link click', () => {
    //   const { getByText } = render(
    //     <BrowserRouter>
    //       <PatientList id={mockId} />
    //     </BrowserRouter>
    //   );
  
    //   const viewRecordLink = getByText(/view record/i);
  
    //   fireEvent.click(viewRecordLink);
  
    //   // Add assertions to verify navigation behavior, for example, checking the updated URL or rendered content on the target page.
    // });
  });

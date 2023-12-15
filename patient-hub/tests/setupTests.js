import '@testing-library/jest-dom';
import '@testing-library/jest-dom/extend-expect';

import { render, screen } from '@testing-library/react'
import DoctorLanding from '../src/Landing Components/Doctor_Landing';

test("Example 1 renders successfully", () => {
    render(<DoctorLanding/>);

    const element = screen.getByText(/first test/i);

    expect(element).toBeInTheDocument();
})
import { render, screen } from '@testing-library/react';
import React from 'react';
import App from './App';

test('renders the header component with the welcome message', () => {
  const { getByText } = render(<App />);
  const welcomeText = getByText('Welcome to the CityBike App!');
  expect(welcomeText).toBeInTheDocument();
});





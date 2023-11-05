import { render, screen } from '@testing-library/react';
import React from 'react';
import StationList from "./StationList";
import { MemoryRouter } from 'react-router-dom';

test('renders StationList component', () => {
    render(<StationList />);
    const stationListComponent = screen.getByTestId('station-list'); // Add data-testid to your component
    expect(stationListComponent).toBeInTheDocument();
});
test('renders the header component with the welcome message', () => {
    const { getByText } = render(<StationList />);
    const welcomeText = getByText('List of stations');
    expect(welcomeText).toBeInTheDocument();
});

test('displays the list of stations', async () => {
    // You can use a test double for your API request
    const mockData = [
        { name: 'Station 1' },
        { name: 'Station 2' },
    ];
    global.fetch = jest.fn().mockResolvedValue({
        json: () => mockData,
    });

    render(
        <MemoryRouter>
            <StationList />
        </MemoryRouter>
    );

    // Wait for the component to fetch and render the stations
    await screen.findByText('Station 1');
    await screen.findByText('Station 2');

    expect(screen.getByText('Station 1')).toBeInTheDocument();
    expect(screen.getByText('Station 2')).toBeInTheDocument();
});

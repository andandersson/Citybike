import { render, screen, act } from '@testing-library/react';
import React from 'react';
import SingleStationView from './SingleStationView';
import { MemoryRouter, Route, Routes } from 'react-router-dom';

test('renders loading message while data is being fetched', () => {
    const { container } = render(
        <MemoryRouter initialEntries={['/stations/stationName']}>
            <Routes>
                <Route path="/stations/:stationName" element={<SingleStationView />} />
            </Routes>
        </MemoryRouter>
    );

    expect(container).toHaveTextContent('Loading...');
});

test('renders station data after successful fetch', async () => {
    const mockStationData = {
        stationName: 'Station 1',
        stationAddress: '123 Main St',
        journeysFromStation: 100,
        journeysToStation: 75,
        averageDistanceOfJourneysFromStation: 2.5,
        averageDurationOfJourneysFromStation: 15,
    };

    global.fetch = jest.fn().mockResolvedValue({
        json: () => Promise.resolve(mockStationData),
    });

    const { container } = render(
        <MemoryRouter>
            <SingleStationView />
        </MemoryRouter>
    );

    await screen.findByText('Station name:');

    // Use expect(container).toHaveTextContent to check the text content
    expect(container).toHaveTextContent(`Station name:${mockStationData.stationName}`);
    expect(container).toHaveTextContent(`Station address:${mockStationData.stationAddress}`);
    expect(container).toHaveTextContent(`Amount of journeys from station:${mockStationData.journeysFromStation}`);
    expect(container).toHaveTextContent(`Amount of journeys to station:${mockStationData.journeysToStation}`);
    expect(container).toHaveTextContent(`Average distance of journeys from station:${mockStationData.averageDistanceOfJourneysFromStation} km`);
    expect(container).toHaveTextContent(`Average duration of journeys from station:${mockStationData.averageDurationOfJourneysFromStation} minutes`);

});

import React, { useState, useEffect }from 'react';
import App from "../App";
function StationList() {
    const [stations, setStations] = useState([]);

    useEffect(() => {
        console.log("Fetching station data...");

        // Make an API call when the component mounts
        fetch('http://localhost:8888/stations') // Replace with your API endpoint
            .then((response) => response.json())
            .then((data) => {
                setStations(data);
                console.log("Stations:", data); // Log the retrieved stations
            });
    }, []);
    return (
            <div>
                <h2>List of Station Names</h2>
                <div style={{ maxHeight: '400px', overflowY: 'scroll' }}> {/* Adjust the height as needed */}

                    <ul style={{ listStyleType: 'none' }}>
                    {stations.map((stationName) => (
                        <li key={stationName.id}>{stationName.name}</li>
                    ))}
                </ul>
                </div>
            </div>
    );
}
export default StationList;

import React, { useState, useEffect }from 'react';
import { Link } from 'react-router-dom';
import './StationList.css';


/**
 * Here the station list is displayed on the frontpage of the application.
 * @returns a list of the stations.
 * @constructor
 */
function StationList() {
    const [stations, setStations] = useState([]);

    useEffect(() => {
        console.log("Fetching station data...");

        fetch('http://localhost:8888/stations') // Replace with your API endpoint
            .then((response) => response.json())
            .then((data) => {
                setStations(data);
            });
    }, []);


    return (
            <div className="station-list" data-testid="station-list">
                <h2>List of stations</h2>
                <div style={{ maxHeight: '400px', overflowY: 'scroll' }}> {/* Adjust the height as needed */}
                    <ul style={{ listStyleType: 'none' }}>
                        {stations.map((station) => (
                            <li key={station.name}>
                                <Link to={`/stations/${station.name}`} className="link-styling">{station.name}</Link>
                            </li>
                        ))}
                </ul>
                </div>
            </div>
    );
}
export default StationList;

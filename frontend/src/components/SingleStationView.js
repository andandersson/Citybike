import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import './SingleStationView.css'


/**
 * Here is the view of a single station. When clicking on a station in the station list,
 * the user is redirected here. There is displayed info about station name, address and
 * other parameters.
 * @returns {Element}
 * @constructor
 */
function SingleStationView() {
    const navigate = useNavigate();
    const { stationName } = useParams();
    const [station, setStation] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8888/stations/${stationName}`)
            .then((response) => {
                if (!response.ok) {
                    // If the response status is not ok, navigate to the NotFound component
                    navigate('/404');
                }
                return response.json();
            })
            .then((data) => {
                setStation(data);
            });
    }, [stationName, navigate]);



    if (!station) {
        // Display a loading indicator or message while data is being fetched
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>Info about the station {station.stationName}:</h2>
            <h2>Station name:</h2>{station.stationName}
            <h2>Station address:</h2>{station.stationAddress}
            <h2>Amount of journeys from station:</h2>{station.journeysFromStation}
            <h2>Amount of journeys to station:</h2>{station.journeysToStation}
            <h2>Average distance of journeys from station:</h2>{station.averageDistanceOfJourneysFromStation} km
            <h2>Average duration of journeys from station:</h2>{station.averageDurationOfJourneysFromStation} minutes
            <br/>
            <br/>
            <button className="back-to-list" onClick={() => navigate('/stations')}>Go Back to the list with stations</button>
        </div>
    );
}

export default SingleStationView;

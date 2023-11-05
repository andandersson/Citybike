import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';


/**
 * Here is the view of a single station. When clicking on a station in the station list,
 * the user is redirected here. There is displayed info about station name, address and
 * other parameters.
 * @returns {Element}
 * @constructor
 */
function SingleStationView() {
    const { stationName } = useParams();
    const [station, setStation] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8888/stations/${stationName}`) // Correct URL with template literals
            .then((response) => response.json())
            .then((data) => {
                setStation(data); // Use setStation to update the state
            });
    }, [stationName]);
    if (!station) {
        // Display a loading indicator or message while data is being fetched
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>Station name:</h2>{station.stationName}
            <h2>Station address:</h2>{station.stationAddress}
            <h2>Amount of journeys from station:</h2>{station.journeysFromStation}
            <h2>Amount of journeys to station:</h2>{station.journeysToStation}
            <h2>Average distance of journeys from station:</h2>{station.averageDistanceOfJourneysFromStation}
            <h2>Average duration of journeys from station:</h2>{station.averageDurationOfJourneysFromStation}
        </div>
    );
}

export default SingleStationView;

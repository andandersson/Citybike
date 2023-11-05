import './App.css';
import StationList from './components/StationList';
import SingleStationView from "./components/SingleStationView";
import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Header from "./components/Header";
import NotFound from "./components/NotFound";

/**
 * The starting point of the frontend. Here the header is rendered, as well as the list with
 * the stations. There are routing to the view of a single station.
 * @returns {Element}
 * @constructor
 */

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                <Routes>
                    <Route path="/stations/" element={<StationList />} />
                    <Route path="/stations/:stationName" element={<SingleStationView/>} />
                    <Route path="*" element={<NotFound />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;

import React from 'react';
import './Header.css';

/**
 * Rendering the header component with the info text.
 * @returns {Element}
 * @constructor
 */
function Header() {
    return (
        <header className="App-header">
            <h1>Welcome to the CityBike App!</h1>
            <p >Here is a list of all the citybike-stations in the Helsinki region. Just click on a station to view additional info about its usage.</p>
        </header>
    );
}

export default Header;

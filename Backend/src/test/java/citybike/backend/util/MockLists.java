package citybike.backend.util;

import citybike.backend.entity.Journey;
import citybike.backend.entity.Station;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MockLists {

    /**
     * Here a simulated list of stations, which represent the stations in the database, is created.
     * @return
     */
    public static List<Station> createMockStations(){
        List<Station>stationList = new ArrayList<Station>();
        Station stationOne = new Station();
        stationOne.setId(1L);
        stationOne.setStationName("Station1");
        stationOne.setStationAddress("Address1");
        stationOne.setCoordinateX(12.345);
        stationOne.setCoordinateY(67.890);

        Station stationTwo = new Station();
        stationOne.setId(2L);
        stationOne.setStationName("Station2");
        stationOne.setStationName("Address2");
        stationOne.setCoordinateX(34.567);
        stationOne.setCoordinateY(34.567);

        stationList.add(stationOne);
        stationList.add(stationTwo);

        return stationList;
    }
    /**
     * Here a simulated list of journeys with the same departure station is created.
     * @return
     */
    public static List<Journey> createMockJourneysAccordingToDepartureStaion(){


        List<Journey>journeyList = new ArrayList<Journey>();

        Journey journeyOne = new Journey();
        Date departureDateOne = new Date(2021-06-20);
        Date returnDateOne = new Date(2021-06-21);
        journeyOne.setId(1L);
        journeyOne.setDepartureDateTime(departureDateOne);
        journeyOne.setReturnDateTime(returnDateOne);
        journeyOne.setDepartureStationId(22L);
        journeyOne.setReturnStationId(22L);
        journeyOne.setDistance(333L);
        journeyOne.setDuration(1L);

        journeyList.add(journeyOne);

        Journey journeyTwo = new Journey();
        Date departureDateTwo = new Date(2020-06-03);
        Date returnDateTwo = new Date(2020-06-10);
        journeyTwo.setId(12L);
        journeyTwo.setDepartureDateTime(departureDateTwo);
        journeyTwo.setReturnDateTime(returnDateTwo);
        journeyTwo.setDepartureStationId(22L);
        journeyTwo.setReturnStationId(334L);
        journeyTwo.setDistance(3324L);
        journeyTwo.setDuration(22L);

        journeyList.add(journeyTwo);
        return journeyList;
    }
    /**
     * Here a simulated list of journeys with the same return station is created.
     * @return
     */
    public static List<Journey> createMockJourneysAccordingToReturnStation(){

        List<Journey>journeyList = new ArrayList<Journey>();

        Journey journeyOne = new Journey();
        Date departureDateOne = new Date(2021-06-20);
        Date returnDateOne = new Date(2021-06-21);
        journeyOne.setId(1L);
        journeyOne.setDepartureDateTime(departureDateOne);
        journeyOne.setReturnDateTime(returnDateOne);
        journeyOne.setDepartureStationId(22L);
        journeyOne.setReturnStationId(22L);
        journeyOne.setDistance(333L);
        journeyOne.setDuration(1L);

        journeyList.add(journeyOne);

        Journey journeyTwo = new Journey();
        Date departureDateTwo = new Date(2020-06-03);
        Date returnDateTwo = new Date(2020-06-10);
        journeyTwo.setId(12L);
        journeyTwo.setDepartureDateTime(departureDateTwo);
        journeyTwo.setReturnDateTime(returnDateTwo);
        journeyTwo.setDepartureStationId(22L);
        journeyTwo.setReturnStationId(22L);
        journeyTwo.setDistance(3324L);
        journeyTwo.setDuration(22L);

        journeyList.add(journeyTwo);

        return journeyList;
    }
}

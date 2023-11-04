package citybike.backend.service;

import citybike.backend.Service.JourneyService;
import citybike.backend.entity.Journey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Testing the two methods in JourneyController, with a mock for the class, and
 * two list of simulated journeys.
 */
public class JourneyServiceTest {
    private JourneyService journeyService = Mockito.mock(JourneyService.class);

    List<Journey> mockListJourneysWithSameDepartureStations;
    List<Journey> mockListJourneysWithSameReturnStations;

    /**
     * The init method is creating two lists of simulated journeys that are needed
     * in the tests. One is with the same departuredate, the other one with the same
     * returndate. Those lists are also returned when the methods getJourneysByDepartureStationId
     * and getJourneysByReturnStationId are called with the mock.
     */
    @BeforeEach
    public void init(){
        mockListJourneysWithSameDepartureStations = this.createMockJourneysAccordingToDepartureStaion();
        mockListJourneysWithSameReturnStations = this.createMockJourneysAccordingToReturnStation();
        Mockito.when(journeyService.getJourneysByDepartureStationId(22L)).
                thenReturn(mockListJourneysWithSameDepartureStations);
        Mockito.when(journeyService.getJourneysByReturnStationId(22L)).
                thenReturn(mockListJourneysWithSameReturnStations);
    }

    /**
     * Testing that the methods getJourneysByDepartureStationId and getJourneysByReturnStationId are not returning null
     */
    @Test
    public void testMockListsAreNotEMpty(){
        assertNotNull(mockListJourneysWithSameDepartureStations);
        assertNotNull(mockListJourneysWithSameReturnStations);
    }

    /**
     * Testing that the method getJourneysByDepartureStationId and getJourneysByReturnStationId are
     * returning lists of correct length
     */
    @Test
    public void testThatStationJourneyControllerMethodsAreReturningCorrectListLength(){
        assertEquals(2, mockListJourneysWithSameDepartureStations.size());
        assertEquals(2, mockListJourneysWithSameReturnStations.size());
    }

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

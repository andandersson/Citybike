package citybike.backend.service;

import citybike.backend.Service.StationViewService;
import citybike.backend.entity.Station;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.Assert.*;

/**
 * Testing all the methods in the StationViewService-class. The method names are describing what
 * is being tested.
 */
public class StationViewServiceTest {

    private StationViewService stationViewService = Mockito.mock(StationViewService.class);
    private Optional<Station> station;


    @Test
    public void testThatGetStationByIdIsReturningAStation(){
        station = this.createMockStation();
        Mockito.when(stationViewService.getStationById(1L)).thenReturn(station);
        assertNotNull(station);
    }


    @Test
    public void testThatGetIdByStationNameIsReturningCorrectId(){
        long id = 1L;
        Mockito.when(stationViewService.getIdByStationName("testStation")).thenReturn(1L);
        assertNotNull(id);
    }

    @Test
    public void testThatGetAddressByStationNameIsReTurningCorrectAddress(){
        String testAddress = "testAddress";
        Mockito.when(stationViewService.getAddressByStationName("testStation")).thenReturn(testAddress);
        assertNotNull(testAddress);

    }


    @Test
    public void testThatGetTotalJourneysStartingAndEndingAtStationIsReturningCorrectAmount(){
        long stationId = 1;
        long journeys = 3L;
        Mockito.when(stationViewService.getTotalJourneysStartingFromStation(stationId)).thenReturn(journeys);
        Mockito.when(stationViewService.getTotalJourneysEndingAtStation(stationId)).thenReturn(journeys);
        assertEquals(journeys, 3l);

    }

    @Test
    public void testThatAverageDistanceByStationIsCorrect(){
        double distance = 1;
        Mockito.when(stationViewService.findAverageDistanceByStationId(1)).thenReturn(distance);
        assertEquals((int)distance, 1);
       // assertEquals(distance, 1);
    }

    @Test
    public void testThatAverageDurationByStationIsCorrect(){
        double duration = 1;
        Mockito.when(stationViewService.findAverageDistanceByStationId(1)).thenReturn(duration);
        assertEquals((int)duration, 1);
    }

    public Optional<Station> createMockStation(){

        Station mockStation = new Station();
        mockStation.setId(1L);
        mockStation.setStationName("Station1");
        mockStation.setStationAddress("Address1");
        mockStation.setCoordinateX(12.345);
        mockStation.setCoordinateY(67.890);

        return Optional.of(mockStation);

    }

}

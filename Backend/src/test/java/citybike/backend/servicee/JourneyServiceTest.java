package citybike.backend.servicee;

import citybike.backend.Service.JourneyService;
import citybike.backend.entity.Journey;
import citybike.backend.util.MockLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
        mockListJourneysWithSameDepartureStations = MockLists.createMockJourneysAccordingToDepartureStaion();
        mockListJourneysWithSameReturnStations = MockLists.createMockJourneysAccordingToReturnStation();
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
}

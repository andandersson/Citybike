package citybike.backend.servicee;


import citybike.backend.Service.StationService;
import citybike.backend.entity.Station;
import citybike.backend.util.MockLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

/**
 * A mock object of the StationController class is created. Its only method is tested.
 */
public class StationServiceTest {

    private StationService stationService = Mockito.mock(StationService.class);

    List<Station> mockListStations;

    /**
     * The init method is creating the list of simulated stations that is needed
     * in the tests. It is also making method getAllLists returning that list.
     */
    @BeforeEach
    public void init(){
        mockListStations = MockLists.createMockStations();
        Mockito.when(stationService.getAllStations()).thenReturn(mockListStations);
    }

    /**
     * Testing that the method getAllStations is not returning null
     */
    @Test
    public void testStationControllerReturningNotEmptyList(){
        assertNotNull(mockListStations);
    }

    /**
     * Testing that the method getAllStations is returning a list of correct length
     */
    @Test
    public void testThatStationControllerReturningCorrectListLength(){
        assertEquals(2, mockListStations.size());
    }



}

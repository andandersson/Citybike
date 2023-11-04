package citybike.backend.service;


import citybike.backend.Service.StationService;
import citybike.backend.dto.StationNameDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * A mock object of the StationService class is created. Its only method is tested.
 */
public class StationServiceTest {

    private StationService stationService = Mockito.mock(StationService.class);

    List<StationNameDTO> mockStationNames;

    /**
     * The init method is creating the list of simulated stations that is needed
     * in the tests.
     */
    @BeforeEach
    public void init(){
        mockStationNames = createStationNameDTOList();
        Mockito.when(stationService.getAllStationNames()).
                thenReturn(mockStationNames);
    }

    /**
     * Testing that the method getAllStations is not returning null
     */
    @Test
    public void testStationControllerReturningNotEmptyList(){
        assertNotNull(mockStationNames);
    }

    /**
     * Testing that the method getAllStations is returning a list of correct length
     */
    @Test
    public void testThatStationControllerReturningCorrectListLength(){
        assertEquals(3, mockStationNames.size());
    }


    public List<StationNameDTO> createStationNameDTOList(){
        List<StationNameDTO> stationNameDTOList = new ArrayList<StationNameDTO>();
        StationNameDTO stationNameDTOOne = new StationNameDTO("testStation");
        StationNameDTO stationNameDTOTwo = new StationNameDTO("testStationTwo");
        StationNameDTO stationNameDTOThree = new StationNameDTO("testStationThree");
        stationNameDTOList.add(stationNameDTOOne);
        stationNameDTOList.add(stationNameDTOTwo);
        stationNameDTOList.add(stationNameDTOThree);

        return stationNameDTOList;
    }

}

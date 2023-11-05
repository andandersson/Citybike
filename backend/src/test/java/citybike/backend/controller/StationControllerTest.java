package citybike.backend.controller;

import citybike.backend.Service.StationService;
import citybike.backend.Service.StationViewService;
import citybike.backend.dto.StationNameDTO;
import citybike.backend.dto.StationViewDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the StationController.
 */
@SpringBootTest
@AutoConfigureMockMvc
class StationControllerTest {

    @InjectMocks
    private StationController stationController;

    @Mock
    private StationService stationService;

    @Mock
    private StationViewService stationViewService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(stationController).build();
    }

    /**
     * testing that the statio names are fetched correctly.
     * @throws Exception
     */
    @Test
    void testGetAllStationNames() throws Exception {
        List<StationNameDTO> stationNames = Arrays.asList(new StationNameDTO("Station1"), new StationNameDTO("Station2"));

        // Mock the service method to return the station names
        Mockito.when(stationService.getAllStationNames()).thenReturn(stationNames);

        mockMvc.perform(get("/stations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Check the JSON response size
    }

    /**
     * Testing that the StationViewDTO is created correctly.
     * @throws Exception
     */
    @Test
    void testGetStationView() throws Exception {
        // Prepare a station view DTO
        StationViewDTO stationViewDTO = new StationViewDTO();
        stationViewDTO.setStationName("Station1");
        stationViewDTO.setStationAddress("Testaddress 33");
        stationViewDTO.setAverageDurationOfJourneysFromStation(23);
        stationViewDTO.setAverageDistanceOfJourneysFromStation(33);

        Mockito.when(stationViewService.getStationView(Mockito.anyString())).thenReturn(stationViewDTO);

        mockMvc.perform(get("/stations/Station1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stationName").value("Station1"))
                .andExpect(jsonPath("$.stationAddress").value("Testaddress 33"))
                .andExpect(jsonPath("$.averageDurationOfJourneysFromStation").value(23))
                .andExpect(jsonPath("$.averageDistanceOfJourneysFromStation").value(33)); // Ch

    }
}

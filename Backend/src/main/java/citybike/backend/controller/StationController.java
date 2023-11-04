package citybike.backend.controller;

import citybike.backend.Service.StationService;
import citybike.backend.Service.StationViewService;
import citybike.backend.dto.StationNameDTO;
import citybike.backend.dto.StationViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the controller class of the application. Mapping of urls are handled.
 * Either all stations as a list can be displayed, or a station view of a particular station.
 */
@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;
    @Autowired
    private StationViewService stationViewService;

    /**
     * If no station name is added to the url, a list of all the stations will be displaued.
     * @return
     */
    @GetMapping("")
    public List<StationNameDTO> getAllStationNames() {
        return stationService.getAllStationNames();
    }

    @GetMapping("/{stationName}")
    public ResponseEntity<StationViewDTO> getStationView(@PathVariable String stationName) {
        StationViewDTO stationView = stationViewService.getStationView(stationName);
        return ResponseEntity.ok(stationView);
    }
}

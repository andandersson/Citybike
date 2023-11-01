package citybike.backend.controller;

import citybike.backend.Service.StationService;
import citybike.backend.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    // Get all users
    @GetMapping
    public List<Station> getAllStations() {
        System.out.println("getAllStations, getmappig");
        return stationService.getAllStations();
    }

    // Get station by ID
    @GetMapping("/{id}")
    public Optional<Station> getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }


}

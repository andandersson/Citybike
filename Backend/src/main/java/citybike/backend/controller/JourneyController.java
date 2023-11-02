package citybike.backend.controller;

import citybike.backend.Service.JourneyService;
import citybike.backend.entity.Journey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/journey")
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @GetMapping("/byDepartureStationId/{departureStationId}")
    public List<Journey> getJourneysByDepartureStationId(@PathVariable Long departureStationId) {
        return journeyService.getJourneysByDepartureStationId(departureStationId);
    }

    @GetMapping("/byReturnStationId/{returnStationId}")
    public List<Journey> getJourneysByReturnStationId(@PathVariable Long returnStationId){
        return journeyService.getJourneysByReturnStationId(returnStationId);
   }

}

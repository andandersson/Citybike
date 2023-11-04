package citybike.backend.Service;

import citybike.backend.entity.Journey;
import citybike.backend.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * The service class for journeys. Implementations of the methods in the interface.
 */
@Service
public class JourneyService {


    @Autowired
    private JourneyRepository journeyRepository;


    public List<Journey> getJourneysByDepartureStationId(Long departureStationId) {
        return journeyRepository.findByDepartureStationId(departureStationId);
    }

    public List<Journey> getJourneysByReturnStationId(Long returnStationId) {
        return journeyRepository.findByReturnStationId(returnStationId);
    }
}

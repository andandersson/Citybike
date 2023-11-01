package citybike.backend.Service;

import citybike.backend.entity.Station;
import citybike.backend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;
    // Get all stations
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    // Get station by id
    public Optional<Station> getStationById(Long id) {
        return stationRepository.findById(id);
    }
}
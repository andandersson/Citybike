package citybike.backend.Service;

import citybike.backend.dto.StationNameDTO;
import citybike.backend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * The service class for stations. Implementations of the methods in the interface.
 */
@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public List<StationNameDTO> getAllStationNames() {
        return stationRepository.findAllStationNames();
    }

}
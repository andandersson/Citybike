package citybike.backend.repository;

import citybike.backend.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
    List<Journey> findByDepartureStationId(Long departureStationId);
    List<Journey> findByReturnStationId(Long returnStationId);

}

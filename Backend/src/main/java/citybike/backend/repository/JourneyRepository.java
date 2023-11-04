package citybike.backend.repository;

import citybike.backend.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Long> {

    /**
     * When implemented, this method is returning a list of all journeys starting from
     * a particular station
     * @param departureStationId, the id of the station
     * @return a list with the journeys
     * WORKING
     */
    List<Journey> findByDepartureStationId(Long departureStationId);

    /**
     * When implemented, this method is returning a list of all journeys returning at
     * a particular station
     * @param returnStationId), the id of the station
     * @return a list with the journeys
     * WORKING
     */
    List<Journey> findByReturnStationId(Long returnStationId);



    /**
     * When implemented, this method is returning the total amount of journeys starting from a
     * particular station
     * @param departureStationId, the id of the station
     * @return the total amount
     */
    long countByDepartureStationId(Long departureStationId);

    /**
     * When implemented, this method is returning the total amount of journeys returning at a
     * particular station
     * @param returnStationId, the id of the station
     * @return the total amount
     */
    long countByReturnStationId(Long returnStationId);

    /**
     * When implemented, this method will return the average distance of all journeys
     * with a specific departureid
     * @param stationId
     * @return
     */
    @Query("SELECT AVG(j.distance) FROM Journey j WHERE j.departureStationId = :stationId")
    Double findAverageDistanceByStationId(@Param("stationId") Long stationId);

    /**
     * When implemented, this method will return the average duration of all journeys
     * with a specific departureid
     * @param stationId
     * @return
     */
    @Query("SELECT AVG(j.duration) FROM Journey j WHERE j.departureStationId = :stationId")
    Double findAverageDurationByStationId(@Param("stationId") Long stationId);

}


package citybike.backend.repository;

import citybike.backend.dto.StationNameDTO;
import citybike.backend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    /**
     * Database-query for retrieving a list of all station names.
     * @return
     */
    @Query("SELECT new citybike.backend.dto.StationNameDTO(s.stationName) FROM Station s")
    List<StationNameDTO> findAllStationNames();

    /**
     * Database-query to retrieve the address of a specific station, with the name as an input.
     * @param
     * @return
     */
    @Query("SELECT s.stationAddress FROM Station s WHERE s.stationName = :stationName")
    Optional<String> findAddressByStationName(@Param("stationName") String stationName);

    /**
     * Database-query to retrieve the id of a specific station, with the name as an input.
     * @param stationName
     * @return
     */
    @Query("SELECT s.id FROM Station s WHERE s.stationName = :stationName")
    Optional<Long> findIdByStationName(@Param("stationName") String stationName);


    /**
     * Returning a stating with an id as input
     * @param id
     * @return
     */
    Optional<Station> findById(Long id);
}


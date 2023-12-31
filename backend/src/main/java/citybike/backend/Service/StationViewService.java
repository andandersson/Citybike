package citybike.backend.Service;

import citybike.backend.dto.StationViewDTO;
import citybike.backend.entity.Station;
import citybike.backend.exceptions.InvalidStationNameException;
import citybike.backend.repository.StationRepository;
import citybike.backend.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * This class is containing the methods for retrieving data from both the Journey and
 * station table in the database. The purpose is to make a single station view with
 * the required information.
 */
@Service
public class StationViewService {


    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private JourneyRepository journeyRepository;

    private String stationName;
    private String stationAddress;
    private Long stationId;
    private long journeysFromStation;
    private long journeysToStation;
    private double averageDistanceOfJourneysFromStation;
    private double averageDurationOfJourneysFromStation;
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }
    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public long getJourneysFromStation() {
        return journeysFromStation;
    }

    public void setJourneysFromStation(long journeysFromStation) {
        this.journeysFromStation = journeysFromStation;
    }

    public long getJourneysToStation() {
        return journeysToStation;
    }

    public void setJourneysToStation(long journeysToStation) {
        this.journeysToStation = journeysToStation;
    }

    public double getAverageDistanceOfJourneysFromStation() {
        return averageDistanceOfJourneysFromStation;
    }

    public void setAverageDistanceOfJourneysFromStation(double averageDistanceOfJourneysFromStation) {
        this.averageDistanceOfJourneysFromStation = averageDistanceOfJourneysFromStation;
    }

    public double getAverageDurationOfJourneysFromStation() {
        return averageDurationOfJourneysFromStation;
    }

    public void setAverageDurationOfJourneysFromStation(double averageDurationOfJourneysFromStation) {
        this.averageDurationOfJourneysFromStation = averageDurationOfJourneysFromStation;
    }

    public StationViewService(){

    }


    /**
     * Creating a single station view, with this information:
     * Station name
     * Station address
     * Total number of journeys starting from the station
     * Total number of journeys ending at the station
     * Average distance of journeys starting from the station
     * Avarage duration of journeys starting from the station
     * @param stationName
     */

    public StationViewDTO getStationView(String stationName) {
        Long id = this.getIdByStationName(stationName);
        StationViewDTO stationView = new StationViewDTO();
        stationView.setStationName(stationName);
        stationView.setStationAddress(this.getAddressByStationName(stationName));
        stationView.setJourneysFromStation(this.getTotalJourneysStartingFromStation(id));
        stationView.setJourneysToStation(this.getTotalJourneysEndingAtStation(id));
        stationView.setAverageDistanceOfJourneysFromStation(this.findAverageDistanceByStationId(id));
        stationView.setAverageDurationOfJourneysFromStation(this.findAverageDurationByStationId(id));

        return stationView;
    }



    /**
     * Returning a the station with an id as an input.
     * @param stationId
     * @return
     */
    public Optional<Station> getStationById(Long stationId) {
        return stationRepository.findById(stationId);
    }


    public Long getIdByStationName(String stationName) {
        Optional<Long> result = stationRepository.findIdByStationName(stationName);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new InvalidStationNameException("Invalid station name: " + stationName);
        }

    }

    /**
     * Returning the address of a specic station, with the station name as an input
     * @param stationName
     * @return
     */
    public String getAddressByStationName(String stationName) {
        Optional<String> addressOptional = stationRepository.findAddressByStationName(stationName);
        String address = addressOptional.get();
        return address;
    }

    /**
     * This is an implementation of the method countByDepartureStationId in the journeyrepository.
     * it will return total amount of journeys starting from a particular station
     * @param stationId
     * @return
     */
    public long getTotalJourneysStartingFromStation(Long stationId) {
        Station station = this.getStationById(stationId).orElse(null);
        if (station != null) {
            return journeyRepository.countByDepartureStationId(stationId);
        }
        return 0;
    }

    /**
     * This is an implementation of the method countByReturnStationId in the journeyrepository.
     * it will return total amount of journeys ending at a particular station
     * @param stationId
     * @return
     */

    public long getTotalJourneysEndingAtStation(Long stationId) {
        Station station = this.getStationById(stationId).orElse(null);
        if (station != null) {
            return journeyRepository.countByReturnStationId(stationId);
        }
        return 0;
    }

    /**
     * This is an implementation of the method findAverageDistanceByStationId in the journeyrepository.
     * It is returning the average distance o of all journeys starting from a particular station,
     * after rounding of the decimals and converting it to a long. It is then divided by 1000 to
     * get a km -value.
     * @param stationId
     * @return
     */
    public long findAverageDistanceByStationId(long stationId){
        double result = this.journeyRepository.findAverageDistanceByStationId(stationId);
        int intValue = (int) Math.round(result);
        long averageDistance = (long)intValue;
        averageDistance = Math.round((double)averageDistance / 1000);
        return averageDistance;
    }

    /**
     * This is an implementation of the method findAverageDurationByStationId in the journeyrepository.
     * It is returning the average duration o of all journeys starting from a particular station,
     * after rounding of the decimals and converting it to a long. It is then divided by 60 to get
     * a minute value.
     * @param stationId
     * @return
     */
    public long findAverageDurationByStationId(long stationId){
        double result = this.journeyRepository.findAverageDurationByStationId(stationId);
        int intValue = (int) Math.round(result);
        long averageDuration = (long)intValue;
        averageDuration = Math.round(((double) averageDuration/60));
        return averageDuration;

    }

}

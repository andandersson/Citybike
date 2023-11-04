package citybike.backend.dto;

/**
 * This class is a representation of the station view,
 * that will display information about a single station view.
 */
public class StationViewDTO {
    private String stationName;
    private String stationAddress;
    private Long journeysFromStation;
    private Long journeysToStation;
    private double averageDistanceOfJourneysFromStation;
    private double averageDurationOfJourneysFromStation;

    public StationViewDTO() {
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public Long getJourneysFromStation() {
        return journeysFromStation;
    }

    public void setJourneysFromStation(Long journeysFromStation) {
        this.journeysFromStation = journeysFromStation;
    }

    public Long getJourneysToStation() {
        return journeysToStation;
    }

    public void setJourneysToStation(Long journeysToStation) {
        this.journeysToStation = journeysToStation;
    }

    public double getAverageDistanceOfJourneysFromStation() {
        return averageDistanceOfJourneysFromStation;
    }

    public void setAverageDistanceOfJourneysFromStation(double averageDistanceOfJourneysToStation) {
        this.averageDistanceOfJourneysFromStation = averageDistanceOfJourneysToStation;
    }

    public double getAverageDurationOfJourneysFromStation() {
        return averageDurationOfJourneysFromStation;
    }

    public void setAverageDurationOfJourneysFromStation(double averageDurationOfJourneysToStation) {
        this.averageDurationOfJourneysFromStation = averageDurationOfJourneysToStation;
    }

}

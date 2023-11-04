package citybike.backend.dto;

/**
 * This is a DTO class for being able to fetch the station names from
 * the database, and display them as a list.
 */
public class StationNameDTO {
    private String name;

    public StationNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

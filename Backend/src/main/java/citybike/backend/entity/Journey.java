package citybike.backend.entity;

import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name ="journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date departureDateTime;
    private Date returnDateTime;
    @Column(name = "departure_station_id")
    private Long departureStationId;
    @Column(name = "return_station_id")
    private Long returnStationId;
    private Long distance;
    private Long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public Long getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Long departureStationId) {
        this.departureStationId = departureStationId;
    }

    public Long getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(Long returnStationId) {
        this.returnStationId = returnStationId;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}

package citybike.backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stationName;
    private String stationAddress;
    @Column(name = "coordinate_x")
    private Double coordinateX;
    @Column(name = "coordinate_y")
    private Double coordinateY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStationName(){
        return this.stationName;
    }
    public void setStationName(String stationName){
        this.stationName= stationName;
    }

    public String getStationAddress(){
        return this.stationAddress;
    }

    public void setStationAddress(String stationAddress){
        this.stationAddress = stationAddress;
    }

    public Double getCoordinateX(){
        return this.coordinateX;
    }

    public void setCoordinateX(Double coordinateX){
        this.coordinateX=coordinateX;
    }
    public Double getCoordinateY(){
        return this.coordinateY;
    }

    public void setCoordinateY(Double coordinateY){
        this.coordinateY=coordinateY;
    }

}

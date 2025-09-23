package ticketBooking.entities;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> seats;
    private Map<String,String> stationTimes;
    private List<String> stations;
    public Train(){}
    public Train(String trainId,String trainNo,List<List<Integer>> seats,Map<String,String> stationTimes,List<String> stations){
        this.trainId=trainId;
        this.trainNo=trainNo;
        this.seats=seats;
        this.stationTimes=stationTimes;
        this.stations=stations;
    }
    public Map<String, String> getStationTime() {
        return stationTimes;
    }
    public void setStationTime(Map<String, String> stationTime) {
        this.stationTimes = stationTime;
    }
    public List<String> getStations() {
        return stations;
    }
    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    public String getTrainId() {
        return trainId;
    }
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
    public String getTrainNo() {
        return trainNo;
    }
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public List<List<Integer>> getSeats() {
        return seats;
    }
    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }
   public String getTrainInfo(){
    return String.format("Train ID: %s Train No: %s", trainId,trainNo);
   }  
}

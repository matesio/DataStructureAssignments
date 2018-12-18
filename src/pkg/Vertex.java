
package pkg;

import java.util.LinkedList;


public class Vertex {
    private String city;
    private String longitude;
    private String latitude;
    public LinkedList<Edge> edges;

    public Vertex() {
        edges = new LinkedList();
        city = null;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    


    




}

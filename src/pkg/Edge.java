package pkg;
public class Edge {
    String roadName;
    int weight;
    Vertex endVertex;
    private String longitude;
    private String latitude;
    private String roadType;
    public Edge() {
        weight = 0;
        endVertex=null;
        longitude =null;
        latitude = null;
        roadType=null;
    }
    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
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


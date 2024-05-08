package restaurant;
public class Address {
    public double latitude , longitude;
    public String written_address;
    public double distance_from(Address other) {
        double xDistance = other.latitude - this.latitude;
        double yDistance = other.longitude - this.longitude;
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return distance;
    }    
    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }
}
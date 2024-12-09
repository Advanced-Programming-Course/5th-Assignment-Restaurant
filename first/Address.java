public class Address {
    private double latitude;
    private double longitude;
    private String written_address;

    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }

    public double distance_from(Address other) {
        double distance = Math.sqrt(Math.pow(other.latitude - this.latitude, 2) +
                                    Math.pow(other.longitude - this.longitude, 2));
        return distance;
    }
}

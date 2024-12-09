public class Address {
    public double latitude;
    public double longitude;
    public String written_address;

    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }

    public double distanceFrom(Address other) {
        return Math.sqrt(Math.pow(this.latitude - other.latitude, 2) + Math.pow(this.longitude - other.longitude, 2));
    }
}

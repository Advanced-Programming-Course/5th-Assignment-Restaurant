package restaurant;

public class Address {
    private double latitude;
    private double longitude;
    private String writtenAddress;

    public Address(double latitude, double longitude, String writtenAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.writtenAddress = writtenAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getWrittenAddress() {
        return writtenAddress;
    }

    public double distanceFrom(Address other) {
        return Math.sqrt(Math.pow(other.latitude - this.latitude, 2) + Math.pow(other.longitude - this.longitude, 2));
    }
}

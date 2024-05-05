public class Address {
    public double longitude;
    public double latitude;
    public String writtenAddress;

    public Address(double latitude, double longitude, String writtenAddress){
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

    public double distanceFrom(Address target) {
        return Math.sqrt(
            Math.pow((this.latitude - target.getLatitude()), 2)
            +
            Math.pow((this.longitude - target.getLongitude()), 2)
        );
    }
}

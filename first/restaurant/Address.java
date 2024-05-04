public class Address {

    private double latitude;
    private double longitude;
    private String written_address;

    public Address(double latitude, double longitude, String writtenAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = writtenAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getWritten_address() {
        return written_address;
    }

    public void setWrittenAddress(String written_address) {
        this.written_address = written_address;
    }

    public double distanceFrom(Address Address2) {
        double la_distance = this.latitude - Address2.latitude;
        double lo_distance = this.longitude - Address2.longitude;
        double distance = Math.sqrt(Math.pow(la_distance, 2) + Math.pow(lo_distance, 2));

        return Math.round(distance * 100000.0) / 100000.0;
    }
}
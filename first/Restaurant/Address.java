public class Address {
    private double latitude;
    private double longitude;
    private String written_Address;

    public Address(double latitude, double longitude, String writtenAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_Address = written_Address;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getWrittenAddress() {
        return written_Address;
    }
    public double distanceFrom(Address anotherAddress) {
        double la1 = this.latitude;
        double lo1 = this.longitude;
        double la2 = anotherAddress.getLatitude();
        double lo2 = anotherAddress.getLongitude();

        double distance = Math.sqrt(Math.pow(la2 - la1, 2) + Math.pow(lo2 - lo1, 2));


        return distance;
    }
}
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
    public double distanceFrom(Address otherAddress){
        double la1 = this.latitude;
        double lo1 = this.longitude;
        double la2 = otherAddress.getLatitude();
        double lo2 = otherAddress.getLongitude();
        double distance;
        double x;
        x = Math.pow((la2 - la1), 2) + Math.pow((lo2 - lo1), 2);
        distance = Math.pow(x, 0.5);

        return Math.round(distance * 100000.0) / 100000.0;
    }
}

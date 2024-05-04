package first;

public class Address {
    private double latitude;
    private double longitude;
    private String written_address;

    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getWrittenAddress() {
        return written_address;
    }

    public double distanceFrom(Address otherAddress) {
        double lat1 = (this.latitude);
        double lon1 = (this.longitude);
        double lat2 = (otherAddress.getLatitude());
        double lon2 = (otherAddress.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double distance = Math.sqrt(Math.pow(dLat, 2) + Math.pow(dLon, 2));



        return distance;
    }
}
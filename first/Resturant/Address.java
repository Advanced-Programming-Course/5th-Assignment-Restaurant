public class Address {

    private double latitude; // عرض جغرافیایی
    private double longitude; // طول جغرافیایی
    private String writtenAddress; // آدرس نوشتاری

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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setWrittenAddress(String writtenAddress) {
        this.writtenAddress = writtenAddress;
    }

    public double distanceFrom(Address otherAddress) {
        double x1 = this.getLatitude();
        double y1 = this.getLongitude();

        double x2 = otherAddress.getLatitude();
        double y2 = otherAddress.getLongitude();

        double distanceX = Math.abs(x2 - x1);
        double distanceY = Math.abs(y2 - y1);

        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        return Math.round(distance * 100000) / 100000.0;
    }

    @Override
    public String toString() {
        return "Address{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", writtenAddress='" + writtenAddress + "'" +
                '}';
    }
}

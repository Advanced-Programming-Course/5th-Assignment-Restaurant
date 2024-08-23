public class Address {
    public double latitude;
    public double longtitude;
    public String written_address;
    //    public Address(double latitude, double longtitude) {
//        this.latitude = latitude;
//        this.longtitude = longtitude;
//        written_address = "";
//    }
    public Address(double latitude, double longtitude, String written_address) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.written_address = written_address;
    }
    public double distanceFrom(Address a) {
        return Math.sqrt(Math.pow((latitude - a.latitude),2) + Math.pow((longtitude - a.longtitude), 2));
    }
}

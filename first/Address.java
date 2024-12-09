public class Address{
    public double latitude;
    public double longitude;
    public String written_address;
    
    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }
    
      public double distanceFrom(Address otherAddress) {
        double la1 = this.latitude;
        double lo1 = this.longitude;
        double la2 = otherAddress.latitude;
        double lo2 = otherAddress.longitude;
        double longitude=lo2 - lo1;
        double latitude = la2-la1;
        double power1=Math.pow(longitude,2);
        double power2=Math.pow(latitude , 2);
        double Distance= Math.sqrt(power1+power2);
        double distanceRound=Math.round(Distance * 100000)/100000.0;
        return distanceRound;
    }
    public double getLatitude(){
        return latitude;
    }
    public void setLatitude(double newlatitude){
        this.latitude=newlatitude;
    }
    public double getLongitude(){
        return longitude;
    }
    public void setLongitude(double newlongitude){
        this.longitude=newlongitude;
    }
     public String getWrittenAddress() {
        return written_address;
    }

    public void setWrittenAddress(String newwritten_address) {
        this.written_address = newwritten_address;
    }
    
   
}
    
    
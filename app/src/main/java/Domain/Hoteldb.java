package Domain;

public class Hoteldb {
    private String id ;
    private String hotel_code;
    private String hotel_name;
    private String hotel_city;
    private String hotel_Addrr;
    private String hotel_Des;
    private String hotel_Service;
    private String hotel_Policy;
    private String Child_And_Bed_Policy;
    private String hotel_ImportantInfor;

    public  Hoteldb(){}

    public Hoteldb(String hotel_code, String hotel_name, String hotel_city, String hotel_Addrr, String hotel_Des, String hotel_Service, String hotel_Policy, String child_And_Bed_Policy, String hotel_ImportantInfor) {
        this.hotel_code = hotel_code;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_Addrr = hotel_Addrr;
        this.hotel_Des = hotel_Des;
        this.hotel_Service = hotel_Service;
        this.hotel_Policy = hotel_Policy;
        Child_And_Bed_Policy = child_And_Bed_Policy;
        this.hotel_ImportantInfor = hotel_ImportantInfor;
    }

    public Hoteldb(String id, String hotel_code, String hotel_name, String hotel_city, String hotel_Addrr, String hotel_Des, String hotel_Service, String hotel_Policy, String child_And_Bed_Policy, String hotel_ImportantInfor) {
        this.id = id;
        this.hotel_code = hotel_code;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_Addrr = hotel_Addrr;
        this.hotel_Des = hotel_Des;
        this.hotel_Service = hotel_Service;
        this.hotel_Policy = hotel_Policy;
        Child_And_Bed_Policy = child_And_Bed_Policy;
        this.hotel_ImportantInfor = hotel_ImportantInfor;
    }

    public String getHotel_code() {
        return hotel_code;
    }

    public void setHotel_code(String hotel_code) {
        this.hotel_code = hotel_code;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_Addrr() {
        return hotel_Addrr;
    }

    public void setHotel_Addrr(String hotel_Addrr) {
        this.hotel_Addrr = hotel_Addrr;
    }

    public String getHotel_Des() {
        return hotel_Des;
    }

    public void setHotel_Des(String hotel_Des) {
        this.hotel_Des = hotel_Des;
    }

    public String getHotel_Service() {
        return hotel_Service;
    }

    public void setHotel_Service(String hotel_Service) {
        this.hotel_Service = hotel_Service;
    }

    public String getHotel_Policy() {
        return hotel_Policy;
    }

    public void setHotel_Policy(String hotel_Policy) {
        this.hotel_Policy = hotel_Policy;
    }

    public String getChild_And_Bed_Policy() {
        return Child_And_Bed_Policy;
    }

    public void setChild_And_Bed_Policy(String child_And_Bed_Policy) {
        Child_And_Bed_Policy = child_And_Bed_Policy;
    }

    public String getHotel_ImportantInfor() {
        return hotel_ImportantInfor;
    }

    public void setHotel_ImportantInfor(String hotel_ImportantInfor) {
        this.hotel_ImportantInfor = hotel_ImportantInfor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

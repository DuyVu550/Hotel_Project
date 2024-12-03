package Domain;

import java.io.Serializable;

public class Recommend_Hotel implements Serializable {
    String rec_pic;
    String nameHotel;
    String cityHotel;
    String price;


    public Recommend_Hotel(String rec_pic, String nameHotel, String cityHotel, String price) {
        this.rec_pic = rec_pic;
        this.nameHotel = nameHotel;
        this.cityHotel = cityHotel;
        this.price = price;
    }

    public String getRec_pic() {
        return rec_pic;
    }

    public void setRec_pic(String rec_pic) {
        this.rec_pic = rec_pic;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getCityHotel() {
        return cityHotel;
    }

    public void setCityHotel(String cityHotel) {
        this.cityHotel = cityHotel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

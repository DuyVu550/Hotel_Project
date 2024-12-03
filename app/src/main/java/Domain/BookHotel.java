package Domain;

public class BookHotel {
    private String idbook;
    private String hobook;
    private String tenbook;
    private int sdtbook;
    private int adult;
    private int children;
    private String checkin;
    private String checkout;

    public BookHotel(String idbook, String hobook, String tenbook, int sdtbook, int adult, int children, String checkin, String checkout) {
        this.idbook = idbook;
        this.hobook = hobook;
        this.tenbook = tenbook;
        this.sdtbook = sdtbook;
        this.adult = adult;
        this.children = children;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getIdbook() {
        return idbook;
    }

    public void setIdbook(String idbook) {
        this.idbook = idbook;
    }

    public String getHobook() {
        return hobook;
    }

    public void setHobook(String hobook) {
        this.hobook = hobook;
    }

    public String getTenbook() {
        return tenbook;
    }

    public void setTenbook(String tenbook) {
        this.tenbook = tenbook;
    }

    public int getSdtbook() {
        return sdtbook;
    }

    public void setSdtbook(int sdtbook) {
        this.sdtbook = sdtbook;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}

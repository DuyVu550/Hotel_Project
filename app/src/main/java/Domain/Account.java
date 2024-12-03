package Domain;

public class Account {
    private long id;
    private String username;
    private String ho;
    private String ten;
    private String useremail;
    private String userpass;
    private String user_repass;

    public Account(long id, String username, String ho, String ten, String useremail, String userpass, String user_repass) {
        this.id = id;
        this.username = username;
        this.ho = ho;
        this.ten = ten;
        this.useremail = useremail;
        this.userpass = userpass;
        this.user_repass = user_repass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUser_repass() {
        return user_repass;
    }

    public void setUser_repass(String user_repass) {
        this.user_repass = user_repass;
    }
}

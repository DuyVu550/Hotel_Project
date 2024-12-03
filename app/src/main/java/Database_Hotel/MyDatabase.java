package Database_Hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import Domain.Hoteldb;

public class MyDatabase {
    Context context;
    SQLiteDatabase database;
    Database_HT datahelper;
    public MyDatabase(Context context){
        datahelper =new Database_HT(context);
        database= datahelper.getWritableDatabase();
        this.context =context;
    }

    public boolean insertAccount(String userName, String userHo, String userTen, String userEmail, String userPass, String userRepass ){
        ContentValues valueAccount = new ContentValues();
        valueAccount.put(Database_HT.USERNAME, userName);
        valueAccount.put(Database_HT.USERHO, userHo);
        valueAccount.put(Database_HT.USERTEN, userTen);
        valueAccount.put(Database_HT.USEREMAIL, userEmail);
        valueAccount.put(Database_HT.USERPASS, userPass);
        valueAccount.put(Database_HT.USER_REPASS, userRepass);

        long result = database.insert(Database_HT.TB_ACCOUNT, null, valueAccount);
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }
    // CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACT_USER + " INTEGER REFERENCES " + TB_ACCOUNT + "("+USERID + "), " + CONTACT_HOTEL + " INTEGER REFERENCES " + TB_HOTEL + "("+ HOTELID + "), " + CONTACT_DESCRIPTION + " TEXT)");
    public boolean insertContact(String email,String CONTACT_DESCRIPTION ){
        ContentValues valueAccount = new ContentValues();
        valueAccount.put(Database_HT.CONTACT_USER, email);
        valueAccount.put(Database_HT.CONTACT_DESCRIPTION, CONTACT_DESCRIPTION);
        long result = database.insert(Database_HT.TB_CONTACT, null, valueAccount);
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }

    public boolean CheckUser(String username){
        Cursor cursor = database.rawQuery("SELECT * FROM " + Database_HT.TB_ACCOUNT + " WHERE " + Database_HT.USERNAME + " =?", new String[]{username});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean CheckAccount(String username, String pass){
        Cursor cursor = database.rawQuery("SELECT * FROM " + Database_HT.TB_ACCOUNT + " WHERE " + Database_HT.USERNAME + " =? AND " + Database_HT.USERPASS + " =?",new String[] {username,pass});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public String DisplayUser(String user) {
        String query = "SELECT * FROM " + Database_HT.TB_ACCOUNT + " WHERE " + Database_HT.USERNAME + " = " + user;
        Cursor cursor = database.rawQuery(query, null);

        String username = "";
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            username = cursor.getColumnName(1);
        }
        return username;
    }

    /*public ArrayList<Hoteldb> addhotel(){
        database = datahelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + Database_HT.TB_HOTEL, null);
        ArrayList<Hoteldb> arrayList = new ArrayList<>();

        while (cursor.moveToNext()){
            Hoteldb hoteldb = new Hoteldb();
            hoteldb.setId(cursor.getString(0));
            hoteldb.setHotel_code(cursor.getString(1));
            hoteldb.setHotel_name(cursor.getString(2));
            hoteldb.setHotel_city(cursor.getString(3));
            hoteldb.setHotel_Addrr(cursor.getString(4));
            hoteldb.setHotel_Des(cursor.getString(5));
            hoteldb.setHotel_Service(cursor.getString(6));
            hoteldb.setHotel_Policy(cursor.getString(7));
            hoteldb.setChild_And_Bed_Policy(cursor.getString(8));
            hoteldb.setHotel_ImportantInfor(cursor.getString(9));

            arrayList.add(hoteldb);
        }
        return arrayList;
    }*/

    public boolean insertHotel(Hoteldb hoteldb){
        ContentValues valuesHotel = new ContentValues();
        valuesHotel.put(Database_HT.HOTEL_CODE, hoteldb.getHotel_code());
        valuesHotel.put(Database_HT.HOTELNAME, hoteldb.getHotel_name());
        valuesHotel.put(Database_HT.HOTELCITY, hoteldb.getHotel_city());
        valuesHotel.put(Database_HT.HOTEL_ADDRESS, hoteldb.getHotel_Addrr());
        valuesHotel.put(Database_HT.HOTEL_DES, hoteldb.getHotel_Des());
        valuesHotel.put(Database_HT.HOTEL_SERVICE, hoteldb.getHotel_Service());
        valuesHotel.put(Database_HT.HOTEL_POLICY, hoteldb.getHotel_Policy());
        valuesHotel.put(Database_HT.HOTEL_CHILDANDBED_POLICY, hoteldb.getChild_And_Bed_Policy());
        valuesHotel.put(Database_HT.HOTEL_IMPORTANTINFOR, hoteldb.getHotel_ImportantInfor());

        long result = database.insert(Database_HT.TB_HOTEL, null, valuesHotel);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor readAllData(){
        String Query = "SELECT * FROM " + Database_HT.TB_HOTEL;
        Cursor cursor = null;
        if(database != null){
            cursor = database.rawQuery(Query, null);
        }
        return cursor;
    }


    public Cursor readSingleData(String name){
        String Query = "SELECT * FROM " + Database_HT.TB_HOTEL + " WHERE " + Database_HT.HOTELNAME + " = " + name;
        Cursor cursor = null;
        if(database != null){
            cursor = database.rawQuery(Query, null);
        }
        return cursor;
    }

    public void updateHotel(Hoteldb hoteldb) {
        ContentValues valuesHotel = new ContentValues();
        valuesHotel.put(Database_HT.HOTEL_CODE, hoteldb.getHotel_code());
        valuesHotel.put(Database_HT.HOTELNAME, hoteldb.getHotel_name());
        valuesHotel.put(Database_HT.HOTELCITY, hoteldb.getHotel_city());
        valuesHotel.put(Database_HT.HOTEL_ADDRESS, hoteldb.getHotel_Addrr());
        valuesHotel.put(Database_HT.HOTEL_DES, hoteldb.getHotel_Des());
        valuesHotel.put(Database_HT.HOTEL_SERVICE, hoteldb.getHotel_Service());
        valuesHotel.put(Database_HT.HOTEL_POLICY, hoteldb.getHotel_Policy());
        valuesHotel.put(Database_HT.HOTEL_CHILDANDBED_POLICY, hoteldb.getChild_And_Bed_Policy());
        valuesHotel.put(Database_HT.HOTEL_IMPORTANTINFOR, hoteldb.getHotel_ImportantInfor());

        long result = database.update(Database_HT.TB_HOTEL, valuesHotel, Database_HT.HOTELID + " = " + hoteldb.getId(), null);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successed", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteHotel(Hoteldb hoteldb){
        long result = database.delete(Database_HT.TB_HOTEL, Database_HT.HOTELID + " = " + hoteldb.getId(), null);
        if (result == -1) {
            Toast.makeText(context, "Delete Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Delete Successed", Toast.LENGTH_SHORT).show();
        }
    }
}

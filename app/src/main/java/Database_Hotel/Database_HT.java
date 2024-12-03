package Database_Hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database_HT extends SQLiteOpenHelper {
    public static final String TB_ACCOUNT = "TB_ACCOUNT";
    public static final String USERID = "USERID";
    public static final String USERNAME = "USERNAME";
    public static final String USERHO = "USERHO";
    public static final String USERTEN = "USERTEN";
    public static final String USEREMAIL = "USEREMAIL";
    public static final String USERPASS = "USERPASS";
    public static final String USER_REPASS = "USER_REPASS";
    private static final String dbname = "HotelBooking.db";
    public static final String TB_HOTEL = "TB_HOTEL";
    public static final String HOTELID = "HOTELID";
    public static final String HOTEL_CODE = "HOTEL_CODE";
    public static final String HOTELNAME = "HOTELNAME";
    public static final String HOTELCITY = "HOTELCITY";
    public static final String HOTEL_ADDRESS = "HOTEL_ADDRESS";
    public static final String HOTEL_DES = "HOTEL_DES";
    public static final String HOTEL_SERVICE = "HOTEL_SERVICE";
    public static final String HOTEL_POLICY = "HOTEL_POLICY";
    public static final String HOTEL_CHILDANDBED_POLICY = "HOTEL_CHILDANDBED_POLICY";
    public static final String HOTEL_IMPORTANTINFOR = "HOTEL_IMPORTANTINFOR";
    public static final String STATUSROOM = "STATUSROOM";
    public static final String TB_STATUSROOM = "TB_" + STATUSROOM;
    public static final String STATUSROOM_ID = STATUSROOM + "_ID";
    public static final String TB_ROOM = "TB_ROOM";
    public static final String ROOMID = "ROOMID";
    public static final String ROOM_CODE = "ROOM_CODE";
    public static final String RHOTEL = "RHOTEL";
    public static final String ROOMNAME = "ROOMNAME";
    public static final String ROOMDES = "ROOMDES";
    public static final String ROOM_AVAILABLEBED = "ROOM_AVAILABLEBED";
    public static final String ROOM_CONVENIENT = "ROOM_CONVENIENT";
    public static final String ROOM_CAPACITY = "ROOM_CAPACITY";
    public static final String RSTATUS = "RSTATUS";
    public static final String ROOMPRICE = "ROOMPRICE";
    public static final String TB_RATE = "TB_RATE";
    public static final String RATEID = "RATEID";
    public static final String RATE_USER = "RATE_USER";
    public static final String RATE_HOTEL = "RATE_HOTEL";
    public static final String RATE_VIEW = "RATE_VIEW";
    public static final String RATE_CLEAN = "RATE_CLEAN";
    public static final String RATE_WIFI = "RATE_WIFI";
    public static final String RATE_COMFORTABLE = "RATE_COMFORTABLE";
    public static final String RATE_STAFF = "RATE_STAFF";
    public static final String RATE_COMMENT = "RATE_COMMENT";
    public static final String TB_CONTACT = "TB_CONTACT";
    public static final String CONTACT_ID = "CONTACT_ID";
    public static final String CONTACT_USER = "CONTACT_USER";
    public static final String CONTACT_HOTEL = "CONTACT_HOTEL";
    public static final String CONTACT_DESCRIPTION = "CONTACT_DESCRIPTION";
    public static final String TB_BOOKING = "TB_BOOKING";
    public static final String BOOKID = "BOOKID";
    public static final String BOOK_CODE = "BOOK_CODE";
    public static final String BOOK_USER = "BOOK_USER";
    public static final String BOOK_HOTEL = "BOOK_HOTEL";
    public static final String BOOK_ROOM = "BOOK_ROOM";
    public static final String USER_PHONE = "USER_PHONE";
    public static final String ADULTS = "ADULTS";
    public static final String CHILDREN = "CHILDREN";
    public static final String CHECKIN = "CHECKIN";
    public static final String CHECKOUT = "CHECKOUT";
    public static final String TB_PAYMENT = "TB_PAYMENT";
    public static final String PAYMENTID = "PAYMENTID";
    public static final String PAYMENT_CODE = "PAYMENT_CODE";
    public static final String PAYMENT_NAMEUSER_CARD = "PAYMENT_NAMEUSER_CARD";
    public static final String PAYMENT_USER_NUMBERCARD = "PAYMENT_USER_NUMBERCARD";
    public static final String PAYMENT_VALIDTHRU = "PAYMENT_VALIDTHRU";
    public static final String CVV = "CVV";


    public Database_HT(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TB_ACCOUNT + "(" + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " TEXT, " + USERHO + " TEXT, " + USERTEN + " TEXT, " + USEREMAIL + " TEXT, " + USERPASS + " TEXT, " + USER_REPASS + " TEXT)");
        db.execSQL("CREATE TABLE " + TB_HOTEL + "(" + HOTELID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HOTEL_CODE + " TEXT, " + HOTELNAME + " TEXT, " + HOTELCITY + " TEXT, " + HOTEL_ADDRESS + " TEXT, " + HOTEL_DES + " TEXT, " + HOTEL_SERVICE + " TEXT, " + HOTEL_POLICY + " TEXT, " + HOTEL_CHILDANDBED_POLICY + " TEXT, " + HOTEL_IMPORTANTINFOR + " TEXT)");
        db.execSQL("CREATE TABLE " + TB_STATUSROOM + "(" + STATUSROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + STATUSROOM + " TEXT)");
        db.execSQL("CREATE TABLE " + TB_ROOM + "(" + ROOMID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ROOM_CODE + " TEXT, " + RHOTEL + " INTEGER REFERENCES " +TB_HOTEL + " ("+ HOTELID + " ), " + ROOMNAME + " TEXT, " + ROOMDES + " TEXT, " + ROOM_AVAILABLEBED + " TEXT, " + ROOM_CONVENIENT + " TEXT, " + ROOM_CAPACITY + " INTEGER, " + RSTATUS + " INTEGER REFERENCES " + TB_STATUSROOM + "( " + STATUSROOM_ID + "), " + ROOMPRICE + " FLOAT)");
        db.execSQL("CREATE TABLE " + TB_RATE + "(" + RATEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RATE_USER + " INTEGER REFERENCES " + TB_ACCOUNT + "(" + USERID + "), " + RATE_HOTEL + " INTEGER REFERENCES " + TB_HOTEL + "(" + HOTELID + "), " + RATE_VIEW + " FLOAT, " + RATE_CLEAN + " FLOAT, " + RATE_WIFI + " FLOAT, " + RATE_COMFORTABLE + " FLOAT, " + RATE_STAFF + " FLOAT, " + RATE_COMMENT + " TEXT)");
        db.execSQL("CREATE TABLE " + TB_CONTACT + "(" + CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACT_USER + " INTEGER REFERENCES " + TB_ACCOUNT + "("+USEREMAIL + "), " + CONTACT_HOTEL + " INTEGER REFERENCES " + TB_HOTEL + "("+ HOTELID + "), " + CONTACT_DESCRIPTION + " TEXT)");
        db.execSQL("CREATE TABLE " + TB_BOOKING + "(" + BOOKID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BOOK_CODE + " TEXT, " + BOOK_USER + " INTEGER REFERENCES " + TB_ACCOUNT + "("+USERID + "), " + BOOK_HOTEL + " INTEGER REFERENCES " + TB_HOTEL + "("+ HOTELID + "), " + BOOK_ROOM + " INTEGER REFERENCES " + TB_ROOM + "("+ ROOMID + "), " + USER_PHONE + " INTEGER, " + ADULTS + " INTEGER, " + CHILDREN + " INTEGER, " + CHECKIN + " DATETIME, " + CHECKOUT + " DATETIME)");
        db.execSQL("CREATE TABLE " + TB_PAYMENT + "(" + PAYMENTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PAYMENT_CODE + " TEXT, PAYMENT_USER INTEGER REFERENCES " + TB_ACCOUNT + "("+ USERID + "), PAYMENT_HOTEL INTEGER REFERENCES " + TB_HOTEL + "("+HOTELID + "), PAYMENT_BOOKING INTEGER REFERENCES " + TB_BOOKING + "("+ BOOKID + "), " + PAYMENT_NAMEUSER_CARD + " TEXT, " + PAYMENT_USER_NUMBERCARD + " INTEGER, " + PAYMENT_VALIDTHRU + " DATE, " + CVV + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + TB_HOTEL);
        db.execSQL("DROP TABLE IF EXISTS " + TB_ROOM);
        db.execSQL("DROP TABLE IF EXISTS " + TB_STATUSROOM);
        db.execSQL("DROP TABLE IF EXISTS " + TB_CONTACT);
        db.execSQL("DROP TABLE IF EXISTS " + TB_RATE);
        db.execSQL("DROP TABLE IF EXISTS " + TB_BOOKING);
        db.execSQL("DROP TABLE IF EXISTS " + TB_PAYMENT);
        onCreate(db);
    }


}



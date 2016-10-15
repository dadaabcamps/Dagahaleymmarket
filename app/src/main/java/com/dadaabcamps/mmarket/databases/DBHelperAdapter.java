package com.dadaabcamps.mmarket.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dadaabcamps.mmarket.Message;
import com.dadaabcamps.mmarket.RV_ItemClickListener;

/**
 * Created by DAU ICT on 9/16/2016.
 */
public class DBHelperAdapter  extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "dadaab.db";
    private static final String TABLE_NAME = "login";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASS = "pass";
    private static final String CREATE_TABLE = "create table login (id integer primary key not null , " +
            "username text not null , pass text not null , email text not null);";

    SQLiteDatabase db;
    Context ctx;

    public DBHelperAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context; }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db; }

    private String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "select username, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



//    static class DBHelper extends SQLiteOpenHelper {
//        SQLiteDatabase db;
//        Context context;
//        private static final int DB_VERSION = 01;
//        private static final String TEXT_TYPE = "TEXT ";
//        private static final String INTEGER_TYPE = "INTEGER ";
//        private static final String COMMA = ", ";
//        private static final String P_KEY = "INTEGER PRIMARY KEY AUTOINCREMENT, ";
//        private static final String CREATE_CAMPTABLE = "CREATE TABLE "
//                + DatabaseStructure. CampTable.TABLE_NAME + "("
//                + DatabaseStructure. CampTable.UID + P_KEY
//                + DatabaseStructure. CampTable.CAMPNAME + TEXT_TYPE + COMMA
//                + DatabaseStructure. CampTable.LOCATION + TEXT_TYPE + ")";
//        private static final String DROP_CAMPTABLE = "DROP TABLE IF EXISTS" + DatabaseStructure.CampTable.TABLE_NAME;
//
//        public DBHelper(Context context) {
//            super(context, DatabaseStructure.DB_NAME,null, DB_VERSION);
//            this.context = context;
//        }
//        @Override
//        public void onCreate(SQLiteDatabase sqLiteDatabase) {
//            try {
//                db.execSQL(CREATE_CAMPTABLE);
//                Message.message(context, "DB TABLE CREATED");
//            } catch (SQLException e) {
//                Message.message(context, "TABLE NOT CREATED" + e);
//            }
//        }
//
//        @Override
//        public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1) {
//            try {
//                db.execSQL(DROP_CAMPTABLE);
//                onCreate(db);
//            } catch (SQLException e) {
//                Message.message(context, "DB TABLE UPGRADED"+e);
//            }
//        }
//    }//Ends DBHelper classs
}

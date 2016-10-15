package com.dadaabcamps.mmarket.databases;

/**
 * Created by DAU ICT on 9/15/2016.
 */
public class DatabaseStructure {
    public static final String DB_NAME = "refdb.db";
    public abstract class CampTable{

        public static final String TABLE_NAME = "camptable ";

        public static final String UID = "_id";
        public static final String CAMPNAME = "title";
        public static final String LOCATION = "location";
    }
}

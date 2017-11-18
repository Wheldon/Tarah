package mark.programs.com.sqllab;

import android.provider.BaseColumns;

import static mark.programs.com.sqllab.Contract.contacts.TABLE_CONTACTS;

/**
 * Created by root on 10/24/17.
 */

public final class Contract {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="contactsManager";



    private Contract(){
    }
    public static abstract class contacts implements BaseColumns {
        public static final String TABLE_CONTACTS = "contacts";
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_PH_NO = "phone_number";

        public static final String CREATE_TABLE = " CREATE TABLE " + TABLE_CONTACTS + " ( " + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT " + " ) ";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONTACTS;
    }

        public static abstract class users implements BaseColumns {
            public static final String TABLE_USERS = "users";
            public static final String _ID = "id";
            public static final String _NAME = "name";
            public static final String KEY_GENDER = "gender";

            public static final String CREATE_TABLE1 = " CREATE TABLE " + TABLE_USERS + " ( " + _ID + " INTEGER PRIMARY KEY," + _NAME + " TEXT," + KEY_GENDER + " TEXT " + " ) ";
            public static final String DELETE_TABLE1 = "DROP TABLE IF EXISTS " + TABLE_USERS;
        }
    }



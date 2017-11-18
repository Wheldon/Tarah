package mark.programs.com.sqllab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static mark.programs.com.sqllab.Contract.DATABASE_VERSION;
import static mark.programs.com.sqllab.Contract.contacts.KEY_ID;
import static mark.programs.com.sqllab.Contract.contacts.KEY_NAME;
import static mark.programs.com.sqllab.Contract.contacts.KEY_PH_NO;
import static mark.programs.com.sqllab.Contract.contacts.TABLE_CONTACTS;
import static mark.programs.com.sqllab.Contract.users.TABLE_USERS;
import static mark.programs.com.sqllab.Contract.users._ID;
import static mark.programs.com.sqllab.Contract.users._NAME;
import static mark.programs.com.sqllab.Contract.users.KEY_GENDER;

/**
 * Created by root on 10/17/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context,Contract.DATABASE_NAME,null,Contract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Contract.contacts.CREATE_TABLE);

        db.execSQL(Contract.users.CREATE_TABLE1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Contract.contacts.DELETE_TABLE);
        db.execSQL(Contract.users.DELETE_TABLE1);
    onCreate(db);
    }
    public void addContact(Contacts contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_NAME,contact.getName());
        values.put(KEY_PH_NO,contact.getPhoneNumber());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }
    public void addUser(People people){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(_NAME,people.getName());
        values.put(KEY_GENDER,people.getGender());
        db.insert(TABLE_USERS, null, values);
        db.close();
    }
    public Contacts getContact(int id){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_CONTACTS,new String[]{
            KEY_ID,KEY_NAME,KEY_PH_NO},KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();
        Contacts contact=new Contacts(Integer.parseInt(cursor.getString(0)),
        cursor.getString(1),cursor.getString(2));
        return contact;
        }
    public People getPeople(int id){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_USERS,new String[]{
                        _ID,_NAME,KEY_GENDER},_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();
        People people=new People(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2));
        return people;

    }
    public List<Contacts> getAllContacts(){
        List<Contacts> contactList=new ArrayList<>();
        String selectQuery=" SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                Contacts contact = new Contacts();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
            return contactList;
    }
    public List<People> getAllPeople(){
        List<People> peopleList=new ArrayList<>();
        String selectQuery=" SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                People people = new People();
                people.setID(Integer.parseInt(cursor.getString(0)));
                people.setName(cursor.getString(1));
                people.setGender(cursor.getString(2));
                peopleList.add(people);
            } while (cursor.moveToNext());
        }
        return peopleList;
    }
    public int getContactsCount(){
        String countQuery=" SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }
    public int getPeopleCount(){
        String countQuery=" SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }
    public int updateContact(Contacts contact){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_NAME,contact.getName());
        values.put(KEY_PH_NO,contact.getPhoneNumber());
        return db.update(TABLE_CONTACTS,values,KEY_ID + "=? ",
                new String[]{String.valueOf(contact.getID())});
    }
    public int updatePeople(People people){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put(_NAME,people.getName());
        values.put(KEY_GENDER,people.getGender());
        return db.update(TABLE_USERS,values,_ID + "=? ",
                new String[]{String.valueOf(people.getID())});
    }
    public void deleteContact(Contacts contact){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_CONTACTS,KEY_ID+ "=? ",
                new String[]{String.valueOf(contact.getID())});
        db.close();
    }
    public void deletePeople(People people){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_USERS,_ID+ "=? ",
                new String[]{String.valueOf(people.getID())});
        db.close();
    }
}


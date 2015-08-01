package app.yalku.exampledatabasedevf_android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.yalku.exampledatabasedevf_android.model.ContactModel;

/**
 * Created by sati on 31/07/2015.
 */
public class HandlerContactsDataBase {

    private ContactsSQLiteHelper contactsSQLiteHelper;

    private static final String[] columns = new String[]{ConstansDataBase.KEY_NAME, ConstansDataBase.KEY_PHONE};


    public HandlerContactsDataBase(Context context) {
        this.contactsSQLiteHelper = new ContactsSQLiteHelper(context);
    }

    public void insertContact(String name, String phone) {

        SQLiteDatabase database = contactsSQLiteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstansDataBase.KEY_NAME, name);
        contentValues.put(ConstansDataBase.KEY_PHONE, phone);

        database.insert(ConstansDataBase.TABLE_NAME, null, contentValues);
    }

    public void updateContact(String name, String phone) {

        SQLiteDatabase database = contactsSQLiteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstansDataBase.KEY_PHONE, phone);

        database.update(ConstansDataBase.TABLE_NAME, contentValues, ConstansDataBase.KEY_NAME + " =?", new String[]{name});

    }

    public  void deleteContact (String name)
    {
        SQLiteDatabase database = contactsSQLiteHelper.getWritableDatabase();

        database.delete(ConstansDataBase.TABLE_NAME, ConstansDataBase.KEY_NAME + " =?", new String[]{name});
    }

    public List<ContactModel> queryContacts() {

        SQLiteDatabase database = contactsSQLiteHelper.getReadableDatabase();
        List<ContactModel> contactList = new ArrayList<>();

        Cursor cursor = database.query(ConstansDataBase.TABLE_NAME, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                ContactModel contact = new ContactModel(cursor.getString(0), cursor.getString(1));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;

    }


}

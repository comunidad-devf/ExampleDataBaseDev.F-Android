package app.yalku.exampledatabasedevf_android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sati on 31/07/2015.
 */
public class ContactsSQLiteHelper extends SQLiteOpenHelper {


    public ContactsSQLiteHelper(Context context) {
        super(context, "MiDataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabla = "CREATE TABLE "+ ConstansDataBase.TABLE_NAME+ " ( "+ ConstansDataBase.KEY_NAME+" TEXT, "+ ConstansDataBase.KEY_PHONE+" INTENGER )";
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}



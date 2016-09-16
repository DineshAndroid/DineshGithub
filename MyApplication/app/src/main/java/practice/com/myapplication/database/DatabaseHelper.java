package practice.com.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dinesh.Sengar on 05-08-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private final static  String  DB_NAME ="MyDatabse.db";
    private final static  int  DB_VERSION =1;
    private final static  String comma_sep=",";
    private static final String CREATE_MY_INFO_TABLE = "CREATE TABLE "+
            MyInfomationContract.MyInfoReader.TABLE_NAME+" ("+
            MyInfomationContract.MyInfoReader.COLUMN_NAME_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL"+
            comma_sep+MyInfomationContract.MyInfoReader.COLUMN_NAME_TITLE+" TEXT "+")";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      sqLiteDatabase.execSQL(CREATE_MY_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newerVersion) {
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_MY_INFO_TABLE);
    }
}

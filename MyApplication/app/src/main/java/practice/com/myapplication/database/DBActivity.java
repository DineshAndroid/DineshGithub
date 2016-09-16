package practice.com.myapplication.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import practice.com.myapplication.R;


public class DBActivity extends AppCompatActivity {
    DatabaseHelper  dbHelper;
    TextView tv;
    EditText etValue;
    SQLiteDatabase   db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        tv=(TextView)findViewById(R.id.tv_data);
        Button  btn_update=(Button) findViewById(R.id.btn_update);
        Button  btn_create=(Button) findViewById(R.id.btn_create);
        etValue=(EditText) findViewById(R.id.et_value);

        dbHelper=new DatabaseHelper(this);
        dbHelper.getWritableDatabase();

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createData();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDate();
            }
        });
    }

    private void createData() {
        if(etValue.getText().length()>0)
        {
            ContentValues  values=new ContentValues();
           // values.put(MyInfomationContract.MyInfoReader.COLUMN_NAME_ID,);
            values.put(MyInfomationContract.MyInfoReader.COLUMN_NAME_TITLE,etValue.getText().toString());
            db.insert(MyInfomationContract.MyInfoReader.TABLE_NAME,"null",values);
            etValue.setText("");
            showRecord();
        }
    }

    private void  showRecord()
    {
        SQLiteDatabase db2=  dbHelper.getReadableDatabase();
       // String MY_PROJECTION[]={MyInfomationContract.MyInfoReader.COLUMN_NAME_ID, MyInfomationContract.MyInfoReader.COLUMN_NAME_TITLE};

        Cursor cursor=db.query(MyInfomationContract.MyInfoReader.TABLE_NAME,null,null,null,null,null,null);

       // Cursor cursor=db2.rawQuery("select * from "+ MyInfomationContract.MyInfoReader.TABLE_NAME,null);
        String data="";
        if (cursor.moveToFirst())
        {
            do{
                int id= cursor.getInt(cursor.getColumnIndex(MyInfomationContract.MyInfoReader.COLUMN_NAME_ID));
                String title=cursor.getString(cursor.getColumnIndex(MyInfomationContract.MyInfoReader.COLUMN_NAME_TITLE));
                data=data+id+","+title;
            }while (cursor.moveToNext());
        }

        tv.setText(data);

    }

    private void updateDate()
    {
        db=dbHelper.getWritableDatabase();
        db.rawQuery("UPDATE "+ MyInfomationContract.MyInfoReader.TABLE_NAME+ " SET title='updated value' WHERE id=2",null);
        tv.setText("");
        showRecord();

        usingAggregateFunctions();
    }

    private void usingAggregateFunctions()
    {

        Cursor cusrsor= db.query(MyInfomationContract.MyInfoReader.TABLE_NAME, new String [] {"COUNT(*)"}, null, null, null, null, null);
        //Cursor cusrsor=db.rawQuery("SELECT COUNT(*) "+MyInfomationContract.MyInfoReader.TABLE_NAME,null);
        if (cusrsor!=null)
        {
            cusrsor.moveToFirst();
            int count=cusrsor.getInt(0);
            Log.e("count",""+count);
        }

        cusrsor.close ();


        Cursor cusrsor2= db.query(MyInfomationContract.MyInfoReader.TABLE_NAME, new String [] {"SUM(id)"}, null, null, null, null, null);
        //Cursor cusrsor=db.rawQuery("SELECT COUNT(*) "+MyInfomationContract.MyInfoReader.TABLE_NAME,null);
        if (cusrsor2!=null)
        {
            cusrsor2.moveToFirst();
            int count=cusrsor2.getInt(0);
            Log.e("sum",""+count);
        }

        cusrsor2.close ();


        Cursor cusrsor3= db.query(MyInfomationContract.MyInfoReader.TABLE_NAME, new String [] {"AVG(id)"}, null, null, null, null, null);
        //Cursor cusrsor=db.rawQuery("SELECT COUNT(*) "+MyInfomationContract.MyInfoReader.TABLE_NAME,null);
        if (cusrsor3!=null)
        {
            cusrsor3.moveToFirst();
            int count=cusrsor3.getInt(0);
            Log.e("average",""+count);
        }

        cusrsor3.close ();

    }
}

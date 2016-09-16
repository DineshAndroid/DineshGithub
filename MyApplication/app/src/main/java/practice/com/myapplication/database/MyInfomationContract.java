package practice.com.myapplication.database;

import android.provider.BaseColumns;

/**
 * Created by Dinesh.Sengar on 05-08-2016.
 */
public final class MyInfomationContract {

    MyInfomationContract()
    {}
    public  static  abstract  class  MyInfoReader implements BaseColumns{
     public  static  final String  TABLE_NAME="myInfo";
     public  static  final String  COLUMN_NAME_TITLE="title";
     public  static  final String  COLUMN_NAME_ID="id";

    }
}

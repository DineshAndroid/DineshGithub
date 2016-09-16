package practice.com.myapplication.parcableexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Dinesh.Sengar on 17-08-2016.
 */
public class StudentRecords implements Parcelable {

    public  String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public StudentRecords() {
    }

    protected StudentRecords(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<StudentRecords> CREATOR = new Creator<StudentRecords>() {
        @Override
        public StudentRecords createFromParcel(Parcel source) {
            return new StudentRecords(source);
        }

        @Override
        public StudentRecords[] newArray(int size) {
            return new StudentRecords[size];
        }
    };
}
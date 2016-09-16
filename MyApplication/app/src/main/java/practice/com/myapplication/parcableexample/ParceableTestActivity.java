package practice.com.myapplication.parcableexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import practice.com.myapplication.R;

/**
 * Created by Dinesh.Sengar on 17-08-2016.
 */
public class ParceableTestActivity extends AppCompatActivity {

    StudentRecords  records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_parciable);
        records=getIntent().getParcelableExtra("studentReocrd");

        Button btn=(Button)findViewById(R.id.btn_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                records.name="Vivek";
                Toast.makeText(ParceableTestActivity.this,"my name is"+records.name,Toast.LENGTH_LONG).show();
                setResult(1,new Intent());
                finish();
            }
        });

    }
}

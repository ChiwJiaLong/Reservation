package sg.edu.rp.c346.id20031634.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText etname, etnumber, etgroup;
    Button ButtonReset,ButtonSubmit;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;
    TextView tvname, tvnumber, tvsize, tvdate, tvtime, tvsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cb = findViewById(R.id.checkBoxSmoke);
        tvname = findViewById(R.id.Dname);
        tvnumber =findViewById(R.id.Dnumber);
        tvsize = findViewById(R.id.Dsize);
        tvdate = findViewById(R.id.Ddate);
        tvtime = findViewById(R.id.Dtime);
        tvsa = findViewById(R.id.Dsa);
        ButtonReset = findViewById(R.id.buttonReset);
        ButtonSubmit = findViewById(R.id.buttonSubmit);
        etname = findViewById(R.id.editTextName);
        etnumber = findViewById(R.id.editTextNumber);
        etgroup = findViewById(R.id.editTextGroup);


        etname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = etname.getText().toString();
                int ilength = Integer.parseInt(length);
                if (ilength == 0) {
                    Toast.makeText(MainActivity.this, "Cannot have a blank field", Toast.LENGTH_LONG).show();
                    etnumber.setText("");
                }
            }
        });


        ButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etname.setText("");
                etgroup.setText("");
                etnumber.setText("");
                cb.setChecked(false);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2021,05,01);
                tvname.setText("");
                tvnumber.setText("");
                tvdate.setText("");
                tvsize.setText("");
                tvsa.setText("");
                tvtime.setText("");
                Toast.makeText(MainActivity.this,"Reset Clicked", Toast.LENGTH_LONG).show();
            }
        });


        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinputname = etname.getText().toString();
                int iuserinputname = Integer.parseInt(userinputname);
                if(iuserinputname < 1){
                    Toast.makeText(MainActivity.this," Cannot have blank", Toast.LENGTH_LONG).show();
                    tvnumber.setText("");
                    tvsize.setText("");
                }else{
                    tvname.setText("Name: " + iuserinputname);
                }

                String userinputsize = etgroup.getText().toString();
                tvsize.setText("Group Size: " + userinputsize);

                String userinputnumber = etnumber.getText().toString();
                tvnumber.setText("Mobile Number: " + userinputnumber);

                if(cb.isChecked()){
                    tvsa.setText("Selected Smoking Area. ");
                }else{
                    tvsa.setText("Selected Non-Smoking Area.");
                }

                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                tvdate.setText("Date is " + day + "/" + month + "/" + year);

                String time = "Time  reserve is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                tvtime.setText(time);
                Toast.makeText(MainActivity.this,"Submit Clicked", Toast.LENGTH_LONG).show();


            }
        });

    }
}
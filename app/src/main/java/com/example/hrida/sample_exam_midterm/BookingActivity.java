package com.example.hrida.sample_exam_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    private ImageView img1;
    private TextView modal;
    private EditText from;
    private EditText to;
    private RadioGroup rdPayment;
    private RadioGroup rdTrip;
    private Button cancel;
    private Button reserve;
    private double amount;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent i1 = getIntent();

        pos = i1.getExtras().getInt("pos");

        img1 = (ImageView)findViewById(R.id.carImageBooking);
        modal = (TextView)findViewById(R.id.carName);
        from = (EditText)findViewById(R.id.editTextFrom);
        to = (EditText)findViewById(R.id.editTextTo);
        cancel = (Button)findViewById(R.id.btnCancel);
        reserve = (Button)findViewById(R.id.btnReserve);
        rdPayment = (RadioGroup)findViewById(R.id.rdPayment);
        rdTrip = (RadioGroup)findViewById(R.id.rdTrip);
        amount = Data.price[pos];
        img1.setImageResource(Data.pictures[pos]);
        modal.setText(Data.names[pos]);

        from.setText(Data.location[pos]);
        to.setText(Data.desination[pos]);
        // Made them edit Text Incase the user wants a custom location
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RadioButton trip  = (RadioButton)findViewById(rdTrip.getCheckedRadioButtonId());
                    RadioButton payment  = (RadioButton)findViewById(rdPayment.getCheckedRadioButtonId());
                    String fromValue =  from.getText().toString();
                    String toValue = to.getText().toString();
                    String paymentValue = payment.getText().toString();
                    String car = Data.names[pos];

                    if(fromValue.length() < 1 || toValue.length() < 1) {
                        Toast.makeText(BookingActivity.this, "Please fill all the data", Toast.LENGTH_SHORT).show();
                    }else {
                        String toastString = "You will be picked from " + fromValue +" to" +toValue + " by " + car + " taxi and you will pay " + amount + " " + paymentValue;
                        Toast.makeText(BookingActivity.this, toastString, Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(BookingActivity.this, "Please fill all the data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

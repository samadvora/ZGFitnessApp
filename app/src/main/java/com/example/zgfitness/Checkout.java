package com.example.zgfitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    //Checkout Page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " + getString(R.string.shipping));

        //Using findViewById method to find the View for the specific ID.
        EditText name = (EditText) findViewById(R.id.billing_name);
        EditText phone = (EditText) findViewById(R.id.phone_number);
        EditText address = (EditText) findViewById(R.id.address);
        EditText city = (EditText) findViewById(R.id.city);
        EditText province = (EditText) findViewById(R.id.state);
        EditText postalcode = (EditText) findViewById(R.id.zip_code);
        Button btn = (Button) findViewById(R.id.cancel);
        Button btnSub = (Button) findViewById(R.id.buttonSubmit);

        //Calling the Data manager class to handle all data driven actions.
        DataManager dm = new DataManager(this);

        //Passing the data by Converting it to String when clicked on Submit button & Using Intent to move to another activity.
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.insert(name.getText().toString(), phone.getText().toString(), address.getText().toString(), city.getText().toString(), province.getText().toString(), postalcode.getText().toString());
                Intent i2 = new Intent(Checkout.this, Success.class);
                startActivity(i2);
            }
        });

        //Using Intent to Come back to the MainActivity if the user hits on Cancel Button.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Checkout.this, MainActivity.class);
                startActivity(i3);
            }
        });
    }
}



package com.example.zgfitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MembershipDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership_details);

        Intent i = getIntent();
        String name = i.getStringExtra("Name");
        String desc = i.getStringExtra("Desc");
        String facilities = i.getStringExtra("Facilities");
        int img = getIntent().getIntExtra("Img", R.drawable.bronze);
        String admissionFee = i.getStringExtra("AdmissionFee");
        String monthlyFee = i.getStringExtra("MonthlyFee");
        String commitment = i.getStringExtra("Commitment");

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " + name + " " +getString(R.string.details));

        TextView membershipName = (TextView) findViewById(R.id.name);
        membershipName.setText(name);

        TextView membershipDesc = (TextView) findViewById(R.id.desc);
        membershipDesc.setText("Description: "+desc);

        TextView membershipFacilities = (TextView) findViewById(R.id.facilities);
        membershipFacilities.setText("Facilities: "+facilities);

        TextView membershipAdmissionFee = (TextView) findViewById(R.id.admissionFee);
        membershipAdmissionFee.setText("Admission Fee: "+admissionFee);

        TextView membershipMonthlyFee = (TextView) findViewById(R.id.monthlyFee);
        membershipMonthlyFee.setText("Monthly Fee: "+monthlyFee);

        TextView membershipCommitment = (TextView) findViewById(R.id.commitment);
        membershipCommitment.setText("Commitment: "+commitment);

        ImageView image = (ImageView) findViewById(R.id.img);
        image.setImageResource(img);

        Button add = (Button) findViewById(R.id.add);
        Button back = (Button) findViewById(R.id.back);

        //Using Intent to go back to the MovieList page once user clicks on the Back Button.
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MembershipDetails.this, MembershipList.class);
                startActivity(i1);
            }
        });

        //Using Intent to open the CheckOut Page once the user clicks on Add to Cart.
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MembershipDetails.this, Checkout.class);
                startActivity(i);
            }
        });
    }
}
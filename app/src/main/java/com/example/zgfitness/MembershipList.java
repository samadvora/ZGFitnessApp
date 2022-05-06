package com.example.zgfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MembershipList extends AppCompatActivity {

    RecyclerView recyclerView;
    MembershipAdapter membershipAdapter;
    List<Membership> membershipList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " +getString(R.string.types));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        recyclerView = findViewById(R.id.rView);
        membershipList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        membershipList.add(new Membership("Bronze","ZG Fitness Bronze Membership!","Unlimited Access to Home Club, PF Mobile App",R.drawable.bronze,"$50 Admission Fee","$15 Monthly.","No"));
        membershipList.add(new Membership("Silver","ZG Fitness Silver Membership!","Unlimited Access to Home Club, PF Mobile App, Free Fitness Training, Free WiFi",R.drawable.silver,"$50 Admission Fee","$20 Monthly.","No"));
        membershipList.add(new Membership("Gold","ZG Fitness Gold Membership!","Unlimited Access to Home Club, PF Mobile App, Free Fitness Training, Free WiFi, Use of Tanning, Use of Massage Chairs",R.drawable.gold,"$50 Admission Fee","$25 Monthly.","No"));
        membershipList.add(new Membership("Diamond","ZG Fitness Diamond Membership!","Unlimited Access to Home Club, PF Mobile App, Free Fitness Training, Free WiFi, Use of Tanning, Use of Massage Chairs, Use of HydroMassage",R.drawable.diamond,"$50 Admission Fee","$30 Monthly.","No"));
        membershipList.add(new Membership("Platinum","ZG Fitness Platinum Membership!","Unlimited Access to Home Club, PF Mobile App, Free Fitness Training, Free WiFi, Use of Tanning, Use of Massage Chairs, Use of HydroMassage, Use of Total Body Enhancement",R.drawable.platinum,"$50 Admission Fee","35 Monthly.","No"));
        membershipAdapter = new MembershipAdapter(this, membershipList);
        recyclerView.setAdapter(membershipAdapter);
    }
}
package com.example.zgfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " + getString(R.string.app_name));


    }

    //Using Intent to move from one activity to another.
    public void buttonClick(View view) {
        Intent i1 = new Intent(HomeActivity.this, MembershipList.class);
        startActivity(i1);
    }

    //Using Intent to move from one activity to another.
    public void buttonClick1(View view) {
        Intent i2 = new Intent(HomeActivity.this, ShowList.class);
        startActivity(i2);
    }

    //Using Intent to move from one activity to another.
    public void buttonClick2(View view) {
        Intent i3 = new Intent();
        i3.setClass(getApplicationContext(),MapsActivity.class);
        startActivity(i3);
    }

    //Using Intent to move from one activity to another.
    public void buttonClick3(View view) {
        Intent i4 = new Intent();
        i4.setClass(HomeActivity.this, EditActivity.class);
        startActivity(i4);
    }
}
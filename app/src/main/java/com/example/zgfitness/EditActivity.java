package com.example.zgfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText oldpassword, password, repassword;
    Button changepassword, deleteuser;
    DBHelper DB;
    String user = "dinesh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " +getString(R.string.edit));

        //Using findViewById method to find the View for the specific ID.
        DB = new DBHelper(this);
        oldpassword = (EditText) findViewById(R.id.oldpassword);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        changepassword = (Button) findViewById(R.id.changepassword);
        deleteuser = (Button) findViewById(R.id.deleteuser);

        //Changing password on Click
        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldppassword = oldpassword.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(EditActivity.this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)) {
                            Boolean update = DB.updateData(user, pass);
                            if(update==true) {
                                Toast.makeText(EditActivity.this, "Password Updated Successfully.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(EditActivity.this, "Password update Failed.", Toast.LENGTH_SHORT).show();
                            }
                    }
                    else
                    {
                        Toast.makeText(EditActivity.this, "Passwords are not matching.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Deleting user on Click
        deleteuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean delete = DB.deleteData(user);
                if(delete==true){
                    Toast.makeText(EditActivity.this, "User Deleted Successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(EditActivity.this, "Unable to Delete User.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
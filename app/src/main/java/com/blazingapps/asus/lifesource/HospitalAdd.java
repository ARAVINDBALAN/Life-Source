package com.blazingapps.asus.lifesource;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class HospitalAdd extends AppCompatActivity {
    public RecyclerView docrec;
    private FirebaseRecyclerAdapter adapter;
    Button add;
    public DatabaseReference mdatabasereference;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String HOSPITAL_REF = "hospital";
    private static final int REQCODE = 1;
    private static final String MYPREF = "mypreferences";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String MOBILE = "mobile";
    private static final String FAX = "fax";
    private static final String EMAIL = "email";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String HOSPITAL_ID = "hospitalid";
    private static final String REGISTERED = "registered";
    private static final String ADMIN = "admin";
    private static final String PUSH_KEY = "pushkey";
    doctors doc;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_add);
        docrec = findViewById(R.id.recycledoctors);
        sharedPreferences = getApplicationContext().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        mdatabasereference = FirebaseDatabase.getInstance().getReference().child("hospital");
        mdatabasereference.keepSynced(true);
        docrec.setLayoutManager(new LinearLayoutManager(this));
        add = findViewById(R.id.add_doctor_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("hospital").child(sharedPreferences.getString(PUSH_KEY,"")).child("doclist");
                String hosid = FirebaseAuth.getInstance().getUid();
                doc = new doctors("abc","ortho","yes");
                databaseReference.setValue(doc);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();


    }


}

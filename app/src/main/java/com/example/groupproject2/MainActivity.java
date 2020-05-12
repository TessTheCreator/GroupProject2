package com.example.groupproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupproject2.Model.Hotel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView t;
    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.test);

        addDefaultData();;
        saveData();

    }

    public void addDefaultData(){
        hotelList.add(new Hotel(1, "hllo"));
        hotelList.add(new Hotel(2, "hllfgdgo"));
        hotelList.add(new Hotel(3, "hldfgdfuulo"));
    }

    private void saveData(){
        loadData();
        hotelList.add(new Hotel( 1, "helloer"));
        SharedPreferences s = getSharedPreferences("HOTELS", MODE_PRIVATE);
        SharedPreferences.Editor editor = s.edit();
        Gson gson = new Gson();
        String json = gson.toJson(hotelList);
        editor.putString("hotellist", json);
        editor.apply();

    }

    private void loadData(){
        SharedPreferences s = getSharedPreferences("HOTELS", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = s.getString("hotellist", null);
        Type type = new TypeToken<ArrayList<Hotel>>() {}.getType();
        if (gson.fromJson(json,type)!=null) {
            ArrayList<Hotel> load = gson.fromJson(json, type);
            if (load != null && load.isEmpty() != true) {
                hotelList = load;

                print(load.toString());

            }
        }

    }




    public void print(String msg){
        Toast.makeText(getApplicationContext(), msg,
                Toast.LENGTH_LONG).show();
    }
}

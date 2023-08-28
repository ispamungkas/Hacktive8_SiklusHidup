package com.unknow.siklushidup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("siklus", "on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = this.getSharedPreferences("sharedata",Context.MODE_PRIVATE);
        SharedPreferences.Editor tambah = sharedPreferences.edit();
        tambah.putString("temp", nama.getText().toString());
        tambah.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String data = this.getSharedPreferences("sharedata",Context.MODE_PRIVATE).getString("temp", null);
        nama.setText(data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("siklus", "on Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = this.getSharedPreferences("sharedata", Context.MODE_PRIVATE);
        SharedPreferences.Editor tambah = sharedPreferences.edit();
        tambah.putString("temp", nama.getText().toString());
        tambah.apply();
    }
}
package com.danielescobar.qareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
// Version 1.6
public class MainActivity extends AppCompatActivity {
    String sCorreoP, sContraseñaP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();
        if (extras!= null) {
            sCorreoP=String.valueOf(extras.get("correo"));
            sContraseñaP=String.valueOf(extras.get("contraseña1"));


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mPerfil) {
            Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
            intent.putExtra("correo", sCorreoP);
            intent.putExtra("contraseña1", sContraseñaP);
            setResult(RESULT_OK,intent);
            startActivityForResult(intent, 4);
            finish();
        }
        else if (id==R.id.mCerrar)
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            intent.putExtra("correo", sCorreoP);
            intent.putExtra("contraseña1", sContraseñaP);
            setResult(RESULT_OK,intent);
            startActivityForResult(intent,1);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        finish();

        super.onBackPressed();
    }

}

package com.examemily.examenpmdm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.examemily.examenpmdm.databinding.ActivityMainBinding;
import com.examemily.examenpmdm.uifragmentos.Paginador;

public class MainActivity extends AppCompatActivity {
   private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("DEBUG", "Binding inicializado");

        Paginador paginador = new Paginador(getSupportFragmentManager(), this);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        ViewPager viewPager = binding.viewPager;

        if(id == 0){

        }
        if(id == 1){
            TextView welcomeText = findViewById(R.id.username);
            SharedPreferences sharedPreferences = getSharedPreferences("Usuario", MODE_PRIVATE);
            String nombre = sharedPreferences.getString("username", "anonimo");
            welcomeText.setText("hola " + nombre);
        }
        if(id == 0){

        }
        return super.onOptionsItemSelected(item);
    }

}
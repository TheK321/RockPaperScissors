package com.example.piedrapapeltijeras_youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private TextInputEditText TIET_nombreJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.TIET_nombreJugador = findViewById(R.id.nombreJugador);
    }

    public void onClick(View view) {
        String nombreJugador = TIET_nombreJugador.getText().toString().trim();

        if (!nombreJugador.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("jugador", nombreJugador);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Primero debes escribir tu nombre: ", Toast.LENGTH_SHORT).show();
            //abrir teclado del celular
            TIET_nombreJugador.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(TIET_nombreJugador, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
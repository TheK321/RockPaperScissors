package com.example.piedrapapeltijeras_youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nombre_jugador = "";
    int datoJugador = 0;
    int datoComputer = 0;
    private TextView tv_nombreJugador;
    int scoreJugador;
    int scoreComputer;

    private ImageView dataJugador;
    private ImageView dataComputer;
    private TextView tv_scoreJugador;
    private TextView tv_scoreComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //obtener nombre jugador del activity login
            nombre_jugador = getIntent().getStringExtra("jugador");

            this.tv_nombreJugador = findViewById(R.id.NombreJugador);
            tv_nombreJugador.setText(nombre_jugador);

            //casteo
            this.dataJugador = findViewById(R.id.DataJugador);
            this.dataComputer = findViewById(R.id.DataComputer);
            this.tv_scoreJugador = findViewById(R.id.ScoreJugador);
            this.tv_scoreComputer = findViewById(R.id.ScoreComputer);
        } catch (Exception e) {
            Toast.makeText(this, "Error 1 " + e, Toast.LENGTH_LONG).show();
        }

    }

    public void onClick(View view) {

        if (view.getId() == R.id.Piedra) {
            datoJugador = 1;
        } else if (view.getId() == R.id.Papel) {
            datoJugador = 2;
        } else if (view.getId() == R.id.Tijera) {
            datoJugador = 3;
        }
        AleatorioDataComputer();
    }

    //metodo dato jugador
    public void ResultadoJugador() {
        if (datoJugador == 1) {
            dataJugador.setImageResource(R.drawable.piedra);
        } else if (datoJugador == 2) {
            dataJugador.setImageResource(R.drawable.papel);
        } else if (datoJugador == 3) {
            dataJugador.setImageResource(R.drawable.tijera);
        }

        Resultado();
    }

    public void AleatorioDataComputer() {
        //clase Aleatorio
        int num_aleatorio = (int) (Math.random() * 3);
        num_aleatorio = num_aleatorio + 1;
        if (num_aleatorio == 1) {
            dataComputer.setImageResource(R.drawable.piedra2);
            datoComputer = 1;
        } else if (num_aleatorio == 2) {
            dataComputer.setImageResource(R.drawable.papel2);
            datoComputer = 2;
        } else if (num_aleatorio == 3) {
            dataComputer.setImageResource(R.drawable.tijera2);
            datoComputer = 3;
        }
        //ejecuto el metodo ResultadoJugador
        ResultadoJugador();
    }

    //compara quien gana
    public void Resultado() {
        try {
            if (datoJugador == datoComputer) {
                Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            } else if ( (datoJugador == 1 && datoComputer == 2) || (datoJugador == 2 && datoComputer == 3)  ||  (datoJugador == 3 && datoComputer == 1) )  {
                //piedra vs papel (gano papel computer)
                scoreComputer++;
                tv_scoreComputer.setText("Score: " + String.valueOf(scoreComputer));
            } else if ( (datoJugador == 1 && datoComputer == 3)  ||  (datoJugador == 2 && datoComputer == 1)  || (datoJugador == 3 && datoComputer == 2) ) {
                //piedra vs tijera (gano piedra jugador)
                scoreJugador++;
                tv_scoreJugador.setText("Score: " + String.valueOf(scoreJugador));
            }
            Fin();
        } catch (Exception e) {
            Toast.makeText(this, "Error en: " + e, Toast.LENGTH_LONG).show();
        }
    }

    public void Fin() {
        if (scoreJugador == 10) {
            Toast.makeText(this, "Ganastes " + nombre_jugador + ". Score: " + scoreJugador, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (scoreComputer == 10) {
            Toast.makeText(this, "¡Lo siento perdistes ! " + nombre_jugador + ". gano la Computadora.  Score: " + scoreComputer, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //no hace nada
    }
}
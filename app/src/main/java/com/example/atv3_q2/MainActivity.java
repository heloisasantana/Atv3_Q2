package com.seuusuario.appautonomia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:Heloísa Santana da Silva
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextConsumo, editTextLitros;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes da interface
        editTextConsumo = findViewById(R.id.editTextConsumo);
        editTextLitros = findViewById(R.id.editTextLitros);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurando o evento de clique no botão "Calcular"
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAutonomia();
            }
        });
    }

    private void calcularAutonomia() {
        try {
            // Obtendo os valores dos EditTexts
            double consumoMedio = Double.parseDouble(editTextConsumo.getText().toString());
            double litrosCombustivel = Double.parseDouble(editTextLitros.getText().toString());

            // Calculando a autonomia em quilômetros
            double autonomiaKm = consumoMedio * litrosCombustivel;

            // Convertendo a autonomia de quilômetros para metros
            double autonomiaMetros = autonomiaKm * 1000;

            // Exibindo o resultado em metros
            textViewResultado.setText(String.format("Autonomia: %.2f metros", autonomiaMetros));
        } catch (NumberFormatException e) {
            textViewResultado.setText("Por favor, insira valores válidos.");
        }
    }
}

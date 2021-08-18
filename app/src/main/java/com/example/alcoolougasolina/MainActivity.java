package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;
    private Button botaoCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina );
        textResultado = findViewById(R.id.resultado);


    }

    public void calcularPreco(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validacao(precoAlcool, precoGasolina);

        if (camposValidados) {

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool / valorGasolina;

            if (resultado >= 0.7) {

                textResultado.setText("Melhor usar Gasolina");

            } else {
                textResultado.setText("Melhor usar alcool");

            }


        } else {

            textResultado.setText("Preencha os preços primeiro!");

        }


    }

    public Boolean validacao(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;

        } else if (pGasolina == null || pAlcool.equals("")) {
            camposValidados = false;
        }
        return camposValidados;


    }


}
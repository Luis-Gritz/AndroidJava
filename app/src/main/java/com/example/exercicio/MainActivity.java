package com.example.exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textDivisao, textPessoas;
    private SeekBar seekPessoas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPessoas = findViewById(R.id.textPessoas);
        textDivisao = findViewById(R.id.textDivisao);
        seekPessoas = findViewById(R.id.seekPessoas);

        seekPessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textPessoas.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }

    /*public void calcula_conta(View view) {

        String valorTextPessoa = valorPessoas.getText().toString();
        String valorTextConta = valorConta.getText().toString();
        double conta = Double.parseDouble(valorTextConta);
        double nPessoa = Double.parseDouble(valorTextPessoa);
        double result = conta/nPessoa;

        DecimalFormat df = new DecimalFormat("#0.00");

        String formatado = "R$" + df.format(result);

        textValor.setText(formatado);
    }*/
}

package com.example.exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText valorPessoas;
    private EditText valorConta;
    private TextView textValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorPessoas = findViewById(R.id.editValorPessoas);
        valorConta = findViewById(R.id.editValorConta);
        textValor = findViewById(R.id.textValor);
    }

    public void calcula_conta(View view) {

        String valorTextPessoa = valorPessoas.getText().toString();
        String valorTextConta = valorConta.getText().toString();
        double conta = Double.parseDouble(valorTextConta);
        double nPessoa = Double.parseDouble(valorTextPessoa);
        double result = conta/nPessoa;

        DecimalFormat df = new DecimalFormat("#0.00");

        String formatado = "R$" + df.format(result);

        textValor.setText(formatado);
    }
}

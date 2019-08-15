package com.example.exercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textDivisao, textPessoas;
    private SeekBar seekPessoas;
    private CheckBox checkAcrescimo;
    private double original;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textPessoas = findViewById(R.id.textPessoas);
        textDivisao = findViewById(R.id.textDivisao);
        seekPessoas = findViewById(R.id.seekPessoas);
        checkAcrescimo = findViewById(R.id.checkAcrescimo);
        editValor.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length()>0) {
                double valor = Double.parseDouble(charSequence.toString());
                double pessoas = seekPessoas.getProgress();
                double result = valor / pessoas;

                DecimalFormat df = new DecimalFormat("#0.00");

                String formatado = "R$" + df.format(result);

                textDivisao.setText(formatado);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(!editable.toString().isEmpty())
                original = Double.parseDouble(editable.toString());

        }
    });
        checkAcrescimo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    if (!editValor.getText().toString().isEmpty()){
                        double valor = original;
                        valor *= 1.1;
                        DecimalFormat df = new DecimalFormat("#0.00");
                        editValor.setText(df.format(valor));
                    }
                }else{
                    editValor.setText(String.valueOf(original));
                }
            }
        });

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
                if (!editValor.getText().toString().isEmpty()) {
                    double valor = Double.parseDouble(editValor.getText().toString());
                    double pessoas = seekPessoas.getProgress();
                    double result = valor / pessoas;

                    DecimalFormat df = new DecimalFormat("#0.00");

                    String formatado = "R$" + df.format(result);

                    textDivisao.setText(formatado);
                }
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

package com.asier.aranda.myprimerintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {


    TextView tv2;
    EditText et2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        tv2 = findViewById(R.id.tv2);
        Bundle extras = this.getIntent().getExtras();
        String mensaje = extras.getString("Extra_mensaje");
        tv2.setText(mensaje);
    }

    public void salir(View vista) {
        et2 = findViewById(R.id.et2);
        String mensaje_vuelta = et2.getText().toString();
        Intent my_resultado = new Intent();
        my_resultado.putExtra("Extra_vuelta", mensaje_vuelta);
        setResult(RESULT_OK, my_resultado);
        this.finish();

    }
}

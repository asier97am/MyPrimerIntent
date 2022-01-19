package com.asier.aranda.myprimerintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText editText1;
    public Button bt1;

    ActivityResultLauncher<Intent> my_ActivityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        bt1 = findViewById(R.id.bt1);

        my_ActivityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()== Activity.RESULT_OK){
                            //ACCIONES CUANDO VA OK
                            Intent my_intent_vuelta=result.getData();
                            String mensaje_vuelta = my_intent_vuelta.getStringExtra("Extra_vuelta").toString();
                            Context context = getApplicationContext();
                            //INDICO DURACION TOAST
                            int duration= Toast.LENGTH_LONG;
                            //TOAST
                            Toast toast=Toast.makeText(context,mensaje_vuelta,duration);
                            toast.show();

                        }
                        else if (result.getResultCode()==Activity.RESULT_CANCELED){
                            //ACCIONES SI FALLA
                            String mensaje_vuelta= "sin mensaje de vuelta";
                            Context context=getApplicationContext();
                            int duration = Toast.LENGTH_LONG;
                            //TOAST
                            Toast toast=Toast.makeText(context,mensaje_vuelta,duration);
                            toast.show();
                        }
                    }
                });
    }
    @Override
    protected void onStop(){
        super.onStop();
        setResult(RESULT_CANCELED,null);
    }



    public void lanzar_actividad(View vista) {
        editText1 = findViewById(R.id.editText1);
        String mensaje = editText1.getText().toString();

       /* Bundle my_bundle = new Bundle();
        my_bundle.putString("Extra_mensaje",mensaje);*/

        Intent my_intent = new Intent(MainActivity.this, SegundaActivity.class);
        my_intent.putExtra("Extra_mensaje", mensaje);
        /* my_intent.putExtra("Bundle",my_bundle);*/

        my_ActivityResultLauncher.launch(my_intent);// antes era //startActivity(my_intent);

    }

}
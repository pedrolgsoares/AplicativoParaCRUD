package com.pedrolgsoares.aplicativoparacrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.pedrolgsoares.aplicativoparacrud.R;
import com.pedrolgsoares.aplicativoparacrud.activity.FormularioPessoaActivity;

public class MainActivity extends AppCompatActivity {
    // Instanciando os atributos da Main Activity
    private ListView listView_pessoas;
    private Button button_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_pessoas = findViewById(R.id.listView_pessoas);
        button_cadastrar = findViewById(R.id.button_cadastrar);

        // Aplicando clickListener
        button_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar o objeto intent e adicionar a activity Formulario para ser chamada
                Intent intent = new Intent(getApplicationContext(), FormularioPessoaActivity.class);

                // Iniciar a chamada com startActivity
                startActivity(intent);
            }
        });
    }
}
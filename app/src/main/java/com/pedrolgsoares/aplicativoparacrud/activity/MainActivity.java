package com.pedrolgsoares.aplicativoparacrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.pedrolgsoares.aplicativoparacrud.DAO.PessoaDAO;
import com.pedrolgsoares.aplicativoparacrud.R;
import com.pedrolgsoares.aplicativoparacrud.activity.FormularioPessoaActivity;
import com.pedrolgsoares.aplicativoparacrud.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Instanciando os atributos da Main Activity
    private ListView listView_pessoas;
    private Pessoa pessoa;
    private PessoaDAO pessoaDAO;
    private ArrayList<Pessoa> listPessoa;
    private ArrayAdapter adapter;
    private Button button_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_pessoas = findViewById(R.id.listView_pessoas);

        // Aplicando o click nos itens para alteração
        listView_pessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pessoa cliquePessoa = (Pessoa) adapterView.getItemAtPosition(i);

                // Após o clique no item, será realizada a chamada da activity para mudar o cadastro
                Intent intent = new Intent(getApplicationContext(), FormularioPessoaActivity.class);
                intent.putExtra("objetoPessoa", cliquePessoa);
                startActivity(intent);

            }
        });

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

    @Override
    protected void onResume() {
        super.onResume();
        loadList();
    }

    public void loadList(){
        pessoaDAO = new PessoaDAO(getApplicationContext());
        listPessoa = pessoaDAO.getListDados();
        pessoaDAO.close();

        // Iniciando a condição de mostrar layout dos itens
        if(listPessoa != null){
            adapter = new ArrayAdapter<Pessoa>(getApplicationContext(), android.R.layout.simple_list_item_1, listPessoa);
            listView_pessoas.setAdapter(adapter);
        }

    }
}
package com.pedrolgsoares.aplicativoparacrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.pedrolgsoares.aplicativoparacrud.BdHelper.PessoasBD;
import com.pedrolgsoares.aplicativoparacrud.R;
import com.pedrolgsoares.aplicativoparacrud.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Instanciando os atributos da Main Activity
    private ListView listView_pessoas;
    private Pessoa pessoa;
    private PessoasBD pessoasBD;
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
        registerForContextMenu(listView_pessoas);

        // Aplicando clique longo no item para abrir a janela de delete
        listView_pessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                pessoa = (Pessoa)adapterView.getItemAtPosition(position);
                return false;
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

    // Aprecerá este menu após o clique longo
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar usuário");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                pessoasBD = new PessoasBD(getApplicationContext());
                pessoasBD.deletarDados(pessoa);
                pessoasBD.close();
                loadList();
                return true;
            }
        });
    }

    public void loadList(){
        pessoasBD = new PessoasBD(getApplicationContext());
        listPessoa = pessoasBD.getListDados();
        pessoasBD.close();

        // Iniciando a condição de mostrar layout dos itens
        if(listPessoa != null){
            adapter = new ArrayAdapter<Pessoa>(getApplicationContext(), android.R.layout.simple_list_item_1, listPessoa);
            listView_pessoas.setAdapter(adapter);
        }

    }
}
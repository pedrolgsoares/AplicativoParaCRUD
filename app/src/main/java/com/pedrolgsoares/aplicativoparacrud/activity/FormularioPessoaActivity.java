package com.pedrolgsoares.aplicativoparacrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pedrolgsoares.aplicativoparacrud.DAO.PessoaDAO;
import com.pedrolgsoares.aplicativoparacrud.R;
import com.pedrolgsoares.aplicativoparacrud.model.Pessoa;

public class FormularioPessoaActivity extends AppCompatActivity {
    // Instanciando os atributos do formulário
    private EditText editText_nome, editText_contato, editText_email;
    private Button button_salvar;

    // Instanciando o objeto Pessoa para condições de novos cadastros
    private Pessoa edit_pessoa, pessoa;

    // Instanciando o banco de dados
    private PessoaDAO pessoaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pessoa);

        // Iniciando a classe do banco e o objeto
        pessoa = new Pessoa();
        pessoaDAO = new PessoaDAO(getApplicationContext());

        editText_nome = findViewById(R.id.editText_nome);
        editText_contato = findViewById(R.id.editText_contato);
        editText_email = findViewById(R.id.editText_email);
        button_salvar = findViewById(R.id.button_salvar);

        // Recuperar os dados do objeto
        Intent dados = getIntent();

        Pessoa edit_pessoa = (Pessoa) dados.getSerializableExtra("objetoPessoa");

        if(edit_pessoa !=null){
            button_salvar.setText("Modificar dados");

            editText_nome.setText(edit_pessoa.getNomePessoa());
            editText_contato.setText(String.valueOf(edit_pessoa.getContatoPessoa()));
            editText_email.setText(edit_pessoa.getEmailPessoa());

            pessoa.setId(edit_pessoa.getId());
        } else{
            button_salvar.setText("Cadastrar pesssoa");
        }

        // Método para cadastrar pessoa
        button_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setNomePessoa(editText_nome.getText().toString());
                pessoa.setContatoPessoa(Integer.parseInt(editText_contato.getText().toString()));
                pessoa.setEmailPessoa(editText_email.getText().toString());

                if(button_salvar.getText().toString().equals("Cadastrar pesssoa")){
                    pessoaDAO.salvarDados(pessoa);
                    pessoaDAO.close();
                }else{
                    pessoaDAO.alterarDados(pessoa);
                    pessoaDAO.close();
                }
            }
        });
    }
}
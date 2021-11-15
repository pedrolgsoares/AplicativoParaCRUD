package com.pedrolgsoares.aplicativoparacrud.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pedrolgsoares.aplicativoparacrud.model.Pessoa;

import java.util.ArrayList;

public class PessoaDAO extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PessoaDAO.db";
    
    // Criando a tabela
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE pessoas(id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, " +
                    "nomepessoa TEXT NOT NULL, contatopessoa TEXT NOT NULL, emailpessoa TEXT NOT NULL)";

    // Excluindo a tabela
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS pessoas";

    public PessoaDAO(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }

    // Salvando as informações no banco de dados
    public void salvarDados(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("nomepessoa", pessoa.getNomePessoa());
        values.put("contatopessoa", pessoa.getEmailPessoa());
        values.put("emailpessoa", pessoa.getEmailPessoa());

        // Aplicando os valores com o insert na tabela pessoas
        getWritableDatabase().insert("pessoas", null, values);

    }
    
    // Listando os dados da tabela para serem exibidas
    public ArrayList<Pessoa> getListDados(){
        String[] columns = {"id", "nomepessoa", "contatopessoa", "emailpessoa"};
        Cursor cursor = getWritableDatabase().query("pessoas", columns,null,null,null,null,null);

        // mostrar os dados armzenados
        ArrayList<Pessoa> pessoa = new ArrayList<>();
        while (cursor.moveToNext()){
            Pessoa p = new Pessoa();
            p.setId(cursor.getLong(0));
            p.setNomePessoa(cursor.getString(1));
            p.setContatoPessoa(cursor.getInt(2));
            p.setEmailPessoa(cursor.getString(3));

            pessoa.add(p);
        }
        cursor.close();
        return pessoa;
    }
}

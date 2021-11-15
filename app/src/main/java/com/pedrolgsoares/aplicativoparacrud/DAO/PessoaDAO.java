package com.pedrolgsoares.aplicativoparacrud.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}

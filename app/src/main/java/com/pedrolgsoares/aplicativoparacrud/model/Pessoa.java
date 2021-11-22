package com.pedrolgsoares.aplicativoparacrud.model;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private Long id;
    private String nomePessoa;
    private int contatoPessoa;
    private String emailPessoa;


    public Pessoa(Long id, String nomePessoa, int contatoPessoa, String emailPessoa) {
        this.id = id;
        this.nomePessoa = nomePessoa;
        this.contatoPessoa = contatoPessoa;
        this.emailPessoa = emailPessoa;
    }

    public Pessoa(){

    }

    @Override
    public String toString() {
        return nomePessoa.toString();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getContatoPessoa() {
        return contatoPessoa;
    }

    public void setContatoPessoa(int contatoPessoa) {
        this.contatoPessoa = contatoPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

}

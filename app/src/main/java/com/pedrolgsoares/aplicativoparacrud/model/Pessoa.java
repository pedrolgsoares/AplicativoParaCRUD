package com.pedrolgsoares.aplicativoparacrud.model;

public class Pessoa {

    private String nomePessoa;
    private int contatoPessoa;
    private String emailPessoa;


    public Pessoa(String nomePessoa, int contatoPessoa, String emailPessoa) {
        this.nomePessoa = nomePessoa;
        this.contatoPessoa = contatoPessoa;
        this.emailPessoa = emailPessoa;
    }

    public Pessoa(){

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

    @Override
    public String toString() {
        return "Pessoa{" +
                "nomePessoa='" + nomePessoa + '\'' +
                ", contatoPessoa=" + contatoPessoa +
                ", emailPessoa='" + emailPessoa + '\'' +
                '}';
    }
}

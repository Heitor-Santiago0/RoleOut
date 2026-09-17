package br.com.roleout.model;

import java.time.LocalDate;

public class Role {

    private int id;
    private String nome;
    private String descricao;
    private String local;
    private String cidade;
    private LocalDate data;
    private String categoria;
    private double valor;

    public Role() {
    }

    public Role(int id, String nome, String descricao, String local,
                String cidade, LocalDate data, String categoria, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.cidade = cidade;
        this.data = data;
        this.categoria = categoria;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getDataFormatada() {
    if (data == null) {
        return "Data não informada";
    }

    return data.format(
        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
    );
}
}
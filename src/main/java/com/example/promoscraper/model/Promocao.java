package com.example.promoscraper.model;

public class Promocao {
    private String titulo;
    private String preco;
    private String url;
    private String loja;

    public Promocao(String titulo, String preco, String url, String loja) {
        this.titulo = titulo;
        this.preco = preco;
        this.url = url;
        this.loja = loja;
    }

    public String getTitulo() { return titulo; }
    public String getPreco() { return preco; }
    public String getUrl() { return url; }
    public String getLoja() { return loja; }
}
package com.example.promoscraper.service;

import com.example.promoscraper.model.Promocao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmazonScraperService {

    private static final String URL = "https://www.amazon.com.br/gp/goldbox";
    private static final String USER_AGENT = "Mozilla/5.0";

    public List<Promocao> coletarPromocoes() throws IOException {
        List<Promocao> promocoes = new ArrayList<>();

        Document doc = Jsoup.connect(URL)
                .userAgent(USER_AGENT)
                .get();



        doc.select("span.a-offscreen").forEach(element -> {
            System.out.println(element.text());
        });

        doc.select("span.a-truncate-full.a-offscreen").forEach(element -> {
            System.out.println(element.text());
        });

        Elements ofertas = doc.select(".DealContent"); // Altere conforme necessário

        for (Element oferta : ofertas) {
            String titulo = oferta.select(".DealTitle").text();
            String preco = oferta.select(".PriceString").text();
            String link = oferta.select("a").attr("href");

            if (!titulo.isEmpty() && !preco.isEmpty()) {
                promocoes.add(new Promocao(titulo, preco, "https://www.amazon.com.br" + link, "Amazon"));
            }
        }

        return promocoes;
    }
}
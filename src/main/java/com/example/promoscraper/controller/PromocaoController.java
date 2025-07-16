package com.example.promoscraper.controller;

import com.example.promoscraper.model.Promocao;
import com.example.promoscraper.service.AmazonScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {

    @Autowired
    private AmazonScraperService amazonService;

    @GetMapping("/amazon")
    public List<Promocao> buscarAmazon() throws IOException {
        return amazonService.coletarPromocoes();
    }
}
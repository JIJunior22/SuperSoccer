package com.nintendo.SuperSoccer.Model;

import com.nintendo.SuperSoccer.Interfaces.AplicarCartao;
import com.nintendo.SuperSoccer.Interfaces.CumprirSuspencao;
import com.nintendo.SuperSoccer.Interfaces.SofrerLesao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jogador implements AplicarCartao, CumprirSuspencao, SofrerLesao {
    //Atributos
    protected int id;
    protected String nome;
    protected String nascimento;
    protected int numero;
    protected String posicao;
    protected int qualidade;
    protected int cartaoAmarelo = 0;
    protected boolean cartaoVermelho = false;
    protected boolean suspenso;

    //Construtor vazio

    public Jogador() {
    }

    //Construtor parametrizado

    public Jogador(int id, String nome, String nascimento,
                   int numero, String posicao, int qualidade,
                   int cartaoAmarelo, boolean cartaoVermelho, boolean suspenso) {

        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.suspenso = suspenso;
    }


    //Metodos Especiais

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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) throws ParseException {
        // Criar um formato para a data
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        // Informar a data de nascimento como uma string e, em seguida, fazer o parsing
        String dataNascimentoString = nascimento;
        Date dataNascimento = formato.parse(dataNascimentoString);
        return;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public int getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public void setCartaoAmarelo(int cartaoAmarelo) {
        this.cartaoAmarelo = cartaoAmarelo;
    }

    public boolean getCartaoVermelho() {
        return cartaoVermelho;
    }

    public boolean setCartaoVermelho(boolean cartaoVermelho) {
        this.cartaoVermelho = cartaoVermelho;
        return this.cartaoVermelho;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }


    //Metodos
    public void podeJogar() {
        if (this.cartaoAmarelo >= 3 || this.cartaoVermelho) {

            System.out.printf("%s NÃO pode participar da partida! Está suspenso.%n", this.nome.toUpperCase());
            System.out.println("Total de cartões amarelos: " + this.cartaoAmarelo);
            if (cartaoVermelho) {
                System.out.println("Total de cartões vermelhos: 1");
            } else {
                System.out.println("Total de cartões vermelhos: 0");

            }


        } else if (this.suspenso) {
            System.out.println("Suspenso por decisão Judicial");

        } else {
            System.out.printf("%s PODE participar da partida!%n", this.nome.toUpperCase());
            System.out.println("Total de cartões amarelos: " + this.cartaoAmarelo);
            System.out.println("Cartão vermelho: Não");
        }

    }


    public void jogador() {
        System.out.println("= DADOS DO JOGADOR =");
        System.out.println("Cód.: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.nascimento);
        System.out.println("Número da Camisa: #" + this.numero);
        System.out.println("Posição: " + this.posicao);
        System.out.println("Qualidade: " + this.qualidade);
        System.out.println("Número de cartões amarelos: " + this.cartaoAmarelo);
        if (!this.cartaoVermelho) {
            setSuspenso(true);
            System.out.println("Cartão vermelho: 0");
        } else {
            System.out.println("Cartão vermelho: 1");
        }

        if (this.cartaoAmarelo >= 3 || this.cartaoVermelho) {
            System.out.println("Suspenso da próxima partida!!");

        } else {
            System.out.println("Apto a participar!");
        }


        System.out.println("-".repeat(20));

    }

    public boolean verificarCondicaoJogo() {

        return false;
    }

    //Metodos das interfaces
    @Override
    public void aplicarCartaoAmarelo() {
        this.cartaoAmarelo++;
    }

    @Override
    public boolean aplicarCartaoVermelho() {
        this.cartaoVermelho = true;
        return false;
    }

    @Override
    public void cumprirSuspencao() {
        System.out.println("= DECISÃO JUDICIAL ==");
        System.out.println("Devido a uma decisão judicial");
        System.out.printf("O jogador %s está suspenso da próxima partida!%n", this.nome.toUpperCase());
        this.suspenso = true;

    }

    @Override
    public void sofrerLesao() {

    }
}

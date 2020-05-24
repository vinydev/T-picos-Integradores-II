/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.model;

import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class Pessoa {
    protected String nome;
    protected String eMail;
    protected ArrayList<Telefone> telefones;
    protected Endereco endereco;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * @return the telefones
     */
    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}

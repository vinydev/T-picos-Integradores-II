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
public class Funcionario {
    private int matricula;
    private String rg;
    private String cpf;
    private String senha;
    private ArrayList<PedidoProduto> pedidosAutorizados;

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the pedidosAutorizados
     */
    public ArrayList<PedidoProduto> getPedidosAutorizados() {
        return pedidosAutorizados;
    }

    /**
     * @param pedidosAutorizados the pedidosAutorizados to set
     */
    public void setPedidosAutorizados(ArrayList<PedidoProduto> pedidosAutorizados) {
        this.pedidosAutorizados = pedidosAutorizados;
    }
}

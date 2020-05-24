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
public class Fornecedor {
    private int codigoFornecedor;
    private ArrayList<Produto> produtos;

    /**
     * @return the codigoFornecedor
     */
    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    /**
     * @param codigoFornecedor the codigoFornecedor to set
     */
    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    /**
     * @return the produtos
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}

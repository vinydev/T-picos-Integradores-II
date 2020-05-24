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
public class Cliente extends Pessoa{
    protected int codigoCliente;
    protected ArrayList<Pedido> pedidos;

    /**
     * @return the codigoCliente
     */
    public int getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * @param codigoCliente the codigoCliente to set
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * @return the pedidos
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

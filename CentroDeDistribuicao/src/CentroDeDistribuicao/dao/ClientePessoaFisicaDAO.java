/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.dao;

import CentroDeDistribuicao.model.ClientePessoaFisica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class ClientePessoaFisicaDAO {
    private ConexaoBanco conexao;
    private static final String PESSOA_FISICA = "PF";
    
    public ClientePessoaFisicaDAO()
    {
        this.conexao = new ConexaoBanco();
    }
    
    public void inserir(ClientePessoaFisica cpf) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO tb_cliente (nome_cliente, email, cep, logradouro, numero, bairro, cidade, uf, cpf_cpnj, rg, tipo_cliente) VALUES ('"+cpf.getNome()+"', '"
                + cpf.geteMail() +"', '"+ cpf.getCep() +"','"+ cpf.getLogradouro() +"', '"+cpf.getNumero()+"', '"+cpf.getBairro()+"', '"+cpf.getCidade()+"',"
                + "'"+cpf.getUf()+"', '"+cpf.getCpf()+"', '"+cpf.getRg()+"', 'PF');";
        
        try
        {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if(this.conexao.conectar())
            {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
/*
    public void alterar(ClientePessoaFisica cpf) {
        String sql = "UPDATE ESCOLA SET NOME = ?, RUA = ?, NUMERO = ?, CEP = ?, BAIRRO = ?, TELEFONE = ?, DIRETOR = ? WHERE IDESCOLA = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,escola.getNome());
                sentenca.setString(2,escola.getRua());
                sentenca.setInt(3,escola.getNumero());
                sentenca.setString(4,escola.getCEP());
                sentenca.setString(5,escola.getBairro());
                sentenca.setString(6,escola.getTelefone());
                sentenca.setString(7,escola.getDiretor());
                sentenca.setInt(8,escola.getIdEscola());
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM ESCOLA";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
   
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public void excluirID(int id) {
        String sql = "DELETE FROM ESCOLA WHERE IDESCOLA = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    public ArrayList<Escola> consultar() {
        
        ArrayList<Escola> listaEscolas = new ArrayList<Escola>();
        String sql = "SELECT * FROM ESCOLA ORDER BY IDESCOLA";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Escola escola = new Escola();
                    escola.setIdEscola(resultadoSentenca.getInt("IDESCOLA"));
                    escola.setNome(resultadoSentenca.getString("NOME"));
                    escola.setRua(resultadoSentenca.getString("RUA"));
                    escola.setNumero(resultadoSentenca.getInt("NUMERO"));
                    escola.setCEP(resultadoSentenca.getString("CEP"));
                    escola.setBairro(resultadoSentenca.getString("BAIRRO"));
                    escola.setTelefone(resultadoSentenca.getString("TELEFONE"));
                    escola.setDiretor(resultadoSentenca.getString("DIRETOR"));
                   
                    //adiciona cada tupla na listaEscolas que será retornada para a janela Escola
                    listaEscolas.add(escola);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaEscolas;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

*/
}

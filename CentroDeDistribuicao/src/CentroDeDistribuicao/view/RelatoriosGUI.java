/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Vinicius
 */
public class RelatoriosGUI extends JFrame{
     ArrayList <JPanel> panel = new ArrayList<JPanel>();
     ArrayList <JButton> button = new ArrayList<JButton>();
    JButton b1;
    int num=4;
    
    public RelatoriosGUI() throws HeadlessException {
        super("Relatorios");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 100, 1000, 700);
        this.setLocationRelativeTo(null);
        iniciarPaineis();
        iniciarBotoes();
        iniciarTabelas();
        this.setVisible(true);
    }

    private void iniciarPaineis() {
        JPanel pagina = new JPanel();
        this.getContentPane().add(pagina);
        pagina.setBackground(Color.white);
        pagina.setPreferredSize(new Dimension(1000, 800));
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(1000, 800));
        for (int i = 0; i<this.num;i++){
            this.panel.add(new JPanel());
            pagina.add(this.panel.get(i));
            if (i == 0 || i % 2 == 0){
                this.panel.get(i).setBackground(Color.yellow);
            }else{
                this.panel.get(i).setBackground(Color.white);
            }
        }
        scroll.setViewportView(pagina);
        this.getContentPane().add(scroll);
        pagina.setLayout(new BoxLayout(pagina, BoxLayout.Y_AXIS));
    }

    private void iniciarBotoes() {
        ButtonHandler buttonHandler=new ButtonHandler();
        this.button.add(new JButton("Listar Produto/Quantidade em Estoque/Fornecedor"));
        this.button.add(new JButton("Listar Pedidos em Janeiro de 2020"));
        this.button.add(new JButton("Informar Autorizações por Funcionário"));
        this.button.add(new JButton("Listar Funcionarios"));
        this.button.add(new JButton("Quantidade de Produto por fornecedor"));
        //this.b1 = new JButton("Listar Produto/Quantidade em Estoque/Fornecedor");
        this.panel.get(0).add(this.button.get(0));
        this.panel.get(0).add(this.button.get(1));
        this.panel.get(1).add(this.button.get(2));
        this.panel.get(1).add(this.button.get(3));
        this.panel.get(2).add(this.button.get(4));
        
        for (int i = 0; i<5;i++){
        this.button.get(i).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        this.button.get(i).setBackground(Color.white);
        this.button.get(i).addActionListener(buttonHandler);
        }
    }

    private void iniciarTabelas() {
        String [] colunas = {"Nome", "Descrição", "Quantidade"};
        Object [][] dados = {
        {"Bacia", "Tal marca", "2"},
        {"Martelo", "Outra marca", "11"},
        {"caixa", "Brasil", "12"}
        };
        	
        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        this.panel.get(3).add(barraRolagem);
        tabela.setPreferredSize(new Dimension(600,600));
        barraRolagem.setPreferredSize(new Dimension(600,600));
        
    }
    
    class ButtonHandler implements ActionListener{
    
    public void actionPerformed(ActionEvent ae){

    if (ae.getSource() == b1){
        
    }
  }
}
}

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
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Vinicius
 */
public class CadastrarProdutoGUI extends JFrame{
    
    ArrayList <JPanel> panel = new ArrayList<JPanel>();
    ArrayList <JLabel> label = new ArrayList<JLabel>();
    JButton b1;
    int num=9;
    
    public CadastrarProdutoGUI() throws HeadlessException {
        super("Cadastrar Produto");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 100, 1000, 700);
        this.setLocationRelativeTo(null);
        iniciarPaineis();
        iniciarLabels();
        iniciarBotoes();
        iniciarCampoTexto();
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

    private void iniciarLabels() {
        this.label.add(new JLabel("Nome:"));
        this.label.add(new JLabel("Descrição:"));
        this.label.add(new JLabel("Quantidade:"));
        this.label.add(new JLabel("Data de Entrada:"));
        
        this.panel.get(0).add(this.label.get(0));
        this.panel.get(2).add(this.label.get(1));
        this.panel.get(4).add(this.label.get(2));
        this.panel.get(6).add(this.label.get(3));
        
        Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
        for (int i = 0; i<4;i++){
            this.label.get(i).setFont(f1);
        }
    }

    private void iniciarBotoes() {
        this.b1 = new JButton("Cadastrar Produto");
        this.panel.get(8).add(this.b1);
        this.b1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        b1.setBackground(Color.white);
    }

    private void iniciarCampoTexto() {
        JTextField txtNome = new JTextField();
        JTextArea txtDescricao = new JTextArea(300, 40);
        JTextField txtQuantidade = new JTextField();
        JTextField txtDataEntrada = new JTextField();
        
        txtNome.setColumns(60);
        txtQuantidade.setColumns(4);
        txtDataEntrada.setColumns(11);
        JScrollPane scrollPane = new JScrollPane (txtDescricao); 
        scrollPane.setVerticalScrollBarPolicy (
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize (new Dimension (300, 40));
        this.panel.get(1).add(txtNome);
        this.panel.get(3).add(scrollPane);
        this.panel.get(5).add(txtQuantidade);
        this.panel.get(7).add(txtDataEntrada);
    }
    
}

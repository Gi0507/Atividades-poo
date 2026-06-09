package com.biblioteca.Viw;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.biblioteca.Bean.Copia;
import com.biblioteca.Bean.Obra;
import com.biblioteca.DAO.CopiaDAO;
import com.biblioteca.DAO.ObraDAO;

public class TelaCopia extends JFrame {
    private JLabel label;
    private JButton voltar;
    private JButton cadastrar;
    private JButton buscar;
    private JButton atualizar;
    private JButton excluir;
    private JButton btnlimpar;

    public TelaCopia() {
        
        setTitle("Copias");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 
        
        label = new JLabel("ID:");
        label.setBounds(30, 20, 100, 30);
        add(label);
        JTextField Id = new JTextField();
        Id.setBounds(100, 20, 250, 30);
        add(Id);

        label = new JLabel("Título:");
        label.setBounds(30, 50, 100, 30);
        add(label);
        JTextField Titulo = new JTextField();
        Titulo.setBounds(100, 50, 250, 30);
        add(Titulo);

        label = new JLabel("Autor:");
        label.setBounds(30, 80, 100, 30);
        add(label);
        JTextField Autor = new JTextField();
        Autor.setBounds(100, 80, 250, 30);
        add(Autor);
        label = new JLabel("Ano:");
        label.setBounds(30, 110, 100, 30);
        add(label);
        JTextField Ano = new JTextField();
        Ano.setBounds(100, 110, 250, 30);
        add(Ano);
        label = new JLabel("Status:");
        label.setBounds(30, 140, 100, 30);
        add(label);
        JTextField Status = new JTextField();
        Status.setBounds(100, 140, 250, 30);
        add(Status);

        voltar = new JButton("Voltar");
        voltar.setBounds(200, 200, 150, 30);
        add(voltar);
        voltar.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        });
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(20, 150, 150, 30);
        add(cadastrar);
         cadastrar.addActionListener(e -> {
             Titulo.setText("");
             Autor.setText("");
             Ano.setText("");
             Status.setText("");
             try {
                 Obra obra = new ObraDAO().buscarPorId(Integer.parseInt(Id.getText()));
                 Copia copia = new Copia(obra, Status.getText().equalsIgnoreCase("disponível"), Titulo.getText(), Autor.getText(), Integer.parseInt(Ano.getText()));
                 CopiaDAO copiaDAO =new CopiaDAO(); 
                 copiaDAO.adicionar(copia);
             } catch (Exception ex) {
             }
         });
         btnlimpar = new JButton("Limpar");
         btnlimpar.setBounds(20, 200, 150, 30);
         add(btnlimpar);
         btnlimpar.addActionListener(e -> {
             Titulo.setText("");
             Autor.setText("");
             Ano.setText("");
             Status.setText("");

         });
         buscar = new JButton("Buscar");
         buscar.setBounds(200, 150, 150, 30);
         add(buscar);
         buscar.addActionListener(e -> {
            
             Titulo.setText("");
             Autor.setText("");
             Ano.setText("");
             Status.setText("");

             try {
                  Obra obra = new ObraDAO().buscarPorId(Integer.parseInt(Id.getText()));
                 Copia copia = new Copia(obra, Status.getText().equalsIgnoreCase("disponível"), Titulo.getText(), Autor.getText(), Integer.parseInt(Ano.getText()));
                 CopiaDAO copiaDAO =new CopiaDAO(); 
                 copiaDAO.buscarPorId(copia.getId());
             }catch(Exception ex){

             }
         });
         atualizar = new JButton("Atualizar");
         atualizar.setBounds(20, 250, 150, 30);
         add(atualizar);
         atualizar.addActionListener(e -> {
             Titulo.setText("");
             Autor.setText("");
             Ano.setText("");
             try{
                 Obra obra = new ObraDAO().buscarPorId(Integer.parseInt(Id.getText()));
                 Copia copia = new Copia(obra, Status.getText().equalsIgnoreCase("disponível"), Titulo.getText(), Autor.getText(), Integer.parseInt(Ano.getText()));
                 CopiaDAO copiaDAO =new CopiaDAO();
                 copiaDAO.update(copia);
             }catch(Exception ex){

             }
         });
         excluir = new JButton("Excluir");
         excluir.setBounds(200, 250, 150, 30);
         add(excluir);
         excluir.addActionListener(e -> {
            
             Titulo.setText("");
             Autor.setText("");
             Ano.setText("");
             try{
                Obra obra = new ObraDAO().buscarPorId(Integer.parseInt(Id.getText()));
                 Copia copia = new Copia(obra, Status.getText().equalsIgnoreCase("disponível"), Titulo.getText(), Autor.getText(), Integer.parseInt(Ano.getText()));
                 CopiaDAO copiaDAO =new CopiaDAO();
                 copiaDAO.exluir(copia.getId());
             }catch(Exception ex){}
         });
        getContentPane().setBackground(java.awt.Color.GRAY);
    }

}

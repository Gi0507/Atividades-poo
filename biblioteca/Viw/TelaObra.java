package com.biblioteca.Viw;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.biblioteca.Bean.Obra;
import com.biblioteca.DAO.ObraDAO;

public class TelaObra extends JFrame {

    private JLabel label;
    private JButton btnLimpar;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnAtualizar;   
    private JButton btnBuscar;
    private JButton btnVoltar;

    private ObraDAO obraDAO;


    public TelaObra() {
        setTitle("Obras");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(java.awt.Color.GRAY);
        
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

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(200, 160, 150, 30);
        btnLimpar.addActionListener(e -> {
            Titulo.setText("");
            Autor.setText("");
                Ano.setText("");
        });

        add(btnLimpar);
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 160, 150, 30);
        add(btnSalvar);
        btnSalvar.addActionListener(e -> {
            // Lógica para salvar a obra
            String titulo = Titulo.getText();
            String autor = Autor.getText();
            String ano = Ano.getText();
            try {
                Obra obra = new Obra(titulo, autor, Integer.parseInt(ano));
                obraDAO.adicionar(obra);
            } catch (NumberFormatException ex) {
                System.out.println("Ano inválido. Por favor, insira um número.");
            }
            
            // Aqui você pode adicionar a lógica para salvar os dados em um banco de dados ou arquivo
            System.out.println("Obra salva: " + titulo + " - " + autor + " (" + ano + ")");
        });
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(30, 210, 150, 30);
        add(btnExcluir);
        btnExcluir.addActionListener(e -> {
            int id = Integer.parseInt(Id.getText());
            obraDAO.delete(id); // Exemplo de exclusão, você pode implementar a lógica para excluir a obra correta
        });

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(200, 210, 150, 30);
        add(btnAtualizar);
        btnAtualizar.addActionListener(e -> {
            int id = Integer.parseInt(Id.getText());
            String titulo = Titulo.getText();
            String autor = Autor.getText();
            String ano = Ano.getText();
            try {
                Obra obra = new Obra(titulo, autor, Integer.parseInt(ano));
                obra.setId(id);
                obraDAO.update(obra);
            } catch (NumberFormatException ex) {
                System.out.println("Ano inválido. Por favor, insira um número.");
            }
        });
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(30, 260, 150, 30);
        add(btnBuscar);
        btnBuscar.addActionListener(e -> {
            int id = Integer.parseInt(Id.getText());
            Obra obra = obraDAO.buscarPorId(id);
            if (obra != null) {
                Titulo.setText(obra.getTitulo());
                Autor.setText(obra.getAutor());
                Ano.setText(String.valueOf(obra.getAno()));
            } else {
                System.out.println("Obra não encontrada.");
            }
        });
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(200, 260, 150, 30);
        add(btnVoltar);
        btnVoltar.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        });
        setVisible(true);
    }
}
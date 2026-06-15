package com.biblioteca.Viw;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.biblioteca.Bean.Obra;
import com.biblioteca.DAO.ObraDAO;

public class TelaObra extends JFrame{

    private JLabel label;
    private JButton btnLimpar;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnAtualizar;   
    private JButton btnBuscar;
    private JButton btnVoltar;
    private ObraDAO obraDAO;

    public TelaObra() {
        try {
            this.obraDAO = new ObraDAO();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco (Obras): " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

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
        btnLimpar.setBounds(30, 250, 150, 30);
        btnLimpar.addActionListener(e -> {
            Id.setText("");
            Titulo.setText("");
            Autor.setText("");
            Ano.setText("");
        });
        add(btnLimpar);

        btnSalvar = new JButton("Cadastrar");
        btnSalvar.setBounds(30, 160, 150, 30);
        add(btnSalvar);
        btnSalvar.addActionListener(e -> {
            String titulo = Titulo.getText();
            String autor = Autor.getText();
            String anoStr = Ano.getText();
            try {
                Obra obra = new Obra(titulo, autor, Integer.parseInt(anoStr));
                obraDAO.adicionar(obra);
                JOptionPane.showMessageDialog(this, "Obra salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ano inválido. Por favor, insira um número.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(30, 210, 150, 30);
        add(btnExcluir);
        btnExcluir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(Id.getText());
                obraDAO.delete(id);
                JOptionPane.showMessageDialog(this, "Obra excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                btnLimpar.doClick();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido para exclusão.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(200, 210, 150, 30);
        add(btnAtualizar);
        btnAtualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(Id.getText());
                String titulo = Titulo.getText();
                String autor = Autor.getText();
                String ano = Ano.getText();
                Obra obra = new Obra(titulo, autor, Integer.parseInt(ano));
                obra.setId(id);
                obraDAO.update(obra);
                JOptionPane.showMessageDialog(this, "Obra actualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos ID e Ano contêm números válidos.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 160, 150, 30);
        add(btnBuscar);
        btnBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(Id.getText());
                Obra obra = obraDAO.buscarPorId(id);
                if (obra != null) {
                    Titulo.setText(obra.getTitulo());
                    Autor.setText(obra.getAutor());
                    Ano.setText(String.valueOf(obra.getAno()));
                } else {
                    JOptionPane.showMessageDialog(this, "Obra não encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, digite um ID numérico para buscar.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(200, 250, 150, 30);
        add(btnVoltar);
        btnVoltar.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        });

        setVisible(true);
    }
}
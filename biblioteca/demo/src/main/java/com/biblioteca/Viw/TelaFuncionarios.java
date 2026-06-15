package  com.biblioteca.Viw;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.biblioteca.Bean.Funcionários;
import com.biblioteca.DAO.FuncionáriosDAO;

public class TelaFuncionarios extends JFrame {
    private JLabel label;

    private JFormattedTextField txtCPF;
    private JFormattedTextField txtTelefone;

    public TelaFuncionarios() {
        
        setTitle("Funcionários");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 
        
        label = new JLabel("Nome:");
        label.setBounds(30, 20, 100, 30);
        add(label);
        JTextField Nome = new JTextField();
        Nome.setBounds(100, 20, 250, 30);
        add(Nome);

        label = new JLabel("CPF:");
        label.setBounds(30, 50, 100, 30);
        add(label);
        try {
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        txtCPF.setBounds(100, 50, 250, 30);
        add(txtCPF);

        label = new JLabel("Cargo:");
        label.setBounds(30, 80, 100, 30);
        add(label);
        JTextField Cargo = new JTextField();
        Cargo.setBounds(100, 80, 250, 30);
        add(Cargo);

        label = new JLabel("Telefone:");
        label.setBounds(30, 110, 100, 30);
        add(label);
        try {
            txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        txtTelefone.setBounds(100, 110, 250, 30);
        add(txtTelefone);

        JButton btnAdicionar = new JButton("Cadastrar");
        btnAdicionar.setBounds(30, 150, 150, 30);
        add(btnAdicionar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 150, 150, 30);
        add(btnBuscar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(200, 200, 150, 30);
        add(btnExcluir);
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(30, 250, 150, 30);
        add(btnLimpar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(200, 250, 150, 30);
        add(btnVoltar);
        btnVoltar.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            dispose();
        });

        btnAdicionar.addActionListener(e -> {
            String nome = Nome.getText();
            String cpf = txtCPF.getText();
            String cargo = Cargo.getText();
            String telefone = txtTelefone.getText();
            try {
                Funcionários fu = new Funcionários(nome, cpf, telefone, cargo);
                FuncionáriosDAO DAO = new FuncionáriosDAO();
                DAO.adicionar(fu);
            } catch (SQLException e1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao adicionar funcionário: " + e1.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
           

        });
        btnBuscar.addActionListener(e -> {
           String cpf = txtCPF.getText();
            try {
                FuncionáriosDAO DAO = new FuncionáriosDAO();
                Funcionários fu = DAO.buscarPorId(cpf);
                if (fu != null) {
                    Nome.setText(fu.getNome());
                    Cargo.setText(fu.getCargo());
                    txtTelefone.setText(fu.getTelefone());
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Funcionário não encontrado.", "Info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar funcionário: " + e1.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });
        btnExcluir.addActionListener(e -> {
            String cpf = txtCPF.getText();
            try {
                FuncionáriosDAO DAO = new FuncionáriosDAO();
                DAO.excluir(cpf);
                Nome.setText("");
                Cargo.setText("");
                txtTelefone.setText("");
                javax.swing.JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso.", "Info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao excluir funcionário: " + e1.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        });
        btnLimpar.addActionListener(e -> {
            txtCPF.setText("");
            Nome.setText("");
            Cargo.setText("");
            txtTelefone.setText("");
        });
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(30, 200, 150, 30);
        add(btnAtualizar);
        btnAtualizar.addActionListener(e -> {
            String nome = Nome.getText();
            String cpf = txtCPF.getText();
            String cargo = Cargo.getText();
            String telefone = txtTelefone.getText();
            try {
                Funcionários fu = new Funcionários(nome, cpf, telefone, cargo);
                FuncionáriosDAO DAO = new FuncionáriosDAO();
                DAO.update(fu);
                javax.swing.JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso.", "Info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar funcionário: " + e1.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });
        getContentPane().setBackground(java.awt.Color.GRAY);
        setVisible(true);
    }
}
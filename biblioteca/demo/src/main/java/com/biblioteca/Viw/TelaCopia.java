package com.biblioteca.Viw;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.biblioteca.Bean.Copia;
import com.biblioteca.Bean.Obra;
import com.biblioteca.DAO.CopiaDAO;

public class TelaCopia extends JFrame {

    private JButton voltar,cadastrar,buscar,atualizar,excluir,btnLimpar;

    public TelaCopia() {

        setTitle("Cópias");
        setSize(400,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(java.awt.Color.GRAY);

        JLabel label;

        label=new JLabel("ID:");
        label.setBounds(30,20,100,30);
        add(label);

        JTextField Id=new JTextField();
        Id.setBounds(100,20,250,30);
        add(Id);

        label=new JLabel("Título:");
        label.setBounds(30,50,100,30);
        add(label);

        JTextField Titulo=new JTextField();
        Titulo.setBounds(100,50,250,30);
        add(Titulo);

        label=new JLabel("Autor:");
        label.setBounds(30,80,100,30);
        add(label);

        JTextField Autor=new JTextField();
        Autor.setBounds(100,80,250,30);
        add(Autor);

        label=new JLabel("Ano:");
        label.setBounds(30,110,100,30);
        add(label);

        JTextField Ano=new JTextField();
        Ano.setBounds(100,110,250,30);
        add(Ano);

        label=new JLabel("Disponível:");
        label.setBounds(30,140,100,30);
        add(label);

        JCheckBox Status=new JCheckBox();
        Status.setBounds(100,140,30,30);
        Status.setOpaque(false);
        add(Status);

        cadastrar=new JButton("Cadastrar");
        cadastrar.setBounds(20,180,150,30);
        add(cadastrar);

        cadastrar.addActionListener(e->{
            try{

                if(Titulo.getText().isEmpty()||
                   Autor.getText().isEmpty()||
                   Ano.getText().isEmpty()){

                    JOptionPane.showMessageDialog(this,"Preencha os campos.");

                    return;
                }

                Obra obra=new Obra(
                    Titulo.getText(),
                    Autor.getText(),
                    Integer.parseInt(Ano.getText())
                );

                Copia copia=new Copia(
                    Status.isSelected(),
                    Titulo.getText(),
                    Autor.getText(),
                    Integer.parseInt(Ano.getText())
                );

                CopiaDAO dao=new CopiaDAO();

                dao.adicionar(copia);

                JOptionPane.showMessageDialog(this,"Cópia cadastrada.");

                btnLimpar.doClick();

            }catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        });

        buscar=new JButton("Buscar");
        buscar.setBounds(200,180,150,30);
        add(buscar);

        buscar.addActionListener(e->{
            try{

                CopiaDAO dao=new CopiaDAO();

                Copia copia=
                dao.buscarPorId(Integer.parseInt(Id.getText()));

                if(copia!=null){

                    Titulo.setText(copia.getTitulo());

                    Autor.setText(copia.getAutor());

                    Ano.setText(String.valueOf(copia.getAno()));

                    Status.setSelected(copia.isDisponivel());

                }else{
                    JOptionPane.showMessageDialog(this,"Cópia não encontrada");
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Erro ao buscar");
            }
        });

        atualizar=new JButton("Atualizar");
        atualizar.setBounds(20,260,150,30);
        add(atualizar);

        atualizar.addActionListener(e->{
            try{

                Copia copia=new Copia(
                    Status.isSelected(),
                    Titulo.getText(),
                    Autor.getText(),
                    Integer.parseInt(Ano.getText())
                );

                copia.setId(Integer.parseInt(Id.getText()));
                CopiaDAO dao=new CopiaDAO();
                dao.update(copia);
                JOptionPane.showMessageDialog(this,"Atualizado");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Erro ao atualizar");
            }
        });

        excluir=new JButton("Excluir");
        excluir.setBounds(200,220,150,30);
        add(excluir);

        excluir.addActionListener(e->{
            try{

                CopiaDAO dao=new CopiaDAO();

                dao.excluir(
                    Integer.parseInt(
                        Id.getText()
                    )
                );

                btnLimpar.doClick();

                JOptionPane.showMessageDialog(
                    this,
                    "Excluído"
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir"
                );
            }
        });

        btnLimpar=new JButton("Limpar");
        btnLimpar.setBounds(20,220,150,30);
        add(btnLimpar);

        btnLimpar.addActionListener(e->{
            Id.setText("");
            Titulo.setText("");
            Autor.setText("");
            Ano.setText("");
            Status.setSelected(false);
        });

        voltar=new JButton("Voltar");
        voltar.setBounds(200,260,150,30);
        add(voltar);

        voltar.addActionListener(e->{
            new TelaPrincipal().setVisible(true);
            dispose();
        });

        setVisible(true);
    }
}
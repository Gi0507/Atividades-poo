package com.clinica.Bean;



public class Recepcionista extends Funcionario{
        private String cpf;
        

        public String getCpf() {
            return cpf;
        }
        public void setCpf(String cpf) {
            this.cpf = cpf;
        }
       

        Recepcionista(String cpf,String telefone,String senha,String nome){
            this.setCpf(cpf);
            this.setTelefone(telefone);
            this.setSenha(senha);
            this.setNome(nome);
}

        public Recepcionista(){
            this.setCpf(" ");
            this.setTelefone(" ");
            this.setSenha(" ");
            this.setNome(" ");
        }

    }
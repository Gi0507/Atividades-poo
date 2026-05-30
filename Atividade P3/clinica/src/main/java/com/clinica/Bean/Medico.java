package com.clinica.Bean;
public class Medico extends Funcionario{
        private String crm;
        private String especialidade;

        public String getCrm() {
            return crm;
        }
        public void setCrm(String crm) {
            this.crm = crm;
        }
        public String getEspecialidade() {
            return especialidade;
        }
        public void setEspecialidade(String especialidade) {
            this.especialidade = especialidade;
        }

        public Medico(String crm,String cpf,String telefone,String nome,String senha,String especialidade){
            this.setCrm(crm);
            this.setCpf(cpf);
            this.setTelefone(telefone);
            this.setNome(nome);
            this.setSenha(senha);
            this.setEspecialidade(especialidade);
        }
        public Medico(){
            this.setCrm(" ");
            this.setCpf(" ");
            this.setTelefone(" ");
            this.setNome(" ");
            this.setSenha(" ");
            this.setEspecialidade(" ");

        }

        void mostrar(){ 
            System.out.println("---Medico---");
            System.out.println("Nome:"+getNome()+"\nCRM:"+getCrm()+"\nCPF:"+getCpf()+"\nTelefone:"+getTelefone()+"\nEspecialidade:"+getEspecialidade()+"\n\n");
        }
        public String getCpf() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getCpf'");
        }

    public void setCpf(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
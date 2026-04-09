public class funcionario {
    String nome;
    String telefone;
    String senha;
    
    
    public String getNome() {
        
        return nome;
    }


    public void setNome(String nome) {
        if(nome == null || nome.isBlank()){
            throw new Exception("Ocorreu um erro. O nome é obrigatório!");
        }else this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public mostrar(){
        var s= "\nNome= "+getNome()+"\ntelefone= "+getTelefone();
        System.out.println(s);
    }
    public void acesar();
}

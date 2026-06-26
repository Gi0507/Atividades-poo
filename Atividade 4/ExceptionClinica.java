package com.fatec.ads;

public class ExceptionClinica extends  Exception {
    private String codigo;
    private String mensagem;

    public ExceptionClinica(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

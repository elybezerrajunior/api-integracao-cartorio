package Enum;

public enum StatusParcela {
    
    CANCELADA(1,"Cancelada"),
    EMITIDO_REGISTRO(2,"Emitido Registro"),
    PROTOCOLADA(3,"Protocolada");
    
    private Integer valor;
    private String nome;

    private StatusParcela(Integer valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public static StatusParcela valueString(String valor) {
        for (StatusParcela o : values()) {
            if (o.getNome().equals(valor)) {
                return o;
            }
        }
        return null;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}


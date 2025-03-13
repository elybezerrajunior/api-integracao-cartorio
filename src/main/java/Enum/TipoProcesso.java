package Enum;

public enum TipoProcesso {
    INDIVIDUAL("Individual", 1),
    COLETIVO("Coletivo", 2);

    private String nome;
    private int numero;

    private TipoProcesso(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
    
    public static TipoProcesso valueString(String valor) {
        for (TipoProcesso o : values()) {
            if (o.getNome().equals(valor)) {
                return o;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}

package Enum;


public enum SituacaoRemessa {

    GERADO("Gerado", "#5EBA7D","G"),
    IMPORTADO("Importado", "#7b79d7","I"),
    PROTOCOLADO("Protocolado", "#b9e1e7","P"),
    REGISTRADO("Registrado", "#00a1ff","R"),
    CANCELADO("Cancelado", "#ff3e1d","C"),
    ENVIADO("Enviado", "#3C8DBC","E");
    
    private String nome;
    private String cor;
    private String sigla;

    private SituacaoRemessa(String nome, String cor, String sigla) {
        this.nome = nome;
        this.cor = cor;
        this.sigla = sigla;
    }

    public static SituacaoRemessa valueString(String valor) {
        for (SituacaoRemessa o : values()) {
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    

    @Override
    public String toString() {
        return this.nome;
    }
}
package Enum;

import lombok.Getter;

@Getter
public enum StatusImovel {
    
    ANALISE(1, "Análise", "AN","#e3f2fd","#2196F3"),
    ARQUIVADO(2, "Arquivado", "AR","#ffc93b","#f2a654"),
    INDEFERIDO(3, "Indeferido", "IN","#ffc93b","#f2a654"),
    PENDENTE(4, "Pendente", "PE","#ffcbdb","#ff0854"),
    PEDIDO_MATRICULA(5, "Pedido Matricula", "PM","#e3f2fd","#2196F3"),
    REGISTRADO(6, "Registrado", "RE","#b9ddca","#4caf4f");
    

    private Integer valor;
    private String nome;
    private String label;
    private String cor;
    private String corBorda;

    private StatusImovel(Integer valor, String nome, String label, String cor, String corBorda) {
        this.valor = valor;
        this.nome = nome;
        this.label = label;
        this.cor   = cor;
        this.corBorda = corBorda;
    }
    
    public static StatusImovel valueString(String valor){
        for(StatusImovel o : values()){
            if(o.getNome().equals(valor)){
                return o;
            }
        }
        return null;
    }
    
     
    @Override
    public String toString() {
        return this.nome;
    }
    
}

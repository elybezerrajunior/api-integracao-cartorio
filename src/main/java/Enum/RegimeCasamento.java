package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum RegimeCasamento {

    SEPARACAO_DE_BENS(1, "Separação de Bens", "SEPARACAO_BENS"),
    SEPARACAO_PARCIAL_BENS(8, "Separação Parcial de Bens", "SEPARACAO_BENS"),
    SEPARACAO_TOTAL_DE_BENS(2, "Separação Total de Bens", "SEPARACAO_LEGAL_BENS"),
    COMUNHÃO_PARCIAL_DE_BENS(3, "Comunhão Parcial de Bens", "COMUNHAO_PARCIAL"),
    COMUNHÃO_BENS(4, "Comunhão de Bens", "COMUNHAO_UNIVERSAL"),
    SEPARACAO_DE_BENS_ATE_A_IDADE_LEGAL(4, "Separação de Bens até a Idade Legal", "SEPARACAO_LEGAL_BENS"),
    COMUNHAO_GERAL_DE_BENS(4, "Comunhão Geral de Bens", "COMUNHAO_UNIVERSAL"),
    COMUNHÃO_UNIVERSAL_DE_BENS(5, "Comunhão Universal de Bens", "COMUNHAO_UNIVERSAL"),
    PARTICIPAÇÃO_FINAL_DE_BENS_NOS_AQUESTOS(6, "Participação Final de Bens nos Aquestos", "COMUNHAO_PARCIAL"),
    SEPARACAO_OBRIGATORIA_DE_BENS(1, "Separação Obrigatória de Bens", "SEPARACAO_LEGAL_BENS"),
    IGNORADO(7, "Ignorado", "IGNORADO");
    private Integer valor;
    private String nome;
    private String nomeCRC;
    
     public static RegimeCasamento valueString(String valor){
        for(RegimeCasamento o : values()){
            if(o.getNome().toLowerCase().equals(valor.toLowerCase())){
                return o;
            }
        }
        return null;
    }
  
}


package Enum;

import lombok.Getter;

@Getter
public enum TipoRemessa {
    AVERBACAO_MIGRACAO("Averbação de Migração"),
    TRANSFERENCIA_MIGRACAO("Transferência de Migração"),
    LOTE("Lote"),
    NUCLEO("Núcleo");

    private String nome;

    private TipoRemessa(String nome) {
        this.nome = nome;
    }

    public static TipoRemessa fromNome(String nome) {
        if (nome == null) {
            return null;
        }
        for (TipoRemessa tipo : TipoRemessa.values()) {
            if (tipo.name().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        return null;
    }

}

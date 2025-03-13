package Enum;

public enum TipoLogradouro {

    RUA(1, "Rua"),
    AVENIDA(2, "Avenida"),
    CONDOMINIO(3, "Condomínio"),
    POVOADO(4, "Povoado"),
    RODOVIA(5, "Rodovia"),
    ESTRADA(6, "Estrada"),
    APARTAMENTO(7, "Apartamento"),
    PRACA(8, "Praça"),
    VILA(9, "Vila"),
    PARQUE(10, "Parque"),
    FAZENDA(11, "Fazenda"),
    AEROPORTO(12, "Aeroporto"),
    VIADUTO(13, "Viaduto"),
    ALAMEDA(14, "Alameda"),
    BLOCO(15, "Bloco"),
    BECO(16, "Beco"),
    CAMINHO(17, "Caminho"),
    ESCADINHA(18, "Escadinha"),
    ESTACAO(19, "Estação"),
    FORTALEZA(20, "Fortaleza"),
    GALERIA(21, "Galeria"),
    LADEIRA(22, "Ladeira"),
    LARGO(23, "Largo"),
    PRAIA(24, "Praia"),
    QUADRA(25, "Quadra"),
    QUILÔMETRO(26, "Quilômetro"),
    QUINTA(27, "Quinta"),
    SUPER_QUADRA(28, "Super Quadra"),
    TRAVESSA(29, "Travessa"),
    BR(30, "BR"),
    VIA(100, "Via"),
    LOTEAMENTO(100, "Loteamento"),
    CONJUNTO(101, "Conjunto"),
    SITIO(999, "Sítio"),
    COMUNIDADE(9, "Comunidade"),
    DISTRITO(31, "Distrito"),
    ASSENTAMENTO(31, "Assentamento"),
    OUTROS(31, "Outros");

    private int numero;
    private String nome;

    private TipoLogradouro(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public static String valueString(String valor) {
        for (TipoLogradouro o : values()) {
            if (o.getNome().toLowerCase().equals(valor.toLowerCase())) {
                return o.getNome();
            }
        }
        return "";
    }

    public static TipoLogradouro valueStringTipo(String valor) {
        for (TipoLogradouro o : values()) {
            if (o.getNome().toLowerCase().equals(valor.toLowerCase())) {
                return o;
            }
        }
        return null;
    }

    public static TipoLogradouro valueStringImovel(String valor) {
        for (TipoLogradouro o : values()) {
            if (o.getNome().toUpperCase().equals(valor.toUpperCase())) {
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

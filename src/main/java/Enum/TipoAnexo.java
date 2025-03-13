package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum TipoAnexo {

    COPIA_DOS_DOCUMENTOS_PESSOAIS("Documentos Pessoais(RG,CPF)", TipoAnexoCategoria.PESSOA_FISICA),
    CASADO("Casado(a) Certidão de Casamento", TipoAnexoCategoria.PESSOA_FISICA),
    COPIA_DOS_DOCUMENTOS_PESSOAIS_CONJUGE("CPF, RG Cônjuge", TipoAnexoCategoria.PESSOA_FISICA),
    COPIA_DOS_DOCUMENTOS_PESSOAOS("Documentos Pessoais(RG,CPF)", TipoAnexoCategoria.PESSOA_FISICA),
    CERTIDAO_NASCIMENTO("Solteiro(a) Certidão de Nascimento", TipoAnexoCategoria.PESSOA_FISICA),
    DECLARACAO_UNIAO_ESTAVEL("Amasiado Declaração União Estável", TipoAnexoCategoria.PESSOA_FISICA),
    VIUVO("Viúvo(a) Certidão de casamento e Certidão de Óbito", TipoAnexoCategoria.PESSOA_FISICA),
    PARECER_JURIDICO("Parecer Jurídico", TipoAnexoCategoria.AMBOS),
    CERTIDAO_OBITO("Certidão de Óbito", TipoAnexoCategoria.PESSOA_FISICA),
    CADEIA_POSSESSORIA("Cadeia Possessoria (contratos)", TipoAnexoCategoria.AMBOS),
    COMPROVANTE_DE_RESIDÊNCIA("Comprovante de Residência", TipoAnexoCategoria.AMBOS),
    DECLARACAO_POSSE("Declaração de Posse", TipoAnexoCategoria.AMBOS),
    BCI("BCI - IPTU", TipoAnexoCategoria.AMBOS),
    FACHADA_CASA("Foto da Fachada", TipoAnexoCategoria.AMBOS),
    FOTOS_INTERNA_CASA("Fotos internas da casa", TipoAnexoCategoria.AMBOS),
    CARTEIRA_DE_TRABALHO("Carteira de Trabalho", TipoAnexoCategoria.AMBOS),
    TITULO_DE_ELEITOR("Titulo de Eleitor", TipoAnexoCategoria.AMBOS),
    CARTA_AFORAMENTO("Carta de Aforamento", TipoAnexoCategoria.AMBOS),
    CERTIDAO_DE_DIVORCIO("Certidão de divórcio", TipoAnexoCategoria.AMBOS),
    OUTROS("Outros", TipoAnexoCategoria.AMBOS),
    FOTOS_EXTERNA("Fotos Externa", TipoAnexoCategoria.AMBOS),
    FOTO_IPTU("Foto IPTU", TipoAnexoCategoria.AMBOS),
    LEVANTAMENTO_PLANIMETRICO("Levantamento Planimetrico", TipoAnexoCategoria.AMBOS),
    CERTIDAO_NEGATIVA_ACAO_REAL_REIPERCECUTORIA("Certidão Negativa de Ação Real ou Reipercecutória", TipoAnexoCategoria.AMBOS),
    CERTIDAO_DE_ONUS_REAIS("Certidão de Ônus Reais", TipoAnexoCategoria.AMBOS),
    COMPROVANTE_COMPRA_VENDA_CESSAO_DOACAO("Compra e venda, troca, cessão, doação", TipoAnexoCategoria.AMBOS),
    COMPROVANTE_BAIXA_RENDA("Comprovante de baixa renda", TipoAnexoCategoria.PESSOA_FISICA),
    COMPROVANTE_NIS("Inscrição do NIS", TipoAnexoCategoria.PESSOA_FISICA),
    COMPROVANTE_BOLSA_FAMILIA("Cartão bolsa família", TipoAnexoCategoria.PESSOA_FISICA),
    COMPROVANTE_BOLSA_ESCOLA("Cartão bolsa escola", TipoAnexoCategoria.PESSOA_FISICA),
    CERTIDAO_DA_JUNCEPI("Certidão da Juncepi", TipoAnexoCategoria.PESSOA_JURIDICA),
    CONTRATO_SOCIAL("Contrato Social com todos os aditivos", TipoAnexoCategoria.PESSOA_JURIDICA),
    CROQUI("Croqui", TipoAnexoCategoria.AMBOS),
    DECRETO("Decreto Reurb", TipoAnexoCategoria.AMBOS),
    DECLARACAO_ANUENCIA("Declaração Anuência", TipoAnexoCategoria.AMBOS),
    DECLARACAO_MUNICIPAL_DE_AREA_RISCO_OU_PRESERVACAO_PERMANENTE("Declaração Municipal de Área de Risco ou Preservação Permanente", TipoAnexoCategoria.AMBOS),
    MAPA("Mapa", TipoAnexoCategoria.AMBOS),
    CONTRATO("Primeiro Contrato de Compra e Venda", TipoAnexoCategoria.AMBOS),
    MAPA_Quadra("Mapa da Quadra", TipoAnexoCategoria.AMBOS),
    MEMORIAL_DESCRITIVO("Memorial Descritivo", TipoAnexoCategoria.AMBOS),
    RESPONSABILIDADE_TÉCNICA_ART("Responsabilidade Técnica ART", TipoAnexoCategoria.AMBOS),
    REQUERIMENTO("Requerimento", TipoAnexoCategoria.AMBOS),
    LOGO("Logo", TipoAnexoCategoria.AMBOS),
    ASSINATURA_CREDENCIADA("Assinatura da Credenciada", TipoAnexoCategoria.AMBOS),
    ASSINATURA_COLETADOR("Assinatura do Coletador", TipoAnexoCategoria.AMBOS),
    ASSINATURA_TESTEMUNHA("Assinatura da Testemunha", TipoAnexoCategoria.AMBOS),
    EDITAL_DE_NOTIFICACAO("Edital de Notificação - Publicação", TipoAnexoCategoria.AMBOS),
    NOTIFICACAO_CARTORIO("Notificação Publicação do Cartório", TipoAnexoCategoria.AMBOS),
    NOTIFICACAO_PREFEITURA("Notificação Publicação da Prefeitura", TipoAnexoCategoria.AMBOS),
    DECRETO_INSTAURACAO_REURB("Decreto de Instauração da REURB", TipoAnexoCategoria.AMBOS),
    LEI("Lei do Município", TipoAnexoCategoria.AMBOS),
    QUITACAO("Quitação", TipoAnexoCategoria.AMBOS),
    DECLARACAO("Declaração", TipoAnexoCategoria.AMBOS),
    DESPACHOADH("Despacho-ADH",TipoAnexoCategoria.AMBOS),
    SHAPE("Shape", TipoAnexoCategoria.AMBOS),
    INVENTARIO("Inventário", TipoAnexoCategoria.AMBOS),
    REGISTRO_IMOVEIS("Registro de Imóveis", TipoAnexoCategoria.AMBOS),
    PROTOCOLO("Protocolo", TipoAnexoCategoria.AMBOS),
    CESSAO_DIREITO("Cessão de Direito", TipoAnexoCategoria.AMBOS),
    SENTENCA("Sentença", TipoAnexoCategoria.AMBOS),
    CERTIDAO_DE_AVERBACAO("Certidão de Averbação", TipoAnexoCategoria.AMBOS),
    FOLHA_RESUMO("Folha Resumo", TipoAnexoCategoria.PESSOA_FISICA),
    ALVARA_CONSTRUCAO("Alvará de Construção", TipoAnexoCategoria.AMBOS),
    ASSINATURA_MORADOR("Assinatura do Morador(Foto com Documento)", TipoAnexoCategoria.AMBOS),
    ESCRITURA_INVENTARIO("Escritura de Inventário", TipoAnexoCategoria.AMBOS);

    private String nome;

    private TipoAnexoCategoria tipoDocumentoNucleoCategoria;

}


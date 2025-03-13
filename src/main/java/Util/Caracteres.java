package Util;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.MaskFormatter;

public class Caracteres {

    public static String cpfMask = "###.###.###-##";
    public static String cnpjMask = "##.###.###/####-##";
    public static String cepMask = "##.###-###";
    public static String phoneMask = "(##) #####-####";
    public static String inscricaoCadastralMask = "##.##.###.####.##";

    public static String removecaracter(String s) {
        if (s != null) {
            s = s.replaceAll("\\.", "")
                    .replace("-", "")
                    .replace("/", "")
                    .replace("-", "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("{", "")
                    .replace("}", "")
                    .replace("_", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace(" ", "");
        }
        return s;
    }

    /**
     * Remove caracteres não alphanuméricos, exceto o ponto (.)
     *
     * @param s
     * @return string com os caracteres removidos
     */
    public static String removeCaracterIgnoraPonto(String s) {
        if (s != null) {
            s = s.replace("-", "").replace("/", "").replace("[", "").replace("]", "").replace("{", "").replace("}", "");
        }
        return s;
    }

    public static String removerAcentos(String s) {
        if (s != null) {
            s = s.replaceAll("[ãâàáä]", "a")
                    .replaceAll("[êèéë]", "e")
                    .replaceAll("[îìíï]", "i")
                    .replaceAll("[õôòóö]", "o")
                    .replaceAll("[ûúùü]", "u")
                    .replaceAll("[ÃÂÀÁÄ]", "A")
                    .replaceAll("[ÊÈÉË]", "E")
                    .replaceAll("[ÎÌÍÏ]", "I")
                    .replaceAll("[ÕÔÒÓÖ]", "O")
                    .replaceAll("[ÛÙÚÜ]", "U")
                    .replace('ç', 'c')
                    .replace('Ç', 'C')
                    .replace("[ñǹń]", "n")
                    .replace("[ÑŃǸ]", "N");
        }

        return s;
    }

    public static String removeCaracterAnexo(String s) {
        if (s != null) {
            s = s.replace("¦", "").replace(":", "").replace("-", "").replaceAll("[ãâàáä]", "a").replaceAll("[êèéëẽ]", "e").replaceAll("[îìíïĩ]", "i").replaceAll("[õôòóö]", "o").replaceAll("[ûúùüũ]", "u").replaceAll("[ÃÂÀÁÄ]", "A").replaceAll("[ÊÈÉËẼ]", "E").replaceAll("[ÎÌÍÏĨ]", "I").replaceAll("[ÕÔÒÓÖ]", "O").replaceAll("[ÛÙÚÜŨ]", "U").replace('ç', 'c').replace('Ç', 'C').replace('ñ', 'n').replace('Ñ', 'N').replaceAll("!", "").replace("/", "").replace("-", "").replace("[", "").replace("]", "").replace("{", "").replace("}", "").replace("(", "").replace(")", "").replace("§", "").replace((char) 160, (char) 32);
        }
        return s;

    }

    /**
     * Remove caracteres especiais e substitui letras acentuadas
     *
     * @param text
     * @return
     */
    public static String removeCaracteresEspeciais(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("¦", "").replaceAll("-", "").replaceAll("[ãâàáä]", "a").replaceAll("[êèéë]", "e").replaceAll("[îìíï]", "i").replaceAll("[õôòóö]", "o").replaceAll("[ûúùü]", "u").replaceAll("[ÃÂÀÁÄ]", "A").replaceAll("[ÊÈÉË]", "E").replaceAll("[ÎÌÍÏ]", "I").replaceAll("[ÕÔÒÓÖ]", "O").replaceAll("[ÛÙÚÜ]", "U").replace('ç', 'c').replace('Ç', 'C').replace('ñ', 'n').replace('Ñ', 'N').replaceAll("!", "").replaceAll("\\[\\´\\`\\?!\\@\\#\\$\\%\\¨\\*", " ").replaceAll("\\(\\)\\=\\{\\}\\[\\]\\~\\^\\]", " ").replaceAll("[\\.\\;\\-\\_\\+\\'\\ª\\º\\:\\;\\/\\°]", " ").replace((char) 160, (char) 32).replace("\"", "");
    }

    public static String removeEspacos(String text) {
        return text.replace(" ", "");
    }

    public static String substituirEspacos(String s) {
        if (s != null) {
            s = s.replace(' ', '_');
        }

        return s;
    }

    public static String addMask(String s, String mask) {

        if (s == null || s.isEmpty()) {
            return "";
        }

        MaskFormatter maskFormatter;

        try {
            maskFormatter = new MaskFormatter(mask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            return maskFormatter.valueToString(s);
        } catch (ParseException ex) {
            System.err.println(ex);
        }

        return "";
    }

    public static String formataString(String string, int tamanho, char complemento, boolean alinhaAEsquerda) {
        string = string == null || string.isEmpty() ? "" : string;
        if (string.length() < tamanho) {
            String c = String.valueOf(complemento);
            while (string.length() < tamanho) {
                if (alinhaAEsquerda) {
                    string += c;
                } else {
                    string = c + string;
                }
            }
        } else if (string.length() > tamanho) {
            int diferenca = string.length() - tamanho;
            if (alinhaAEsquerda) {
                string = string.substring(0, string.length() - diferenca);
            } else {
                string = string.substring(diferenca, string.length());
            }
        }

        return string;
    }

    private static String geradorString(int tamanho) {
        SecureRandom random = new SecureRandom();
        String[] numeros = {"0", "1", "b", "2", "4", "5", "6", "7", "8", "9"};
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z"};

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            if (random.nextBoolean()) {
                senha.append(numeros[random.nextInt(numeros.length)]);
            } else {
                if (random.nextBoolean()) {
                    senha.append(letras[random.nextInt(letras.length)]);
                } else {
                    senha.append(letras[random.nextInt(letras.length)].toUpperCase());
                }
            }
        }
        return senha.toString();
    }

    public static String formatarNomeExibicao(String nome) {
        if (nome != null) {
            // Remove prefixos de datas e números
            nome = nome.replaceAll("^\\d{8,}_", ""); // Remove datas e underscores no início
            // Remove extensões e deixa apenas o nome principal
            nome = nome.replaceAll("\\.[A-Za-z]{3,4}$", ""); // Remove extensão do arquivo
            // Substitui underscores e normaliza espaços
            nome = nome.replace("_", " ").trim();

            // Lista de palavras que devem permanecer minúsculas
            List<String> palavrasMinusculas = Arrays.asList("da", "de", "do", "das", "dos", "e");

            // Divide as palavras e capitaliza, ajustando exceções
            String[] palavras = nome.toLowerCase().split(" ");
            List<String> palavrasFormatadas = new ArrayList<>();

            for (String palavra : palavras) {
                if (!palavra.isEmpty()) { // Ignorar palavras vazias
                    if (palavrasFormatadas.isEmpty() || !palavrasMinusculas.contains(palavra)) {
                        // Capitaliza a primeira letra se não for uma palavra de exceção
                        palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
                    }
                    palavrasFormatadas.add(palavra);
                }
            }
            nome = String.join(" ", palavras);
        }
        return nome;
    }

}


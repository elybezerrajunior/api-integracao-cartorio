package Util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Utils {
    
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * <p>
     * É considerado vazio todo e qualquer array cujo valor seja
     * <b>null</b>, ou o tamanho seja <b>zero</b>, ou todos os elementos
     * contidos no array sejam <b>null</b>. </p>
     *
     * @param args
     * @return
     */
    public static boolean isEmpty(Object... args) {


        if (args == null || args.length == 0) {
            return true;
        } else {
            for (Object object : args) {
                if (object != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isNotEmpty(Object... args) {
        return !isEmpty(args);
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String convertDateToString(Date date, String mask) {
        SimpleDateFormat format = new SimpleDateFormat(mask);
        String result = format.format(date);
        return result;
    }

    public static String colocarMascaraCpf(String cpf) {
        if (cpf.length() > 10) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        }
        return cpf;
    }

    public static String colocarMascaraCep(String cep) {
        if (cep.length() > 7) {
            cep = cep.substring(0, 2) + "." + cep.substring(2, 5) + "-" + cep.substring(5, 8);
        }
        return cep;
    }

    public static String colocarMascaraTelefone(String cep) {
        if (cep.length() > 9) {
            cep = "(" + cep.substring(0, 2) + ")" + cep.substring(2, 6) + "-" + cep.substring(6, 10);
        }
        return cep;
    }

    public static String colocarMascaraWhatsapp(String cep) {
        if (cep.length() > 10) {
            cep = "(" + cep.substring(0, 2) + ")" + cep.substring(2, 6) + "-" + cep.substring(6, 11);
        }
        return cep;
    }

    public static String addMascaraCnpj(String cnpj) {
        if (cnpj.length() > 12) {
            cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
        }
        return cnpj;
    }

    public static String addMascaraCpf(String cpf) {
        cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        return cpf;
    }

    public static String addMascaraCep(String cep) {
        cep = cep.substring(0, 2) + "." + cep.substring(2, 5) + "-" + cep.substring(5, 8);
        return cep;
    }
    
}


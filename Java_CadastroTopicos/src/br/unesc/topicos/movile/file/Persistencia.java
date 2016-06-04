package br.unesc.topicos.movile.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Persistencia {

    public static String userFile = "login.dat"; //Arquivo para gravar ultimo login
    public static String logFile = "info.log"; //Arquivo de logs

    public String getHora() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return "[" + dateFormat.format(date) + "]: ";
    }

    public void salvarArquivoDadosLogin(String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(userFile);
            int tamanho = 0;

            while (tamanho < str.length()) {
                fileOutputStream.write((int) str.charAt(tamanho++));
            }

            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void salvarArquivoGeral(String str) {
        String strSalvar = System.getProperty("line.separator") + getHora()+str;
         
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(logFile, true);
            int tamanho = 0;

            while (tamanho < strSalvar.length()) {
                fileOutputStream.write((int) strSalvar.charAt(tamanho++));
            }

            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String lerArquivo(String logFile) {
        java.io.File f = new java.io.File(logFile);
        if (f.exists() && !f.isDirectory()) {

            String str = "";
            try {
                FileInputStream leitorArquivos = new FileInputStream(logFile);
                int lido = leitorArquivos.read();
                while (lido != -1) {
                    str += (char) lido;
                    lido = leitorArquivos.read();
                }
                leitorArquivos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return str;
        } else {
            return "";
        }
    }


}

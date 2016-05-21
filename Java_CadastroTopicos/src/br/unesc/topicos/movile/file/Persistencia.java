/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public static String userFile = "login.dat";
    public static String logFile = "info.log";

    public String getHora() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return "[" + dateFormat.format(date) + "]";
    }

    public void salvarArquivo(String str, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
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

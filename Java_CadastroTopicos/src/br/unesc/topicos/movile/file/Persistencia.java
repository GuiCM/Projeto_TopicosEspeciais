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
import java.util.ArrayList;

public class Persistencia implements Serializable {

    public static String loginFile = "login.dat";

    /* public void salvar(ArrayList<Pessoa> p) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(loginFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(p);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Pessoa> ler(String loginFile) {
        ArrayList<Pessoa> contato = null;
        try {
            FileInputStream leitorArquivos = new FileInputStream(loginFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(leitorArquivos);

            contato = (ArrayList<Pessoa>) objectInputStream.readObject();

            leitorArquivos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contato;
    }*/
    public void salvarLogin(String login) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(loginFile);
            int tamanho = 0;

            while (tamanho < login.length()) {
                fileOutputStream.write((int) login.charAt(tamanho++));
            }

            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String lerLogin(String logFile) {
        java.io.File f = new java.io.File(logFile);
        if (f.exists() && !f.isDirectory()) {

            String login = "";
            try {
                FileInputStream leitorArquivos = new FileInputStream(logFile);
                int lido = leitorArquivos.read();
                while (lido != -1) {
                    login += (char) lido;
                    lido = leitorArquivos.read();
                }
                leitorArquivos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return login;
        } else {
            return "";
        }
    }

}

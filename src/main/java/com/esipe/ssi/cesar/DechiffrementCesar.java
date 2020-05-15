package com.esipe.ssi.cesar;

import java.io.*;
import java.lang.*;

public class DechiffrementCesar {

    private String toDecrypt;
    private  char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public DechiffrementCesar() {
    }

    public DechiffrementCesar(String toDecrypt) {
        this.toDecrypt = toDecrypt;
    }

    public String getToDecrypt() {
        return toDecrypt;
    }

    public void setToDecrypt(String toDecrypt) {
        this.toDecrypt = toDecrypt;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public int getPos(char c, char[] cesar){


        for (int i = 0; i < 26; i++){
            if (cesar[i] == (c)){
                return i;
            }
        }

        return -1;
    }

    //Méthode pour decrypter un message César

    public  String decrypt(int x){

        char[] key = new CesarKeyGenerator().generatingCode(x);

        String crypted ="";
        char[] alpha = getAlphabet();
        String decryption = getToDecrypt();

        System.out.println("\nDebut du decryptage.\n");
        for (int i = 0; i < decryption.length(); i++){
            System.out.println("Decryptage en cours ...");

            if (getPos(decryption.charAt(i), key) == -1){
                crypted = crypted + decryption.charAt(i);
            }else{
                crypted = crypted + alpha[getPos(decryption.charAt(i),key)];
            }

        }
        System.out.println("\nFin du decryptage.");
        return crypted;
    }

    //Méthode pour tester la méthode de décryptage
    public static void main(String[] args) {
        String toDecrypt = "erqmrxu";
        int decalage = 4;

        System.out.println("Mot à decrypter : " +toDecrypt + " \nAvec un decalage de " + decalage);

        DechiffrementCesar dc = new DechiffrementCesar(toDecrypt.toLowerCase());
        System.out.println("\nMessage decrypté : " + dc.decrypt(decalage));


    }
}
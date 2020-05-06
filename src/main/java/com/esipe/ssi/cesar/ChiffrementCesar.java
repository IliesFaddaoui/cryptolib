package com.esipe.ssi.cesar;

import java.io.*;
import java.lang.*;


public class ChiffrementCesar {



    private String toEncrypt;
    private  char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public ChiffrementCesar(String tab){
        toEncrypt = tab;
    }

    public ChiffrementCesar() {
    }

     public String getToEncrypt(){
        return toEncrypt;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public void setToEncrypt(String toEncrypt) {
        this.toEncrypt = toEncrypt;
    }

    public int getPos(char c){
        char[] alpha = getAlphabet();

       for (int i = 0; i < 26; i++){
           if (alpha[i] == (c)){
               return i;
           }
       }

       return -1;
    }



     public  String encrypt(int x){

        char[] key = new CesarKeyGenerator().generatingCode(x);
        String crypted ="";
        String encryption = getToEncrypt();

        System.out.println("\nDebut du cryptage.\n");
        for (int i = 0; i < encryption.length(); i++){
            System.out.println("Cryptage en cours ...");

            if (getPos(encryption.charAt(i)) == -1){
                crypted = crypted + encryption.charAt(i);
            }else{
                crypted = crypted + key[getPos(encryption.charAt(i))];
            }

        }
         System.out.println("\nFin du cryptage.");
        return crypted;
    }


    public static void main(String[] args) {
        String toCrypt = "abcde";
        int decalage = 4;

        System.out.println("Mot à crypter : " +toCrypt + " \nAvec un decalage de " + decalage);

        ChiffrementCesar cc = new ChiffrementCesar(toCrypt.toLowerCase());
        System.out.println("\nMessage crypté : " + cc.encrypt(decalage));

        //System.out.println(cc.getPos('z'));
        //System.out.println(cc.encrypt(cTest,cc.getToEncrypt()));
       // System.out.println(cc.generatingCode(3));
    }
}
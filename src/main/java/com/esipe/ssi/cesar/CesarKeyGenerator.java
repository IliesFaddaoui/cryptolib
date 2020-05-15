package com.esipe.ssi.cesar;

public class CesarKeyGenerator {

    public CesarKeyGenerator() {
    }
    /*
    Méthode pour générer une clé de chiffrage César
     */

    public  char[] generatingCode(int x){

        int decal = x - 1;
        int c = 0;
        int k = 0;

        char[] cesar = new char[25];
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int i = 0; i < cesar.length - decal;i++){

            cesar[i] = alpha[decal+i];
            c++;

        }

        for (int i = c ;i < cesar.length; i++) {

            cesar[i] = alpha[k];
            k++;

        }
        return cesar;
    }
}

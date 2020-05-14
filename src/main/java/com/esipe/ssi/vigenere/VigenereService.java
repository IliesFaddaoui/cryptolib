package com.esipe.ssi.vigenere;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VigenereService {
    public VigenereService(){
    }
    public String encrypt(String message, String key)
    {

        List<Character> alpha = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> messageArray = new ArrayList<>();
        List<Character> keyArray = new ArrayList<>();
        List<Character> encryptedMessageList = new ArrayList<>();
        messageArray = decomposeString(message);
        keyArray = decomposeString(key);
        int counter = 0;
        while(messageArray.size() != keyArray.size()){
            keyArray.add(keyArray.get(counter));
            counter++;
        }
        for(int i =0; i < messageArray.size(); i++) {
            int posLetter = alpha.indexOf(messageArray.get(i));
            int decalage = alpha.indexOf(keyArray.get(i));
            int newPos = decalage + posLetter;
            if(newPos > 26) {
                newPos = newPos - 26;
            }
            char newLetter = alpha.get(newPos);
            System.out.println("lettre initiale: " + messageArray.get(i));
            System.out.println("decalage de :" + decalage + ", nouvelle position" + newPos +", soit la lettre " + newLetter);
            encryptedMessageList.add(newLetter);

        }
        String encryptedMessage = encryptedMessageList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Mot chiffré: " + encryptedMessage);
        return encryptedMessage;
    }
    public List<Character> decomposeString(String string){
        return string.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    }
}

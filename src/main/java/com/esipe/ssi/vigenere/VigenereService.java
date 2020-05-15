package com.esipe.ssi.vigenere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VigenereService {
    public VigenereService() {
    }
    final static List<Character> alpha = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    public String encrypt(String message, String key) {

        List<Character> messageArray = decomposeString(message);
        List<Character> keyArray = decomposeString(key);
        keyArray = createKeyArrayList(keyArray, messageArray.size());
        List<Character> encryptedMessageList = shiftTab(messageArray, keyArray);
        return encryptedMessageList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
    public String decrypt(String message, String key) {
        List<Character> messageArray = decomposeString(message);
        List<Character> keyArray = decomposeString(key);
        keyArray = createKeyArrayList(keyArray, messageArray.size());
        List<Character> decryptedMessageList = unshiftTab(messageArray, keyArray);
        return decryptedMessageList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private List<Character> decomposeString(String string) {
        return string.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    }

    private List<Character> createKeyArrayList(List<Character> keyArray, int size){
        int counter = 0;
        while (size != keyArray.size()) {
            keyArray.add(keyArray.get(counter));
            counter++;
        }
        return keyArray;
    }

    private List<Character> shiftTab(List<Character> messageArray, List<Character> keyArray){
        List<Character> encryptedMessageArray = new ArrayList<>();
        for(int i =0; i <messageArray.size(); i++){
            int newPos = alpha.indexOf(keyArray.get(i)) + alpha.indexOf(messageArray.get(i));
            if (newPos > 26) {
                newPos = newPos - 26;
            }
            encryptedMessageArray.add(alpha.get(newPos));
        }
        return encryptedMessageArray;
    }

    private List<Character> unshiftTab(List<Character> messageArray, List<Character> keyArray){
        List<Character> decryptedMessageArray = new ArrayList<>();
        for(int i =0; i <messageArray.size(); i++){
            int newPos = alpha.indexOf(messageArray.get(i)) - alpha.indexOf(keyArray.get(i));
            if (newPos < 0) {
                newPos = newPos + 26;
            }
            decryptedMessageArray.add(alpha.get(newPos));
        }
        return decryptedMessageArray;

    }

}

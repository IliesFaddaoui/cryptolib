package com.esipe.ssi.crack;

import com.esipe.ssi.CryptUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class CesarCrack {
    public CryptUtil cryptUtil = new CryptUtil();
    Map<Character, Double> letterFreq = cryptUtil.getLetterFreq();
    List<Character> alpha = cryptUtil.getAlpha();
    public CesarCrack(){

    }
    public String crackCesarCrypt(String message){
        List<Character> messageList = cryptUtil.decomposeString(message);
        Map<Character, Long> occurrences = messageList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Character mostComLetter = occurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        Character mostUsedLetter = letterFreq.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        int indexCom = alpha.indexOf(mostComLetter);
        int indexUsed = alpha.indexOf(mostUsedLetter);
        int decalage = indexCom - indexUsed;
        List<Character> crackWord = new ArrayList<>();
        for(int i=0; i < messageList.size(); i++){
            int index = alpha.indexOf(messageList.get(i));
            if(decalage < 0){
                decalage += 26;
            }
            crackWord.add(alpha.get(index - decalage));
        }
        return cryptUtil.decomposeListIntoString(crackWord);
    }
}
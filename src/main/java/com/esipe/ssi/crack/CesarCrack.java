package com.esipe.ssi.crack;

import com.esipe.ssi.CryptUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public String crackCesarCrypt(String message, String realMsg) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        List<Character> crackWord = new ArrayList<>();
        Boolean isCracked = false;
        while(!isCracked){
            List<Character> messageList = cryptUtil.decomposeString(message);
            Map<Character, Long> occurrences = messageList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Character mostComLetter = occurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            Character mostUsedLetter = letterFreq.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            letterFreq.remove(mostUsedLetter);
            int indexCom = alpha.indexOf(mostComLetter);
            int indexUsed = alpha.indexOf(mostUsedLetter);
            int decalage = indexCom - indexUsed;

            for(int i=0; i < messageList.size(); i++){
                int index = alpha.indexOf(messageList.get(i));
                if(index - decalage < 0){
                    index += 26;
                }
                crackWord.add(alpha.get(index - decalage));
            }
            if(realMsg.equals(cryptUtil.decomposeListIntoString(crackWord))){
                isCracked = true;
            }
            else{
                crackWord.clear();
            }
        }
        return cryptUtil.decomposeListIntoString(crackWord);
    }
}
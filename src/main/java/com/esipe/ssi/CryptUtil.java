package com.esipe.ssi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CryptUtil {
    public final Map<Character, Double> letterFreq = Stream.of(new Object[][]{
            {'a', 9.2},
            {'b', 1.02},
            {'c', 2.64},
            {'d', 3.39},
            {'e', 15.87},
            {'f', 0.95},
            {'g', 1.04},
            {'h', 0.77},
            {'i', 8.41},
            {'j', 0.89},
            {'k', 0.00},
            {'l', 5.34},
            {'m', 3.24},
            {'n', 7.15},
            {'o', 5.14},
            {'p', 2.86},
            {'q', 1.06},
            {'r', 6.46},
            {'s', 7.90},
            {'t', 7.26},
            {'u', 6.24},
            {'v', 2.15},
            {'w', 0.00},
            {'x', 0.30},
            {'y', 0.24},
            {'z', 0.32}
    }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Double) data[1]));
    public final List<Character> alpha = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    public List<Character> decomposeString(String string) {
        return string.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
    }

    public String decomposeListIntoString(List<Character> list){
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }
    public Map<Character, Double> getLetterFreq() {
        return letterFreq;
    }

    public List<Character> getAlpha() {
        return alpha;
    }
}

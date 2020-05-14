package com.esipe.ssi;

import com.esipe.ssi.vigenere.VigenereService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CryptoServicesTests {
    @Test
    public void testDecompose(){
        VigenereService vigenereService = new VigenereService();
        String motTest = "Testons";
        List testList = vigenereService.decomposeString(motTest);
        testList.stream().forEachOrdered(System.out::println);
        Assert.assertEquals(1,1);
    }

    @Test
    public void testEncrypt(){
        VigenereService vigenereService = new VigenereService();
        String motTest = "testons";
        String keyTest = "key";
        String encryptedWord = vigenereService.encrypt(motTest, keyTest);
        Assert.assertEquals(encryptedWord, "diqdslc");
    }
}

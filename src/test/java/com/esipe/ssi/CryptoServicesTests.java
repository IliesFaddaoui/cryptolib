package com.esipe.ssi;

import com.esipe.ssi.crack.CesarCrack;
import com.esipe.ssi.vigenere.VigenereService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CryptoServicesTests {
    @Test
    public void testEncrypt(){
        VigenereService vigenereService = new VigenereService();
        String motTest = "testons";
        String keyTest = "key";
        String encryptedWord = vigenereService.encrypt(motTest, keyTest);
        System.out.println("orginal msg: " + motTest);
        System.out.println(("encrypted msg: " + encryptedWord));
        Assert.assertEquals(encryptedWord, "diqdslc");
    }

    @Test
    public void testDecrypt(){
        VigenereService vigenereService = new VigenereService();
        String motTest = "diqdslc";
        String keyTest = "key";
        String encryptedWord = vigenereService.decrypt(motTest, keyTest);
        System.out.println("encrypted msg: " + motTest);
        System.out.println(("original msg: " + encryptedWord));
        Assert.assertEquals(encryptedWord, "testons");
    }

    @Test
    public void testCrack(){
        CesarCrack cesarCrack = new CesarCrack();
        String cracked = cesarCrack.crackCesarCrypt("uftuf");
        Assert.assertEquals("teste",cracked);
    }
}

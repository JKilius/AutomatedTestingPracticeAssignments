package lt.techin.Tests.Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomStringGenerator {

    public static String generateRandomEmail(){
        String charsForEmail = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnoprstuvwxyz";
        StringBuilder generateEmail = new StringBuilder();
        Random rnd = new Random();
        while(generateEmail.length()<10){
            int index = (int) (rnd.nextFloat() *charsForEmail.length());
            generateEmail.append(charsForEmail.charAt(index));
        }
        String generatedEmail = generateEmail.toString();
        return generatedEmail;
    }

    public static String generateRandomName(){
        String charsForName = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprstuvwxyz";
        StringBuilder generateName = new StringBuilder();
        Random rnd = new Random();
        while(generateName.length()<=30){
            int index = (int) (rnd.nextFloat() *charsForName.length());
            generateName.append(charsForName.charAt(index));
        }
        String generatedName = generateName.toString();
        return generatedName;
    }

    public static String generateRandomPassword(){
        String lowerChars = "abcdefghijklmnoprstuvwxyz";
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "1234567890";
        return RandomStringUtils.random(3, lowerChars)
                + RandomStringUtils.random(3, numberChars)
                + RandomStringUtils.random(3, upperChars)
                + System.currentTimeMillis();
    }
}

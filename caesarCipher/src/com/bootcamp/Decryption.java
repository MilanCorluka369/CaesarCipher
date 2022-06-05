package com.bootcamp;
import java.util.Scanner;

public class Decryption {
    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String plainText;
        int shiftKey;
        String answer;
        while (true){
            System.out.print("Enter text for Decryption: ");
            plainText = input.nextLine();
            System.out.print("Enter whole number for Shift Key: ");
            shiftKey = input.nextInt();
            input.nextLine();

            System.out.println("\nDecrypted text: " + decryption(plainText, shiftKey));
            System.out.print("\nDo you want to continue? (y/n): ");
            answer = input.nextLine();

            if(answer.equalsIgnoreCase("y"))
                continue;
            else if (answer.equalsIgnoreCase("n"))
                break;

            while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.print("\nEnter 'y'(yes) or 'n'(no): ");
                answer = input.nextLine();
                if (answer.equalsIgnoreCase("n"))
                    break;
            }
        }
    }

    public static String decryption(String plainText, int shiftKey){
        String textToUpperCase = plainText.toUpperCase().trim();
        String cipherText = "";
        for(int i = 0; i < textToUpperCase.length(); i++){
            if (textToUpperCase.charAt(i) == ' ') {
                cipherText += " ";
                continue;
            } else if (!textToUpperCase.matches("[a-zA-Z\\s']+")){
                System.err.println("Text doesn't contain just letters, try again!");
                break;
            }
            int plainIndex = alphabet.indexOf(textToUpperCase.charAt(i));
            int cipherIndex = (plainIndex - shiftKey) % 26;
            if (cipherIndex < 0)
                cipherIndex = alphabet.length() + cipherIndex;
            char charOfCipherIndex = alphabet.charAt(cipherIndex) ;
            cipherText += charOfCipherIndex;
        }
        return cipherText;
    }
}

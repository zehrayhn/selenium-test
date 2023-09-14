package org.example;

import java.util.Random;

public class EmailHelperPage {
    public String generateRandomUsername() {
        // Rastgele bir kullanıcı adı oluşturmak için kullanabilirsiniz
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomUsername = new StringBuilder();
        Random random = new Random();
        int length = 10; // Kullanıcı adının istediğiniz uzunluğunu ayarlayın

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            randomUsername.append(randomChar);
        }

        return randomUsername.toString();
    }
}

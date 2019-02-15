
package ua.training;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please input an ukrainian surname:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
                System.out.println(isUkrainianSurname(inputLine)
                                   ? "It\'s an ukrainian surname"
                                   : "It\'s not an ukrainian surname");
        }
    }

    public static boolean isUkrainianSurname(String surname) {
        Pattern pattern = Pattern.compile(getRegExUkr());
        Matcher matcher = pattern.matcher(surname);

        return matcher.matches();
    }

    // Main assumptions are the following:
    // 1. Only ukrainian letters, hyphen and apostrophe
    // 2. First letter of surname is capital and can't be "Ь"
    // 3. Only one-word and two-word surnames (hyphenated,
    //    with one apostrophe maximum in the each word)
    public static String getRegExUkr() {
        String[] regexArray = new String[6];

        // Word
        regexArray[0] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]+";
        // Word’word
        regexArray[1] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]*'[а-щґєіїьюя]+";
        // Word-Word
        regexArray[2] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]+-[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]+";
        // Word’word-Word
        regexArray[3] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]*'[а-щґєіїьюя]+-[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]+";
        // Word-Word’word
        regexArray[4] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]+-[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]*'[а-щґєіїьюя]+";
        // Word’word-Word’word
        regexArray[5] = "[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]*'[а-щґєіїьюя]+-[A-ЩҐЄІЇЮЯ][а-щґєіїьюя]*'[а-щґєіїьюя]+";

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < regexArray.length; i++) {
            if (i == 0) {
                stringBuilder.append("^");
            }
            stringBuilder.append("(");
            stringBuilder.append(regexArray[i]);
            stringBuilder.append(")");
            if (i != regexArray.length -1) {
                stringBuilder.append("|");
            } else {
                stringBuilder.append("$");
            }
        }

        return stringBuilder.toString();
    }
}

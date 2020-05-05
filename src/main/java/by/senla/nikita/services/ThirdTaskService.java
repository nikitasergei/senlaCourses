package by.senla.nikita.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ThirdTaskService {

    public String[] getWordsFromSentence(String text) {
        char[] arr = {'.', '!', '?'};
        String sentence;
        int pos = text.length();
        for (char ch : arr) {
            int charPosition = text.indexOf(ch);
            if (charPosition > 0 && charPosition < pos)
                pos = charPosition;
        }
        if (pos != text.length())
            sentence = text.substring(0, pos);
        else {
            return null;
        }
        return sentence.split(" ");
    }

    public int wordsCounter(String[] mass) {
        return mass.length;
    }

    public List<String> toUpperCaseFistSymbol(String[] mass) {
        List<String> listOfUppercaseWords = new ArrayList<>();
        for (String str : mass)
            listOfUppercaseWords.add(str.substring(0, 1).toUpperCase() + str.substring(1) + " ");
        return listOfUppercaseWords;
    }

    public List<String> sortedWords(String[] mass) {
        Arrays.sort(mass);
        List<String> sortedList = new ArrayList<>();
        Collections.addAll(sortedList, mass);
        return sortedList;
    }


}




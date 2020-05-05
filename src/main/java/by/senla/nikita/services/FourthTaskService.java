package by.senla.nikita.services;

import org.springframework.stereotype.Service;

@Service
public class FourthTaskService {

    public int countWord(String text, String word) {
        String[] textArr = text.toLowerCase().split(" ");
        String wordToLowerCase = word.toLowerCase();
        int res = 0;
        for (String words : textArr) {
            if (words.equals(wordToLowerCase))
                res++;
        }
        return res;
    }

}

package by.senla.nikita.services;

import org.springframework.stereotype.Service;

@Service
public class FifthTaskService {

    public int[] generateRandomSequence(int length) {
        int[] sequence = new int[length];
        for (int index = 0; index < length; index++) {
            sequence[index] = index + 1;
        }
        return sequence;
    }

    public int palindromeCounter(int[] sequence) {
        int counter = 0;
        for (int element : sequence) {
            if (element / 10 == element % 10)
                counter++;
        }
        return counter;
    }
}

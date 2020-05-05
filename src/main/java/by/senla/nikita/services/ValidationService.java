package by.senla.nikita.services;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public Long getNumber(String content) throws NumberFormatException {
        return Long.parseLong(content);
    }

    public boolean isWholeNumber(Long number) {
        return (number - Math.floor(number)) == 0;
    }

    public boolean isEvenNumber(Long num) {
        return num % 2 == 0;
    }

    public boolean isSimpleNumber(Long num) {
        if (num == 1)
            return false;
        if (num == 2)
            return true;
        else {
            int i = 3;
            if (isEvenNumber(num))
                return false;
            else {
                while (i * i <= num) {
                    if (num % i == 0)
                        return false;
                    else i = i + 2;
                }
                return true;
            }
        }
    }

    public boolean isPositiveNum(Long number) {
        return number > 0;
    }

    public boolean isInteger(String value) {
        try {
            int intValue = Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }


}

package by.senla.nikita.services;

import org.springframework.stereotype.Service;

@Service
public class SecondTaskService {

    public Long nod(Long x, Long y) {
        if (y == 0)
            return x;
        return nod(y, x % y);
    }

    public Long nok(Long x, Long y) {
        return x / nod(x, y) * y;

    }

}

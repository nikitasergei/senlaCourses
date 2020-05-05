package by.senla.nikita.model.task6;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SimpleDatabase {
    private List<Item> items = new ArrayList<>();

    public SimpleDatabase() {

    }

    public boolean add(Item item) {
        return items.add(item);
    }
}

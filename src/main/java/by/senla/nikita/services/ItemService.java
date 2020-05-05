package by.senla.nikita.services;

import by.senla.nikita.model.task6.Item;
import by.senla.nikita.model.task6.SimpleDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public static SimpleDatabase database = new SimpleDatabase();

    @Autowired
    private ValidationService validationService;

    private Item createItemWithParams(String name, int cost, int weight) {
        Item item = new Item();
        item.setName(name);
        item.setCost(cost);
        item.setWeight(weight);
        return item;
    }

    public boolean addItem(String name, String cost, String weight) {
        if (!name.isEmpty() && validationService.isInteger(cost) && validationService.isInteger(weight)) {
            int costVal = Integer.parseInt(cost);
            int weightVal = Integer.parseInt(weight);
            Item itemWithParams = createItemWithParams(name, costVal, weightVal);
            return database.add(itemWithParams);
        } else return false;
    }
}

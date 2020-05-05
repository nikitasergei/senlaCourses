package by.senla.nikita.services;

import by.senla.nikita.model.task6.BackPack;
import by.senla.nikita.model.task6.Item;
import by.senla.nikita.model.task6.ItemSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BackpackService {

    public boolean isValidCapacity(String capacity) {
        int capacityVal = 0;
        try {
            capacityVal = Integer.parseInt(capacity);
        } catch (NumberFormatException exception) {
            return false;
        }
        return capacityVal > 0;
    }

    /**
     * Method service backpack and put in ItemSet with max price and lower weight
     *
     * @param backpack - backpack for service
     */
    public ItemSet serviceBackPack(BackPack backpack) {
        List<Item> listOfItems = ItemService.database.getItems();
        return getSetsWithMaxCost(getSetsWithSuitableWeight(listOfItems, backpack));
    }

    /**
     * Method return ItemSet contains  Items
     *
     * @param itemSet - ItemSet
     * @return List of Items
     */
    public List<Item> getItemsFromSet(ItemSet itemSet) {
        List<Item> items = new ArrayList<>();
        for (int index = 0; index < itemSet.getSet().length; index++) {
            if (itemSet.getSet()[index] == '1') {
                items.add(ItemService.database.getItems().get(index));
            }
        }
        return items;
    }

    /**
     * Method return all possible ItemSets  which can place in backpack
     *
     * @param itemList - list of items,
     * @param backPack - backpack for check it capacity
     * @return
     */
    private List<ItemSet> getSetsWithSuitableWeight(List<Item> itemList, BackPack backPack) {
        int stuffQuantity = ItemService.database.getItems().size();
        List<ItemSet> setsWithSuitableWeight = new ArrayList<>();
        for (long i = (long) Math.pow(2, stuffQuantity); i < Math.pow(2, stuffQuantity + 1); i++) {
            ItemSet itemSet = new ItemSet();
            itemSet.setSet(Long.toString(i, 2).substring(1).toCharArray());
            for (int j = 0; j < itemSet.getSet().length; j++) {
                if (itemSet.getSet()[j] == '1') {
                    itemSet.setSumWeight(itemSet.getSumWeight() + itemList.get(j).getWeight());
                    itemSet.setSumCost(itemSet.getSumCost() + itemList.get(j).getCost());
                }
            }
            if (itemSet.getSumWeight() <= backPack.getCapacity()) {
                setsWithSuitableWeight.add(itemSet);
            }
        }
        return setsWithSuitableWeight;
    }

    /**
     * Return set with max price
     *
     * @param itemList - list of ItemSet, witch have weight less than backpack's capacity
     * @return most expensive itemSet
     */
    private ItemSet getSetsWithMaxCost(List<ItemSet> itemList) {
        return itemList.stream().max(Comparator.comparingDouble(ItemSet::getSumCost)).orElse(null);
    }
}

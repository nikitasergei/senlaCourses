package by.senla.nikita.controllers;

import by.senla.nikita.model.task6.BackPack;
import by.senla.nikita.model.task6.Item;
import by.senla.nikita.model.task6.ItemSet;
import by.senla.nikita.services.BackpackService;
import by.senla.nikita.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BackpackController {

    @Autowired
    private BackpackService backpackService;

    @GetMapping("sixthTask")
    public String getBackpackMain(Model model) {
        List<Item> items = ItemService.database.getItems();
        model.addAttribute("items", items);
        return "backpackMain";
    }

    @PostMapping("sixthTask")
    public String getBackPack(Model model,
                              @RequestParam String capacity) {
        if (!backpackService.isValidCapacity(capacity)) {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Wrong input of backpack's capacity!");
        } else {
            BackPack backPack = new BackPack(Integer.parseInt(capacity));
            ItemSet theBestItemSetForServiceBackPack = backpackService.serviceBackPack(backPack);
            model.addAttribute("itemsSet", theBestItemSetForServiceBackPack);
            model.addAttribute("Items", backpackService.getItemsFromSet(theBestItemSetForServiceBackPack));
        }
        return "backpackMain";
    }
}

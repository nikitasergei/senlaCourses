package by.senla.nikita.controllers;

import by.senla.nikita.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("addItem")
    public String getAddItemPage() {
        return "addItem";
    }

    @PostMapping("addItem")
    public String addItem(Model model,
                          @RequestParam String name,
                          @RequestParam String weight,
                          @RequestParam String cost) {

        boolean isAdded = itemService.addItem(name, cost, weight);
        if (isAdded) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Item successfully created");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Wrong entered params!");
        }
        return "addItem";
    }


}

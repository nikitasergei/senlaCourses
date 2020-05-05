package by.senla.nikita.controllers;

import by.senla.nikita.services.FourthTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FourthController {

    @Autowired
    private FourthTaskService fourthTaskService;

    @GetMapping("fourthTask")
    public String getFourthTaskPage() {
        return "fourthTaskPage";
    }

    @PostMapping("fourthTask")
    public String getParams(Model model,
                            @RequestParam String text,
                            @RequestParam String word) {

        if (text.isEmpty() || word.isEmpty()) {
            model.addAttribute("exception", "Wrong input of some parameter!");
            model.addAttribute("messageType", "danger");
        } else {
            model.addAttribute("count", fourthTaskService.countWord(text, word));
        }
        return "fourthTaskPage";
    }
}

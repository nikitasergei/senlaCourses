package by.senla.nikita.controllers;

import by.senla.nikita.services.FifthTaskService;
import by.senla.nikita.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FifthTaskController {

    @Autowired
    private FifthTaskService fifthTaskService;

    @Autowired
    private ValidationService validationService;

    @GetMapping("fifthTask")
    public String getFifthTaskPage() {
        return "fifthTaskPage";
    }

    @PostMapping("fifthTask")
    public String getParams(Model model,
                            @RequestParam String length) {
        int number = 0;
        try {
            number = Math.toIntExact(validationService.getNumber(length));

        } catch (NumberFormatException exception) {
            model.addAttribute("exception", "Wrong input format!");
            model.addAttribute("messageType", "danger");
        }
        if (number > 0 && number <= 100) {
            int count = fifthTaskService.palindromeCounter(fifthTaskService.generateRandomSequence(number));
            model.addAttribute("count", count);
        } else {
            model.addAttribute("exception", "Entered value must be from 0 to 100. Try again!");
            model.addAttribute("messageType", "danger");
        }
        return "fifthTaskPage";
    }
}

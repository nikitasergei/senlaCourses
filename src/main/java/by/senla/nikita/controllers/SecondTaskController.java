package by.senla.nikita.controllers;

import by.senla.nikita.services.SecondTaskService;
import by.senla.nikita.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondTaskController {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private SecondTaskService secondTaskService;

    @GetMapping("secondTask")
    public String getSecondTaskPage() {
        return "secondTask";
    }

    @PostMapping("secondTask")
    public String getParams(Model model,
                            @RequestParam String number1,
                            @RequestParam String number2) {
        Long userNumber1;
        Long userNumber2;
        try {
            userNumber1 = validationService.getNumber(number1);
            userNumber2 = validationService.getNumber(number2);
        } catch (NumberFormatException exception) {
            model.addAttribute("exception", "Wrong input");
            model.addAttribute("messageType", "danger");
            return "secondTask";
        }
        if (validationService.isPositiveNum(userNumber1) && validationService.isPositiveNum(userNumber2)) {
            model.addAttribute("nok", secondTaskService.nok(userNumber1, userNumber2));
            model.addAttribute("nod", secondTaskService.nod(userNumber1, userNumber2));
        } else {
            model.addAttribute("exception", "Wrong input");
            model.addAttribute("messageType", "danger");
        }
        return "secondTask";
    }
}

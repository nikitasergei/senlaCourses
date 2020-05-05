package by.senla.nikita.controllers;

import by.senla.nikita.services.ValidationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstTaskController {
    final static Logger logger = Logger.getLogger(FirstTaskController.class);

    @Autowired
    private ValidationService validationService;

    @GetMapping("/firstTask")
    public String getFirstTaskPage() {
        return "firstTaskPage";
    }

    @PostMapping("firstTask")
    public String getParams(Model model, @RequestParam String number) {
        Long userNumber;
        try {
            userNumber = validationService.getNumber(number);
        } catch (NumberFormatException exception) {
            model.addAttribute("exception", "Is not a number");
            model.addAttribute("messageType", "danger");
            return "firstTaskPage";
        }
        if (userNumber != null) {
            if (!validationService.isWholeNumber(userNumber)) {
                model.addAttribute("exception", "Is not a whole number");
                model.addAttribute("messageType", "danger");
            }
            if (validationService.isEvenNumber(userNumber))
                model.addAttribute("evenOrOdd", "is even");
            else model.addAttribute("evenOrOdd", "is odd");
            if (validationService.isSimpleNumber(userNumber))
                model.addAttribute("simpleOrNot", "simple");
            else model.addAttribute("simpleOrNot", "composite");
        } else {
            model.addAttribute("exception", "Wrong input");
            model.addAttribute("messageType", "danger");
        }
        return "firstTaskPage";
    }

}

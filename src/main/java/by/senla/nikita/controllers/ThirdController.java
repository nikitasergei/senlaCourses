package by.senla.nikita.controllers;

import by.senla.nikita.services.ThirdTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThirdController {

    @Autowired
    private ThirdTaskService thirdTaskService;

    @GetMapping("thirdTask")
    public String getThirdTaskPage() {
        return "thirdTaskPage";
    }

    @PostMapping("thirdTask")
    public String getParams(Model model,
                            @RequestParam String text) {

        String[] wordsFromSentence = thirdTaskService.getWordsFromSentence(text);
        if (wordsFromSentence == null) {
            model.addAttribute("exception", "There is no sentence in this input");
            model.addAttribute("messageType", "danger");
        } else {
            model.addAttribute("wordNumber", thirdTaskService.wordsCounter(wordsFromSentence));
            model.addAttribute("sortWord", thirdTaskService.sortedWords(wordsFromSentence));
            model.addAttribute("uppercaseWords", thirdTaskService.toUpperCaseFistSymbol(wordsFromSentence));
        }
        return "thirdTaskPage";
    }
}

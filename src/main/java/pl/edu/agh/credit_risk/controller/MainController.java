package pl.edu.agh.credit_risk.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.agh.credit_risk.model.Input;
import pl.edu.agh.credit_risk.service.CreditRiskService;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@Controller
public class MainController {

    private Input input;

    private CreditRiskService creditRiskService;

    @Autowired
    public MainController(CreditRiskService creditRiskService) {
        this.creditRiskService = creditRiskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("input", new Input());
        model.addAttribute("ages", IntStream.range(0, 100).boxed().collect(Collectors.toList()));
        model.addAttribute("sexs", Arrays.asList("female", "male"));
        model.addAttribute("housings", Arrays.asList("own", "rent", "free"));
        model.addAttribute("jobs", Arrays.asList("todo", "todo", "todo"));
        model.addAttribute("purposes", Arrays.asList("todo", "todo", "todo"));
        return "index";
    }

    @PostMapping("/calculate")
    public String route(Model model, @ModelAttribute("input") Input input) {
        this.input = input;
        model.addAttribute("result", creditRiskService.getCreaditRisk(input));
        return "index";
    }

}


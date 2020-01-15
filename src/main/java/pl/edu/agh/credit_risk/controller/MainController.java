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
        return "index";
    }

    @PostMapping("/route")
    public String route(Model model, @ModelAttribute("input") Input input) {
        this.input = input;
        return "index";
    }

}


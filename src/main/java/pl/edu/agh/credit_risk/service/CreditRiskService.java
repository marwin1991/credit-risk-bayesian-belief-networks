package pl.edu.agh.credit_risk.service;

import org.springframework.stereotype.Component;
import pl.edu.agh.credit_risk.model.Input;



@Component
public class CreditRiskService {

    public CreditRiskService() {

    }

    public String getCreaditRisk(Input input) {
        return "TEST";
    }
}

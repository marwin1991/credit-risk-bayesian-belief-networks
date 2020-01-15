package pl.edu.agh.credit_risk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Input {
    private int age;
    private String sex;
    private String housing;

    private String job;
    private String saving_accounts;
    private String checking_accounts;

    private int creditAmount;
    private int duration;
    private String purpose;
}

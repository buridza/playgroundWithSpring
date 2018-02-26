package by.itacademy;

import by.itacademy.entity.account.user.Language;
import lombok.Data;

@Data
public class Filter {
    private String name = "";
    private Language language;
    private int ageRestriction;
    private int cost = Integer.MAX_VALUE;
    private int numberOfRows = 1;
    private int nextPage;

}

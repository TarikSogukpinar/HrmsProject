package hrmsproject.core.utilities.businessrules;

import hrmsproject.core.utilities.results.Result;

public class BusinessRules {
    public static Result RunBusinessRules(Result... logics) {
        for (var logic : logics) {
            if (!logic.isSuccess())
                return logic;
        }
        return null;
    }
}

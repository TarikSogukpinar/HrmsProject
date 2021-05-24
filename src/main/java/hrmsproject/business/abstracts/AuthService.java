package hrmsproject.business.abstracts;

import hrmsproject.core.entities.concretes.User;
import hrmsproject.core.utilities.results.Result;

public interface AuthService {
    Result login(User user);

}

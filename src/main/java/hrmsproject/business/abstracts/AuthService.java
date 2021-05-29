package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.User;

public interface AuthService {
    Result login(User user);

}

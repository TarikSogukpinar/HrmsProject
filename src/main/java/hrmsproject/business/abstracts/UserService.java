package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    Result add(User user) throws Exception;

    Result delete(User user);

    Result update(User user);
}

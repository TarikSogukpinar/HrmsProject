package hrmsproject.core.utilities.services.concretes;


import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.core.utilities.services.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail() {
        return new SuccessResult(Message.EmailSend);
    }
}

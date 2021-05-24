package hrmsproject.core.utilities.services.abstracts;

import hrmsproject.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public  interface EmailService {
    Result sendEmail();
}

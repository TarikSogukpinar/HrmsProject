package hrmsproject.core.utilities.services.concretes;


import hrmsproject.core.utilities.services.abstracts.IdentityValidationService;
import hrmsproject.core.utilities.services.mernis.CFKKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements IdentityValidationService {


    @Override
    public boolean validate() throws Exception {
        CFKKPSPublicSoap publicSoap = new CFKKPSPublicSoap();
        boolean validateMernis = publicSoap.TCKimlikNoDogrula(12345567891011L ,"Deneme","Deneme",1990);
        if(validateMernis){
            return true;
        }else{
            return false;
        }


    }

}

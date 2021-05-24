package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.PositionService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.dataAccess.abstracts.PositionDao;
import hrmsproject.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {


    private final PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }


    @Override
    public DataResult<List<Position>> getAll() {

        return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), Message.DataListed);
    }

}

package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.PositionService;
import hrmsproject.dataAccess.abstracts.PositionDao;
import hrmsproject.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionManager implements PositionService {


    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }


    @Override
    public List<Position> getAll() {
        return this.positionDao.findAll();
    }
}

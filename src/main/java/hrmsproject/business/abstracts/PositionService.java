package hrmsproject.business.abstracts;

import hrmsproject.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAll();
}

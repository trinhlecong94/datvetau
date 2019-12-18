package com.mycompany.datvetausever.service;

import com.mycompany.datvetausever.entities.CarriageTrainEntity;
import com.mycompany.datvetausever.repository.CarriageTrainRepository;
import java.sql.SQLException;
import java.util.List;

public class CarriageTrainService {

    CarriageTrainRepository carriageTrainRepository = new CarriageTrainRepository();

    public List<CarriageTrainEntity> findCarriageTrainsByTrainID(int id) throws ClassNotFoundException, SQLException {
        return carriageTrainRepository.findCarriageTrainsByTrainID(id);
    }
}

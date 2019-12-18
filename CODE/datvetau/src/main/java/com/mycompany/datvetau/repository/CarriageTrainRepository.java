package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.CarriageTrainEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageTrainRepository extends CrudRepository<CarriageTrainEntity, Integer> {

    @Query(value = "SELECT carriageName FROM seat "
            + "inner join carriage_train_seat on seats_id=id and seat.id=?1 "
            + "inner join carriage_train on carriage_train.id=CarriageTrainEntity_id", nativeQuery = true)
    String findCarriageTrainBySeatId(@Param("seatid") int seatid);
}

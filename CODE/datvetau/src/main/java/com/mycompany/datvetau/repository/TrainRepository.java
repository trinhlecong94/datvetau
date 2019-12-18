package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.TrainEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends PagingAndSortingRepository<TrainEntity, Integer> {

    @Query(value = "select t from TrainEntity t where t.trainName = :trainName")
    TrainEntity findTrainByName(@Param("trainName") String trainName);

    @Query(value = "SELECT trainName FROM seat "
            + "	inner join carriage_train_seat on seats_id=id and seat.id=?1"
            + " inner join carriage_train on carriage_train.id=CarriageTrainEntity_id"
            + " inner join train_carriage_train on carriage_train.id=carriageTrains_id"
            + " inner join train on train.id=TrainEntity_id",
            nativeQuery = true)
    String findTrainNameBySeatId(int seatId);
}

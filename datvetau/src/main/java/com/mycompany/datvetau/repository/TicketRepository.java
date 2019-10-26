package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.SeatEntity;
import com.mycompany.datvetau.entities.TicketEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {

    @Query(value = "select t from TicketEntity t where t.code = :code")
    List<TicketEntity> findAllTicketByCode(@Param("code") String code);
    
    @Query(value = "select t from TicketEntity t where t.departureTime = :departureTime and t.seat = :seat")
    List<TicketEntity> findAllTicketByDateAndSeat(@Param("departureTime") Date departureTime,@Param("seat") SeatEntity seat);
}

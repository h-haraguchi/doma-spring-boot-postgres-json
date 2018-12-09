package com.example.demo9;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ConfigAutowireable
@Dao
@Repository
public interface ReservationDao {
    @Select
    List<Reservation> selectAll();

    @Insert
    @Transactional
    Result<Reservation> insert(Reservation reservation);
}
package com.resellerapp.repository;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    @Query("select o from OfferEntity o where o.createdBy = :user and o.boughtBy is null")
    List<OfferEntity> findAllOffersCreatedByTheCurrentlyLoggedUser(@Param("user") UserEntity user);

    @Query("select o from OfferEntity o where o.createdBy != :user and o.boughtBy is null")
    List<OfferEntity> findAllOffersCreatedByOtherUsers(@Param("user") UserEntity user);

    List<OfferEntity> findAllByBoughtBy(UserEntity boughtBy);
}

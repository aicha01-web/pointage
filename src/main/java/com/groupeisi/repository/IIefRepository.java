package com.groupeisi.repository;

import com.groupeisi.entity.IefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IIefRepository extends JpaRepository<IefEntity,Long> {

}

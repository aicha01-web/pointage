package com.groupeisi.mapping;

import com.groupeisi.domain.Ia;
import com.groupeisi.entity.IaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IaMapper {

    Ia toIa(IaEntity iaEntity);
    IaEntity fromIa(Ia ia);
}

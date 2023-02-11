package com.groupeisi.mapping;

import com.groupeisi.domain.Ief;
import com.groupeisi.entity.IefEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IefMapper {
    Ief toIef(IefEntity iefEntity);
    IefEntity fromIef(Ief ief);
}

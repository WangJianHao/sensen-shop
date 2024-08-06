package com.sensen.sensenshop.converter;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Author:  sensen
 * Date:  2024/7/28 19:39
 */
@Mapper
public interface SourceTargetMapper {

    SourceTargetMapper INSTANCE = Mappers.getMapper(SourceTargetMapper.class);


}

package com.dictionary.ws.entities.mappers;

import com.dictionary.ws.entities.DTO.ListClassDTO;
import com.dictionary.ws.entities.concretes.ListClass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListClassMapper {

        ListClassMapper INSTANCE= Mappers.getMapper(ListClassMapper.class);

        ListClassDTO toDTO(ListClass listClass);

        ListClass toEntity(ListClassDTO listClassDTO);


}

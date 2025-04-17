package dev.pustelnikov.mapper;

import dev.pustelnikov.dto.card.CardDto;
import dev.pustelnikov.mapper.utility.CycleAvoidingMappingContext;
import dev.pustelnikov.model.entity.CardEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = {CycleAvoidingMappingContext.class,  AccountMapper.class})
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDto mapToDto(CardEntity cardEntity);

    @InheritInverseConfiguration
    CardEntity mapToEntity(CardDto cardDto);

    List<CardDto> mapToDto(List<CardEntity> cardEntityList);

    List<CardEntity> mapToEntity(List<CardDto> cardDtoList);
}

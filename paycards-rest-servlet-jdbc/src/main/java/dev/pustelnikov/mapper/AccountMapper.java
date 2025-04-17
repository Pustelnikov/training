package dev.pustelnikov.mapper;

import dev.pustelnikov.dto.AccountDto;
import dev.pustelnikov.mapper.utility.CycleAvoidingMappingContext;
import dev.pustelnikov.model.entity.AccountEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = {CycleAvoidingMappingContext.class,  CardMapper.class})
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto mapToDto(AccountEntity accountEntity);

    @InheritInverseConfiguration
    AccountEntity mapToEntity(AccountDto accountDto);

    List<AccountDto> mapToDto(List<AccountEntity> accountEntityList);

    List<AccountEntity> mapToEntity(List<AccountDto> accountDtoList);
}

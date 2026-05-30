package org.example.quanlysu5.Mapper;

import org.example.quanlysu5.Dto.Request.AccountRequest;
import org.example.quanlysu5.Dto.Response.AccountResponse;
import org.example.quanlysu5.Module.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(target = "role",ignore = true)
    AccountEntity toEntity(AccountRequest request);

//    @Mapping(target = "role",ignore = true)
    AccountResponse toResponse(AccountEntity accountEntity);
}

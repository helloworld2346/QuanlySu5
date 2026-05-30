package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.AccountResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.AccountMapper;
import org.example.quanlysu5.Module.AccountEntity;
import org.example.quanlysu5.Repo.AccountRepo;
import org.example.quanlysu5.Service.AccountService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    AccountMapper accountMapper;

    @Override
    public AccountEntity getAccountById(String id) {
    log.info("Id user: "+id);
        return accountRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.ACCOUNT_NOT_FOUND));
    }

    @Override
    public AccountResponse getAccountResponse(String id) {
        AccountEntity account=getAccountById(id);
        log.info(account.toString());
        return accountMapper.toResponse(account);
    }
}

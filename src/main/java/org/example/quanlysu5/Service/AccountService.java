package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Response.AccountResponse;
import org.example.quanlysu5.Module.AccountEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    AccountEntity getAccountById(String id);
    AccountResponse getAccountResponse(String id);
}

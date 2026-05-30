package org.example.quanlysu5.Service.Impl;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.DonViResponse;
import org.example.quanlysu5.Mapper.UnitsMapper;
import org.example.quanlysu5.Repo.DonViRepo;
import org.example.quanlysu5.Service.DonViService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DonViServiceImpl implements DonViService {

    DonViRepo DonViRepo;
    UnitsMapper unitsMapper;
    @Override
    public Page<DonViResponse> toUnitsPage(Pageable page) {
        return DonViRepo.findAllByIsDeleted(false,page)
                .map(unitsMapper::toResponse);
    }

    @Override
    public List<DonViResponse> toUnitsList() {
        return  DonViRepo.findAll().stream()
                .map(unitsMapper::toResponse).collect(Collectors.toList());
    }

}

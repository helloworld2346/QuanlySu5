package org.example.quanlysu5.Service.Impl;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Response.unitsResponse;
import org.example.quanlysu5.Mapper.unitsMapper;
import org.example.quanlysu5.Module.units;
import org.example.quanlysu5.Repo.unitsRepo;
import org.example.quanlysu5.Service.unitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class unitServiceImpl implements unitService {

    unitsRepo unitsRepo;
    unitsMapper unitsMapper;
    @Override
    public Page<unitsResponse> toUnitsPage(Pageable page) {
        return unitsRepo.findAllByIsDeleted(false,page)
                .map(unitsMapper::toResponse);
    }

    @Override
    public List<unitsResponse> toUnitsList() {
        return  unitsRepo.findAll().stream()
                .map(unitsMapper::toResponse).collect(Collectors.toList());
    }
}

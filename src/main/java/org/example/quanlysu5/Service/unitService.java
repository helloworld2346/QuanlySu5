package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Response.unitsResponse;
import org.example.quanlysu5.Module.units;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface unitService {
    Page<unitsResponse> toUnitsPage(Pageable page);
    List<unitsResponse> toUnitsList();

}

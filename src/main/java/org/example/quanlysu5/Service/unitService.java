package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Response.UnitsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface unitService {
    Page<UnitsResponse> toUnitsPage(Pageable page);
    List<UnitsResponse> toUnitsList();

}

package org.example.quanlysu5.Hepler;

import lombok.RequiredArgsConstructor;
import org.example.quanlysu5.Dto.Request.DonviRequest;
import org.example.quanlysu5.Service.DonViService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final DonViService donViService;

    public void saveAll(List<DonviRequest> data) {

        data.forEach(donViService::createDonVi);
    }
}

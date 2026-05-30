package org.example.quanlysu5.Service.Impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.quanlysu5.Dto.Request.FeatureRequest;
import org.example.quanlysu5.Dto.Response.FeatureResponse;
import org.example.quanlysu5.Exception.AppException;
import org.example.quanlysu5.Exception.ErrorCode;
import org.example.quanlysu5.Mapper.FeatureMapper;
import org.example.quanlysu5.Module.FeatureEntity;
import org.example.quanlysu5.Repo.FeatureRepo;
import org.example.quanlysu5.Service.FeatureService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FeatureServiceImpl implements FeatureService {
    FeatureRepo FeatureRepo;
    FeatureMapper featureMapper;


    @Override
    public List<FeatureResponse> getAllFeature() {
        return FeatureRepo.findAll().stream()
                .map(featureMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public FeatureEntity getFeatureById(String id) {
        return FeatureRepo.findById(id)
                .orElseThrow(()->new AppException(ErrorCode.FEATURE_NOT_FOUND));
    }

    @Override
    public FeatureEntity getFeatureByName(String name) {
        return FeatureRepo.findByFeatureName(name)
                .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
    }

    @Override
    public FeatureResponse getFeatureResponseById(String id) {
        return featureMapper.toResponse(getFeatureById(id));
    }

    @Override
    public FeatureEntity createFeature(FeatureRequest featureRequest) {
        FeatureEntity featureEntity=featureMapper.toEntity(featureRequest);
        featureEntity.setIsDeleted(false);
        featureEntity.setCreatedAt(LocalDateTime.now());
        if(getFeatureByName(featureEntity.getFeatureName())!=null){
            throw new AppException(ErrorCode.FEATURE_IS_EXIST);
        }
        return FeatureRepo.save(featureEntity);
    }
}

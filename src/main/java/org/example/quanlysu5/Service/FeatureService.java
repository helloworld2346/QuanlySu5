package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.FeatureRequest;
import org.example.quanlysu5.Dto.Request.FeatureRequest;
import org.example.quanlysu5.Dto.Response.FeatureResponse;
import org.example.quanlysu5.Module.FeatureEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface FeatureService {
    List<FeatureResponse> getAllFeature();
   FeatureEntity getFeatureById(String id);
   FeatureEntity getFeatureByName(String name);
    FeatureResponse getFeatureResponseById(String id);
   FeatureEntity createFeature(FeatureRequest featureRequest);

}

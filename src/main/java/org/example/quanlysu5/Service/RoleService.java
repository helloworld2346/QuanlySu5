package org.example.quanlysu5.Service;

import org.example.quanlysu5.Dto.Request.RoleRequest;
import org.example.quanlysu5.Dto.Response.RoleResponse;
import org.example.quanlysu5.Module.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RoleService {
    List<RoleResponse> getAllRole();
   RoleEntity getRoleById(String id);
   RoleEntity getRoleByName(String name);
    RoleResponse getRoleResponseById(String id);
   RoleEntity createRole(RoleRequest roleRequest);

}

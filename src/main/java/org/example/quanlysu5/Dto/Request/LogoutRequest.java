package org.example.quanlysu5.Dto.Request;

import lombok.Builder;

@Builder
public record LogoutRequest(
        String token
) {
}

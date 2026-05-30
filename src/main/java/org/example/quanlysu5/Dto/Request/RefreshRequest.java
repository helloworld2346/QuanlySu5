package org.example.quanlysu5.Dto.Request;

import lombok.Builder;

@Builder
public record RefreshRequest(
        String token
) {
}

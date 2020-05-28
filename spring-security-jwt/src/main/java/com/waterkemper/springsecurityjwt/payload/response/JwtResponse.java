package com.waterkemper.springsecurityjwt.payload.response;

import java.util.List;

public record JwtResponse(String token, Long id, String username, String email, List<String>roles) {
    static String type = "Bearer";
}
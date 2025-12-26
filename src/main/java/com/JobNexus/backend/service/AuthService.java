package com.JobNexus.backend.service;

import com.JobNexus.backend.request.LoginRequest;
import com.JobNexus.backend.request.RegisterRequest;
import com.JobNexus.backend.response.AuthResponse;

public interface AuthService {
    String register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);
}

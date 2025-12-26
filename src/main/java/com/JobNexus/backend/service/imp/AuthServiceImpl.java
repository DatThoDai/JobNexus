package com.JobNexus.backend.service.imp;

import com.JobNexus.backend.entity.Roles;
import com.JobNexus.backend.entity.Users;
import com.JobNexus.backend.exception.BadRequestException;
import com.JobNexus.backend.repositories.RoleRepository;
import com.JobNexus.backend.repositories.UserRepository;
import com.JobNexus.backend.request.LoginRequest;
import com.JobNexus.backend.request.RegisterRequest;
import com.JobNexus.backend.response.AuthResponse;
import com.JobNexus.backend.service.AuthService;
import com.JobNexus.backend.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTHelper jwtHelper;
    @Override
    @Transactional
    public String register(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new BadRequestException("Email đã được sử dụng");
        }

        if(registerRequest.getPhone() !=null && userRepository.existsByPhone(registerRequest.getPhone())){
            throw new BadRequestException("Số điện thoại đã được sử dụng");
        }
        Roles role = roleRepository.findByRoleName(registerRequest.getRoleName())
                .orElseThrow(() -> new BadRequestException("Vai trò không tồn tại"));

        if(role.getRoleName().equals("ROLE_ADMIN")){
            throw new BadRequestException("Không thể đăng ký với vai trò ADMIN");
        }
        Users user = new Users();
        user.setEmail(registerRequest.getEmail());
        user.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFullName(registerRequest.getFullName());
        user.setPhone(registerRequest.getPhone());
        user.setRole(role);
        user.setVerified(false);
        userRepository.save(user);
        return "Đăng ký thành công";
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Users user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new BadRequestException("Email hoặc mật khẩu không đúng"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())){
            throw new BadRequestException("Email hoặc mật khẩu không đúng");
        }
        return jwtHelper.generateToken(user.getEmail());
    }
}

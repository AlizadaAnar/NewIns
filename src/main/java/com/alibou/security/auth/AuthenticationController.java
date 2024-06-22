package com.alibou.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://oragnic-1tjq.vercel.app", allowCredentials = "true", allowedHeaders = {"Authorization", "Content-Type"})
public class AuthenticationController {

    private final AuthenticationService service;

    @CrossOrigin(origins = "https://oragnic-1tjq.vercel.app")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @CrossOrigin(origins = "https://oragnic-1tjq.vercel.app")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @CrossOrigin(origins = "https://oragnic-1tjq.vercel.app")
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    @CrossOrigin(origins = "https://oragnic-1tjq.vercel.app")
    @GetMapping("/takeAll")
    public String getAll() {
        return "hi";
    }


}

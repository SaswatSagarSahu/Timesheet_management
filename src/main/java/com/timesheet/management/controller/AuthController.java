package com.timesheet.management.controller;


/**
 * Controller for JWT token generation.
 * 
 * Developer: SIVA NAGA RAJU PAMARTHI
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.timesheet.management.requestDTO.AuthRequest;
import com.timesheet.management.utils.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtils jwtUtil;

    public AuthController(JwtUtils jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Generate JWT token based on username and role.
     * 
     * POST /api/auth/token
     * Request body: { "username": "siva", "role": "ADMIN" }
     */
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(request.getUserName(), request.getRole());
        return ResponseEntity.ok().body("Bearer " + token);
    }
}

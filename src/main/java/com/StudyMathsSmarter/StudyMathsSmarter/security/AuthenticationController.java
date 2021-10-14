package com.StudyMathsSmarter.StudyMathsSmarter.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={"http://localhost:3000"})
@RestController
public class AuthenticationController {
    @GetMapping(path="auth")
    public Authentication authenticate(){
        return new Authentication("success");
    }
}

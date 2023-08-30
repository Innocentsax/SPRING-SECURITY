package dev.InnocentUdo.oauth2.Oauth2_Social_vetting.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inno")
public class LoginController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from Secured endpoint");
    }
}

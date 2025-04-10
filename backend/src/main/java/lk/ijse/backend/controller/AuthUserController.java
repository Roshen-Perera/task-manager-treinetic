package lk.ijse.backend.controller;
import lk.ijse.backend.DataPersistException;
import lk.ijse.backend.dto.impl.UserDTO;
import lk.ijse.backend.secure.JWTAuthResponse;
import lk.ijse.backend.secure.SignIn;
import lk.ijse.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/auth/")

@RestController
@RequiredArgsConstructor
public class AuthUserController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(value = "signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> saveUser(
            @RequestPart ("username") String username,
            @RequestPart ("password") String password
    ) {
        try {
            var buildUserDTO = new UserDTO();
            buildUserDTO.setUsername(username);
            buildUserDTO.setPassword(passwordEncoder.encode(password));
            return ResponseEntity.ok(authService.signUp(buildUserDTO));
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authService.signIn(signIn));
    }
    @PostMapping("refresh")
    public ResponseEntity<JWTAuthResponse> refreshToken(@RequestParam ("existingToken") String existingToken) {
        return ResponseEntity.ok(authService.refreshToken(existingToken));
    }
}

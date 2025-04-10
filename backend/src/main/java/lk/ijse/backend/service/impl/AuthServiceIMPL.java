package lk.ijse.backend.service.impl;

import lk.ijse.backend.dao.UserDAO;
import lk.ijse.backend.dto.impl.UserDTO;
import lk.ijse.backend.entity.impl.User;
import lk.ijse.backend.secure.JWTAuthResponse;
import lk.ijse.backend.secure.SignIn;
import lk.ijse.backend.service.AuthService;
import lk.ijse.backend.service.JWTService;
import lk.ijse.backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDAO userDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword()));
        var user =   userDao.findByUsername(signIn.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO signUp) {
        signUp.setPassword(signUp.getPassword());
        User user = mapping.toUserEntity(signUp);
        if (userDao.existsById(signUp.getUsername())) throw new UsernameNotFoundException("user Alrady Exsist");
        userDao.save(user);
        var jwtToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        //extract user name
        var userName = jwtService.extractUserName(accessToken);
        //check the user availability in the DB
        var findUser = userDao.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(findUser);
        return JWTAuthResponse.builder().token(refreshToken).build();
    }


}

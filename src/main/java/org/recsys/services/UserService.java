package org.recsys.services;

import org.recsys.DTOs.SigninRequestDto;
import org.recsys.DTOs.SignupRequestDto;
import org.recsys.exceptions.UserSigninException;
import org.recsys.exceptions.UserSignupException;
import org.recsys.infrastucture.entities.Session;
import org.recsys.infrastucture.entities.User;
import org.recsys.repositories.SessionRepository;
import org.recsys.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public UserService(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public Session signup(SignupRequestDto signupRequestDto) throws UserSignupException {
        if(!signupRequestDto.getPassword().equals(signupRequestDto.getConfirmPassword()))
            throw new UserSignupException("Passwords do not match.");

        if(userRepository.findByEmail(signupRequestDto.getEmail()) != null)
        {
            throw new UserSignupException("User with email " + signupRequestDto.getEmail() + " already exists.");
        }

        String hashedPassword = BCrypt.hashpw(signupRequestDto.getPassword(), BCrypt.gensalt());
        User user = new User(signupRequestDto.getEmail(), hashedPassword);
        userRepository.save(user);

        Session session = new Session(user);
        sessionRepository.save(session);

        return session;
    }

    public Session signin(SigninRequestDto signinRequestDto) throws UserSigninException {
        User user = userRepository.findByEmail(signinRequestDto.getEmail());
        if(user == null)
        {
            throw new UserSigninException();
        }

        if(!BCrypt.checkpw(signinRequestDto.getPassword(), user.getHashedPassword()))
        {
            throw new UserSigninException();
        }

        Session session = new Session(user);
        sessionRepository.save(session);
        return session;
    }
}
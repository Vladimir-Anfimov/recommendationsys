package org.recsys.services;

import org.recsys.DTOs.ProductWishlistItemDto;
import org.recsys.DTOs.SigninRequestDto;
import org.recsys.DTOs.SignupRequestDto;
import org.recsys.exceptions.SessionCookieException;
import org.recsys.exceptions.UserSigninException;
import org.recsys.exceptions.UserSignupException;
import org.recsys.infrastucture.entities.Session;
import org.recsys.infrastucture.entities.User;
import org.recsys.repositories.ProductRepository;
import org.recsys.repositories.SessionRepository;
import org.recsys.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, SessionRepository sessionRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.productRepository = productRepository;
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

    public User getUserByCookieSession(String token) throws SessionCookieException {
        if(token.equals("NONE"))
        {
            throw new SessionCookieException();
        }

        User user = sessionRepository.findByToken(token);

        if(user == null)
        {
            throw new SessionCookieException();
        }
        return user;
    }

    public void addWishlistItem(String token, Integer productId) throws SessionCookieException {
        User user = getUserByCookieSession(token);
        user.getWishlist().add(productRepository.findById(productId).get());
        userRepository.save(user);
    }

    public List<ProductWishlistItemDto> getWishlist(String token) throws SessionCookieException {
        User user = getUserByCookieSession(token);
        return user.getWishlist().stream().map(ProductWishlistItemDto::new).toList();
    }

}
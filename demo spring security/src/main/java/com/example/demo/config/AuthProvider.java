package com.example.demo.config;

import com.federal.questionnaire.dao.AttemptsRepository;
import com.federal.questionnaire.dao.QuestionnaireDao;
import com.federal.questionnaire.model.Attempts;
import com.federal.questionnaire.model.User;
import com.federal.questionnaire.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;


@Component
public class AuthProvider implements AuthenticationProvider {

    private static final int ATTEMPTS_LIMIT = 3;

    @Autowired
    private SecurityUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AttemptsRepository attemptsRepository;
    @Autowired
    private QuestionnaireDao userRepository;

// Uncomment for federal deployment

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = (String) authentication.getCredentials();
//
//        Optional<Attempts> userAttempts = attemptsRepository.findAttemptsByUsername(username);
//        Optional<User> user = Optional.ofNullable(userDetailsService.loadUserByUsername(username));
//
//        if(user.isPresent()){
//
//            User currentUser = user.get();
//            Boolean auth= authensuccess(username, password);
//System.out.print("auth is"+auth);
//            if(auth){
//            	System.out.print("current user "+ currentUser);
//            	System.out.print("currentUser.getAccountNonLocked() "+ currentUser.getAccountNonLocked());
//                if (currentUser.getAccountNonLocked()){
//                    // proceed
//
//                    if (userAttempts.isPresent()) {
//                        Attempts attempts = userAttempts.get();
//                        attempts.setNumberOfAttempts(0);
//                        attemptsRepository.save(attempts);
//                    }
//
//                    Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
//
//                    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(currentUser, password,authorities);
//                    return authReq;
//
//                }else{
//                    // locked
//                    throw new LockedException("Too many invalid attempts. Account is locked!!");
//                }
//
//            }else{
//                // Error
//                processFailedAttempts(username,currentUser);
//            }
//
//        }else{
//            throw new AuthenticationException("No user found with username \'"+username+"\'") {
//                @Override
//                public String getMessage() {
//                    return super.getMessage();
//                }
//            };
//        }
//
//        return null;
//    }
//
//    public Boolean authensuccess(String user, String strpass) {
//
//        UserDetailsModel obj;
//        try {
//        obj = SOAPUtilities.makeSOAPRequest(user, strpass);
//        System.out.print("object is "+obj);
//        if (obj!=null) {
//            return true;
//        } else
//            return false;
//        }catch(Exception e) {
//        	return false;
//        }
//    }

    ////////////////

// comment for federal deployment

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Optional<Attempts> userAttempts = attemptsRepository.findAttemptsByUsername(username);
        Optional<User> user = Optional.ofNullable(userDetailsService.loadUserByUsername(username));

        if(user.isPresent()){

            User currentUser = user.get();
            if(passwordEncoder.matches(password,currentUser.getPassword())){

                if (currentUser.getAccountNonLocked()){
                    // proceed

                    if (userAttempts.isPresent()) {
                        Attempts attempts = userAttempts.get();
                        attempts.setNumberOfAttempts(0);
                        attemptsRepository.save(attempts);
                    }

                    Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();

                    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(currentUser, password,authorities);
                    return authReq;

                }else{
                    // locked
                    throw new LockedException("Too many invalid attempts. Account is locked!!");
                }

            }else{
                // Error
                processFailedAttempts(username,currentUser);
            }

        }else{
            throw new AuthenticationException("No user found with username \'"+username+"\'") {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }


        return null;
    }

//////////////

// Do Nothing here

    private void processFailedAttempts(String username, User user) {
        Optional<Attempts>
                userAttempts = attemptsRepository.findAttemptsByUsername(username);
        if (!userAttempts.isPresent()) {
            Attempts attempts = new Attempts();
            attempts.setUsername(username);
            attempts.setNumberOfAttempts(1);
            attemptsRepository.save(attempts);
        } else {
            Attempts attempts = userAttempts.get();
            attempts.setNumberOfAttempts(attempts.getNumberOfAttempts() + 1);
            attemptsRepository.save(attempts);

            if (attempts.getNumberOfAttempts() + 1 >
                    ATTEMPTS_LIMIT) {
                user.setAccountNonLocked(false);
                userRepository.saveUser(user);
                throw new LockedException("Too many invalid attempts. Account is locked!!");
            }else{
                throw new AuthenticationException("Invalid Username and Password!") {
                    @Override
                    public String getMessage() {
                        return super.getMessage();
                    }
                };
            }
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

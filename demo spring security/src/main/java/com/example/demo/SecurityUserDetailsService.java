package com.example.demo;

import com.federal.questionnaire.dao.QuestionnaireDao;
import com.federal.questionnaire.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {



    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = dao.getUserbyUsername(username);
        return (user.isPresent() ? user.get() : null);
    }

}


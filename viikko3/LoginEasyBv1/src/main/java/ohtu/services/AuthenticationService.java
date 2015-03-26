package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password


        return (invalidUsername(username) || usernameAlreadyTaken(username) || invalidPassword(password));
    }

    private boolean invalidUsername(String username) {
        if (username.length() > 2) {
            for (char character : username.toCharArray()) {
                if (character < 97 || character > 122) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private boolean usernameAlreadyTaken(String username){
        if(userDao.findByName(username) != null){
            return true;
        }
        return false;
    }

    private boolean invalidPassword(String password) {
        if (password.length() > 7) {
            for (char character : password.toCharArray()) {
                if (character < 65 || character > 122) {
                    return false;
                }
            }
        }
        return true;
    }
    
   
}


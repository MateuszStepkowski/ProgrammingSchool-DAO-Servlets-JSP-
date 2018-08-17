package pl.coderslab.service;

import org.mindrot.BCrypt;

public class UserService {
    public static String hashPassword(String passwordToHash){
        return  BCrypt.hashpw(passwordToHash, BCrypt.gensalt());
    }
}
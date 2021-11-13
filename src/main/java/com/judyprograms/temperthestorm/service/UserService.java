package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.exception.InvalidPasswordException;
import com.judyprograms.temperthestorm.exception.UserNotFoundException;
import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public String createUser(User user) {
       User savedUser = userRepository.save(user);
        return savedUser.getUsername();
    }

    public void updateUser(String username, User newUser) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        } else {
            User user = userOptional.get();
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
//            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setEmail(newUser.getEmail());
//            user.setEnabled(newUser.isEnabled());
            userRepository.save(user);
        }
    }


//
    public void deleteUser(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
        } else {
            throw new UserNotFoundException(username);
        }
    }

//    private String getCurrentUsername() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return ((UserDetails) authentication.getPrincipal()).getUsername();
//    }

    private boolean isValidPassword(String password) {
        final int MIN_LENGTH = 8;
        final int MIN_DIGITS = 1;
        final int MIN_LOWER = 1;
        final int MIN_UPPER = 1;
        final int MIN_SPECIAL = 1;
        final String SPECIAL_CHARS = "@#$%&*!()+=-_";

        long countDigit = password.chars().filter(ch -> ch >= '0' && ch <= '9').count();
        long countLower = password.chars().filter(ch -> ch >= 'a' && ch <= 'z').count();
        long countUpper = password.chars().filter(ch -> ch >= 'A' && ch <= 'Z').count();
        long countSpecial = password.chars().filter(ch -> SPECIAL_CHARS.indexOf(ch) >= 0).count();

        boolean validPassword = true;
        if (password.length() < MIN_LENGTH) validPassword = false;
        if (countLower < MIN_LOWER) validPassword = false;
        if (countUpper < MIN_UPPER) validPassword = false;
        if (countDigit < MIN_DIGITS) validPassword = false;
        if (countSpecial < MIN_SPECIAL) validPassword = false;

        return validPassword;
    }

    public void setPassword(String username, String password) {
//        if (username.equals(getCurrentUsername())) {
            if (isValidPassword(password)) {
                Optional<User> userOptional = userRepository.findByUsername(username);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    user.setPassword(password);
//                    user.setPassword(passwordEncoder.encode(password));
                    userRepository.save(user);
                } else {
                    throw new UserNotFoundException(username);
                }
            } else {
                throw new InvalidPasswordException();
            }
//        } else {
//            throw new NotAuthorizedException();
//        }
    }


//    CREATE USER WITH SECURITY:
//    public String createUser(UserRequestDto userRequestDto) {
//        try {
//            String encryptedPassword = passwordEncoder.encode(userRequestDto.getPassword());
//
//            User user = new User();
//
//            user.setUsername(userRequestDto.getUsername());
//            user.setPassword(encryptedPassword);
//            user.setEmail(userRequestDto.getEmail());
//            user.setEnabled(true);
//
//            user.addAuthority("ROLE_USER");
//            for (String authorityString : userRequestDto.getAuthorities()) {
//                user.addAuthority(authorityString);
//            }
//
//            User savedUser = userRepository.save(user);
//            return savedUser.getUsername();
//        }
//        catch (Exception ex) {
//            throw new BadRequestException("Cannot create user.");
//        }
//
//    }


//    VOORBEELDEN UIT BEGIN, TOEN NOG IN CONTROLLER:
//
//    ZOEKEN/FILTEREN op alle users met bepaalde username:
//    @GetMapping("/users")
//    public ResponseEntity getAllUsers(@RequestParam(required = false) String username) {
//        Iterable<User> users = userRepository.findAll();
//        if (username == null) {
//            return ResponseEntity.ok(users);
//        } else {
//            return ResponseEntity.ok(
//                    StreamSupport.stream(users.spliterator(), false)
//                            .filter(user -> user.username.equalsIgnoreCase(username))
//                            .toArray()
//            );
//        }
//    }
//
//    RECORD NOT FOUND:
//    @GetMapping("/users/{id}")
//    public ResponseEntity getUser(@PathVariable long id) {
//      try {
//        Optional<User> user = userRepository.findById(id);
//        return ResponseEntity.ok(user);
//      } catch (Exception ex) {
//        throw new RecordNotFoundException();
//      }
//    }


}

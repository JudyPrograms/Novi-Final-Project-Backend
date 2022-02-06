package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.dto.UserRequestDto;
import com.judyprograms.temperthestorm.exception.InvalidPasswordException;
import com.judyprograms.temperthestorm.exception.NotUniqueException;
import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import com.judyprograms.temperthestorm.exception.UserNotFoundException;
import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.repository.PlayerRepository;
import com.judyprograms.temperthestorm.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return userRepository.findByUsername(username);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public Optional<Player> getUserPlayer(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!(user.getPlayer()==null)) {
                Player player = user.getPlayer();
                return playerRepository.findById(player.getId());
            } else {
                throw new RecordNotFoundException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    public String createUser(UserRequestDto userRequestDto, Boolean admin) {
//        HOE KAN IK HIER EEN DEFAULT WAARDEN PLAYER INITIALISEREN?
//        Player newPlayer = new Player();
//        user.setPlayer(newPlayer);
//        Dit moet zo: user.setLevel
//        Kun je hiervoor de players repository met autowired gebruiken? Player newPlayer = playerRepository.save(player)?
//        > Zie vraag in college 18/11/21 @1:07:38

//        TODO: Password validation

        String newUsername = userRequestDto.getUsername();
        String newEmail = userRequestDto.getEmail();
        if (userRepository.findByUsername(newUsername).isPresent()) {
            throw new NotUniqueException("Username already exists, unique username required.");
        } else if (userRepository.findByEmail(newEmail).isPresent()) {
            throw new NotUniqueException("Email already exists, unique email required.");
        } else {

            User user = new User();
            user.setUsername(userRequestDto.getUsername());
            user.setEmail(userRequestDto.getEmail());
            user.setPassword(userRequestDto.getPassword());
            user.setAdmin(admin);

            Player newPlayer = new Player();
            user.setPlayer(newPlayer);

            User newUser = userRepository.save(user);

            return newUser.getUsername();
        }
    }

    @Transactional
    public void removeUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            userRepository.deleteByUsername(username);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public void updateUser(String username, User newUser) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
//            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setEmail(newUser.getEmail());
//            user.setEnabled(newUser.isEnabled());
            user.setAdmin(newUser.getAdmin());
            userRepository.save(user);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public void partialUpdateUser (String username, User newUser) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!(newUser.getUsername()==null) && !newUser.getUsername().isEmpty()) {
                user.setUsername(newUser.getUsername());
            }
            if (!(newUser.getEmail()==null) && !newUser.getEmail().isEmpty()) {
                user.setEmail(newUser.getEmail());
            }
            if (!(newUser.getPassword()==null) && !newUser.getPassword().isEmpty()) {
                user.setPassword(newUser.getPassword());
            }
            if (!(newUser.getAdmin()==null) && !newUser.getAdmin() == user.getAdmin()) {
                user.setAdmin(newUser.getAdmin());
            }
            userRepository.save(user);
        } else {
            throw new UserNotFoundException(username);
        }

    }


//    EXAMPLE FOR PASSWORD CHECK:
//    public void updatePassword(String username, String password) {
////        if (username.equals(getCurrentUsername())) {
//        if (isValidPassword(password)) {
//            Optional<User> userOptional = userRepository.findByUsername(username);
//            if (userOptional.isPresent()) {
//                User user = userOptional.get();
//                user.setPassword(password);
////                    user.setPassword(passwordEncoder.encode(password));
//                userRepository.save(user);
//            } else {
//                throw new UserNotFoundException(username);
//            }
//        } else {
//            throw new InvalidPasswordException();
//        }
////        } else {
////            throw new NotAuthorizedException();
////        }
//    }


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

        boolean validPassword = password.length() >= MIN_LENGTH;
        if (countLower < MIN_LOWER) validPassword = false;
        if (countUpper < MIN_UPPER) validPassword = false;
        if (countDigit < MIN_DIGITS) validPassword = false;
        if (countSpecial < MIN_SPECIAL) validPassword = false;

        return validPassword;
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


}

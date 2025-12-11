package com.revature.firstmock;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService implements UserServiceAPI {
    private UserRepository repository;
    private EmailClient emailClient;

    // A commonly used, practical regex pattern (case-insensitive)
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public UserService(UserRepository repository, EmailClient emailClient) {
        this.repository = repository;
        this.emailClient = emailClient;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = this.repository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User createUser(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email");
        }

        if (this.repository.existsByEmail(user.getEmail())) {
            throw new DuplicateUserException("This email has already been registered to another user");
        }

        return this.repository.save(user);
    }

    @Override
    public List<User> getActiveUsers() {
        return this.repository.findAllActive();
    }

    @Override
    public long getUserCount() {
        return this.repository.count();
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailClient.send(to, subject, body);
    }

    // Returns true if emailStr matches the pattern for a valid email; otherwise, returns false.
    private static boolean isValidEmail(String emailStr) {
        if (emailStr == null) {
            return false;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }

        public UserNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class DuplicateUserException extends RuntimeException {
        public DuplicateUserException(String message) {
            super(message);
        }

        public DuplicateUserException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

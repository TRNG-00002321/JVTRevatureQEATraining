package com.revature.firstmock;

import java.util.List;

public interface UserServiceAPI {
    User getUser(Long id);
    User createUser(User user);
    List<User> getActiveUsers();
    long getUserCount();
    void sendEmail(String to, String subject, String body);
}

package com.hisu.dev.fundamental.service.impl;

import com.hisu.dev.fundamental.model.User;
import com.hisu.dev.fundamental.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>(
            List.of(new User("u_01", "Harry", 21),
                    new User("u_02", "Joe", 22),
                    new User("u_03", "Jane", 23),
                    new User("u_04", "Peter", 24)
            )
    );

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getUserById(String id) {
        Optional<User> result = users.stream().filter(user -> user.getId().equalsIgnoreCase(id)).findFirst();
        return result.orElse(null);
    }

    @Override
    public boolean addUser(User newUser) {
        try {
            users.add(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(String id) {

        for (User user : users) {
            if (user.getId().equalsIgnoreCase(id)) {
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateUser(User updateUser) {

        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i).getId().equalsIgnoreCase(updateUser.getId())) {
                users.set(i, updateUser);
                return true;
            }
        }

        return false;
    }
}

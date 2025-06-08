package com.principles.DDD.domain.user.factory;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.presentation.user.dtos.UserRequest;

public class UserFactory {
    public static User create(UserRequest requestEntity) throws Exception {
        return new User(requestEntity);
    }
}

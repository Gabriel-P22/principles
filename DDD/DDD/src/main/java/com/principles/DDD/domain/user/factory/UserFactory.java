package com.principles.DDD.domain.user.factory;

import com.principles.DDD.domain.user.entities.User;
import com.principles.DDD.domain.user.vo.Address;
import com.principles.DDD.presentation.user.dtos.AddressRequest;
import com.principles.DDD.presentation.user.dtos.UserRequest;

public class UserFactory {
    public static User create(final UserRequest requestEntity) throws Exception {
        return new User(requestEntity);
    }

    public static User create(final UserRequest requestEntity, AddressRequest address) throws Exception {
        User user = new User(requestEntity);
        user.changeAddress(new Address(address));
        return user;
    }
}

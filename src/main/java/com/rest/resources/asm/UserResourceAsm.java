package com.rest.resources.asm;

import com.core.entity.User;
import com.rest.resources.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAsm extends ResourceAssemblerSupport<User, UserResource> {


    public UserResourceAsm(Class<?> controllerClass, Class<UserResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public UserResource toResource(User user) {
        return null;
    }
}

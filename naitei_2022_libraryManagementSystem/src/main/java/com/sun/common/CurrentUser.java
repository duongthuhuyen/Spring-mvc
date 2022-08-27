package com.sun.common;

import com.sun.entity.User;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentUser {
    public static User currentUser = null;
}

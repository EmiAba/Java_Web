package com.bonappetit.service;

import com.bonappetit.model.dto.UserLoginBindingModel;
import com.bonappetit.model.dto.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}

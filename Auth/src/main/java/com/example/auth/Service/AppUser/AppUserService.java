package com.example.auth.Service.AppUser;

import com.example.auth.Model.AppUser.AppUser;

public interface AppUserService {

    AppUser saveUser(AppUser user);
    AppUser getUser(String username);
}

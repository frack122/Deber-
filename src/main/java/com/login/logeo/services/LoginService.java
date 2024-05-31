package com.login.logeo.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {

    /*Obtenemos los datos del usuario*/

    Optional <String> getUserName(HttpServletRequest request);

}

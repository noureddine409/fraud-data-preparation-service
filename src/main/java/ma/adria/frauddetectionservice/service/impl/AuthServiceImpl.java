package ma.adria.frauddetectionservice.service.impl;

import ma.adria.frauddetectionservice.model.Authentification;
import ma.adria.frauddetectionservice.repository.AuthRepository;
import ma.adria.frauddetectionservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository authRepository;



}

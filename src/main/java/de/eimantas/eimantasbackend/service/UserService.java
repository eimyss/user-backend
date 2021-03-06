package de.eimantas.eimantasbackend.service;

import de.eimantas.eimantasbackend.entities.User;
import de.eimantas.eimantasbackend.entities.converter.EntitiesConverter;
import de.eimantas.eimantasbackend.repo.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;


@Service
public class UserService {

  @Inject
  SecurityService securityService;
  @Inject
  UserRepository userRepository;


  @Inject
  EntitiesConverter converter;

  private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


  public User getUserFromID(String keycloackId) {
    logger.info("getting user convert for id: " + keycloackId);
    return userRepository.findByKeycloackId(keycloackId);

  }

  public User saveUser(User usr) {

    logger.info("saaving user: " + usr.toString());
    usr.setJoindate(LocalDate.now());
    return userRepository.save(usr);

  }
}

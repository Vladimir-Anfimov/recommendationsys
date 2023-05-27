package org.recsys.repositories;

import org.recsys.infrastucture.entities.Session;
import org.recsys.infrastucture.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>{
    boolean existsByToken(String token);
    User findByToken(String token);
}

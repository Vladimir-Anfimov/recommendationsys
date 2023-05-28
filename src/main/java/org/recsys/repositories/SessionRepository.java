package org.recsys.repositories;

import org.recsys.infrastucture.entities.Session;
import org.recsys.infrastucture.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, Long>{
    boolean existsByToken(String token);

    @Query("SELECT s.user FROM Session s WHERE s.token = :token")
    User findByToken(String token);
}

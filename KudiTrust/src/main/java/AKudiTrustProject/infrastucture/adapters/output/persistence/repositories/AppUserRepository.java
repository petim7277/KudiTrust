package AKudiTrustProject.infrastucture.adapters.output.persistence.repositories;

import AKudiTrustProject.domain.models.AppUserDomainObject;
import AKudiTrustProject.infrastucture.adapters.output.persistence.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity,Long> {
    Optional<AppUserEntity> findAppUsersByUsername(String username);
    Optional<AppUserEntity> findAppUsersByEmail(String email);

//    practising how to write jpa repository methods using  different kinds of  queries
    @Query("SELECT user from AppUserEntity user where user.firstname=?1 and user.lastname=?2")
    Optional<AppUserEntity> findAppUsersByFirstnameAndLastname(String username, String lastname); //Java persistence  query language

    @Query(value = "select * from AppUserEntity where firstname=?1",nativeQuery = true)
    Optional<AppUserEntity> findAppUsersByFirstname(String firstname); // Native  SQL query

    List<AppUserEntity> findAppUserEntitiesByPassword(@Param("password") String password); //Named Queries

}

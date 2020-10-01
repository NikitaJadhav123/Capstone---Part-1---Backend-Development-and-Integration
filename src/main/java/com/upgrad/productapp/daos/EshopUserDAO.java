package com.upgrad.productapp.daos;

import com.upgrad.productapp.entities.EshopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("eshopUserDAO")
public interface EshopUserDAO extends JpaRepository<EshopUser,Integer> {

    Optional<EshopUser> findByEmail(String emailId);

    Optional<EshopUser> findById(int id);
    Optional<EshopUser> findByPassword(String password);
    Optional<EshopUser> findByUserName(String usernm);
  //  Optional<Users> findByEmailIdandPassword(String emailId,String password);
}

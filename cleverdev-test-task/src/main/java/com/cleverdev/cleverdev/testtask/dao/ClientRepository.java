package com.cleverdev.cleverdev.testtask.dao;

import com.cleverdev.cleverdev.testtask.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}

package com.cleverdev.cleverdev.ld.lient.dao;

import com.cleverdev.cleverdev.ld.lient.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}

package com.back.backend.repository;

import com.back.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface  ClientRepository extends JpaRepository<Client,Long> {

}
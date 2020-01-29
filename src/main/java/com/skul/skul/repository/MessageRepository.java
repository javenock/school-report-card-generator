package com.skul.skul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skul.skul.model.Message;


/**
 * @author javenock
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
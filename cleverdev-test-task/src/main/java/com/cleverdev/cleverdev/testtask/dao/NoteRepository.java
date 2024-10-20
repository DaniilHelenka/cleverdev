package com.cleverdev.cleverdev.testtask.dao;

import com.cleverdev.cleverdev.testtask.entity.Client;
import com.cleverdev.cleverdev.testtask.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
}

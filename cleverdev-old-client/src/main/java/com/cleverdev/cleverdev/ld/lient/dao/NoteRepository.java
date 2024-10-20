package com.cleverdev.cleverdev.ld.lient.dao;

import com.cleverdev.cleverdev.ld.lient.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, String> {
    List<Note> findByClientGuidAndAgency(String clientGuid, String agency);
}

package com.cleverdev.cleverdev.testtask.service;

import com.cleverdev.cleverdev.testtask.entity.Client;
import com.cleverdev.cleverdev.testtask.entity.Note;

import java.util.List;

public interface OldSystemClient {

    List<Client> getClients();
    List<Note> getNotes(String clientGuid, String agency);
}

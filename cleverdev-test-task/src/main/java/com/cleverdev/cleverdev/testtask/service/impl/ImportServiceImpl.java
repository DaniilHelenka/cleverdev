package com.cleverdev.cleverdev.testtask.service.impl;

import com.cleverdev.cleverdev.testtask.dao.ClientRepository;
import com.cleverdev.cleverdev.testtask.dao.NoteRepository;
import com.cleverdev.cleverdev.testtask.entity.Client;
import com.cleverdev.cleverdev.testtask.entity.Note;
import com.cleverdev.cleverdev.testtask.service.ImportService;
import com.cleverdev.cleverdev.testtask.service.OldSystemClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {

    private final OldSystemClient oldSystemClient;
    private final ClientRepository clientRepository;
    private final NoteRepository noteRepository;

    @Override
    @Transactional
    public void importData() {
        List<Client> clients = oldSystemClient.getClients();
        if (clients != null) {
            for (Client client : clients) {
                Client savedClient = clientRepository.save(client);
                log.info("saved Note data: {}", savedClient);
                List<Note> notes = oldSystemClient.getNotes(client.getGuid(), client.getAgency());
                if (notes != null) {
                    for (Note note : notes) {
                        Note savedNote = noteRepository.save(note);
                        log.info("saved Note data: {}", savedNote);
                    }
                }
            }
        }
    }
}

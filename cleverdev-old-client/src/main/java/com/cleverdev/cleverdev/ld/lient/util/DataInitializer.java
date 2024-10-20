package com.cleverdev.cleverdev.ld.lient.util;

import com.cleverdev.cleverdev.ld.lient.dao.ClientRepository;
import com.cleverdev.cleverdev.ld.lient.dao.NoteRepository;
import com.cleverdev.cleverdev.ld.lient.entity.Client;
import com.cleverdev.cleverdev.ld.lient.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ClientRepository clientRepository;

    private final NoteRepository noteRepository;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i <= 100; i++) {
            Client client = new Client();
            client.setGuid(UUID.randomUUID().toString());
            client.setAgency("agency" + i);
            client.setFirstName("FirstName" + i);
            client.setLastName("LastName" + i);
            client.setStatus("ACTIVE");
            client.setDob("01-01-2000");
            client.setCreatedDateTime("2021-11-15 11:51:59");

            clientRepository.save(client);

            for (int j = 1; j <= 15; j++) {
                Note note = new Note();
                note.setClientGuid(client.getGuid());
                note.setAgency(client.getAgency());
                note.setNoteText("This is note " + j + " for client " + i);
                note.setCreatedDateTime("2021-11-15 12:00:00");

                noteRepository.save(note);
            }
        }
    }
}

package com.cleverdev.cleverdev.testtask;

import com.cleverdev.cleverdev.testtask.dao.ClientRepository;
import com.cleverdev.cleverdev.testtask.dao.NoteRepository;
import com.cleverdev.cleverdev.testtask.entity.Client;
import com.cleverdev.cleverdev.testtask.entity.Note;
import com.cleverdev.cleverdev.testtask.service.OldSystemClient;
import com.cleverdev.cleverdev.testtask.service.impl.ImportServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImportServiceTest {

    @InjectMocks
    private ImportServiceImpl importService;

    @Mock
    private OldSystemClient oldSystemClient;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private NoteRepository noteRepository;

    @Test
    public void checkImportDataShouldWorkCorrect() {
        Client client = new Client();
        client.setGuid("test-guid");
        client.setAgency("test-agency");

        Note note = new Note();
        note.setClientGuid("test-guid");
        note.setAgency("test-agency");

        when(oldSystemClient.getClients()).thenReturn(Collections.singletonList(client));
        when(oldSystemClient.getNotes("test-guid", "test-agency")).thenReturn(Collections.singletonList(note));

        importService.importData();

        Mockito.verify(clientRepository).save(client);
        Mockito.verify(noteRepository).save(note);
    }
}

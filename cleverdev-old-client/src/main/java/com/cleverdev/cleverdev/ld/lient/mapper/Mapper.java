package com.cleverdev.cleverdev.ld.lient.mapper;

import com.cleverdev.cleverdev.ld.lient.dto.ClientDto;
import com.cleverdev.cleverdev.ld.lient.dto.NoteDto;
import com.cleverdev.cleverdev.ld.lient.entity.Client;
import com.cleverdev.cleverdev.ld.lient.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ClientDto clientToClientDto(Client client) {
        return ClientDto.builder()
                .dob(client.getDob())
                .agency(client.getAgency())
                .createdDateTime(client.getCreatedDateTime())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .guid(client.getGuid())
                .status(client.getStatus())
                .build();
    }

    public Client clientDtoToClient(ClientDto client) {
        return Client.builder()
                .dob(client.getDob())
                .agency(client.getAgency())
                .createdDateTime(client.getCreatedDateTime())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .guid(client.getGuid())
                .status(client.getStatus())
                .build();
    }

    public NoteDto noteToNoteDto(Note note){
        return NoteDto.builder()
                .agency(note.getAgency())
                .id(note.getId())
                .clientGuid(note.getClientGuid())
                .createdDateTime(note.getCreatedDateTime())
                .noteText(note.getNoteText())
                .build();
    }

    public Note noteDtoToNote(NoteDto note){
        return Note.builder()
                .agency(note.getAgency())
                .id(note.getId())
                .clientGuid(note.getClientGuid())
                .createdDateTime(note.getCreatedDateTime())
                .noteText(note.getNoteText())
                .build();
    }
}

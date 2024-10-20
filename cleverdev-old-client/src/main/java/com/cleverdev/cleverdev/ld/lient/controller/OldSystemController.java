package com.cleverdev.cleverdev.ld.lient.controller;

import com.cleverdev.cleverdev.ld.lient.dto.ClientDto;
import com.cleverdev.cleverdev.ld.lient.dto.NoteDto;
import com.cleverdev.cleverdev.ld.lient.service.ClientService;
import com.cleverdev.cleverdev.ld.lient.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OldSystemController {

    private final ClientService clientService;
    private final NoteService noteService;

    @PostMapping("/clients")
    public List<ClientDto> getAllClients() {
        return clientService.findAll();
    }

    @PostMapping("/notes")
    public List<NoteDto> getNotes(@RequestParam String clientGuid, @RequestParam String agency) {
        return noteService.findByClientGuidAndAgency(clientGuid, agency);
    }
}

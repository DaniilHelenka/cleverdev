package com.cleverdev.cleverdev.ld.lient.service.impl;

import com.cleverdev.cleverdev.ld.lient.dao.ClientRepository;
import com.cleverdev.cleverdev.ld.lient.dao.NoteRepository;
import com.cleverdev.cleverdev.ld.lient.dto.ClientDto;
import com.cleverdev.cleverdev.ld.lient.dto.NoteDto;
import com.cleverdev.cleverdev.ld.lient.mapper.Mapper;
import com.cleverdev.cleverdev.ld.lient.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final Mapper mapper;

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::clientToClientDto)
                .collect(Collectors.toList());
    }
}

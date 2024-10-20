package com.cleverdev.cleverdev.ld.lient.service.impl;

import com.cleverdev.cleverdev.ld.lient.dao.NoteRepository;
import com.cleverdev.cleverdev.ld.lient.dto.NoteDto;
import com.cleverdev.cleverdev.ld.lient.mapper.Mapper;
import com.cleverdev.cleverdev.ld.lient.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final Mapper mapper;

    @Override
    public List<NoteDto> findByClientGuidAndAgency(String clientGuid, String agency) {
        return noteRepository.findByClientGuidAndAgency(clientGuid, agency)
                .stream()
                .map(mapper::noteToNoteDto)
                .collect(Collectors.toList());
    }
}

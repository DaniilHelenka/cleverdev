package com.cleverdev.cleverdev.testtask.service.impl;

import com.cleverdev.cleverdev.testtask.entity.Client;
import com.cleverdev.cleverdev.testtask.entity.Note;
import com.cleverdev.cleverdev.testtask.service.OldSystemClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OldSystemClientImpl implements OldSystemClient {

    private final RestTemplate restTemplate;

    @Override
    public List<Client> getClients() {
        String url = "http://cleverdev-old-client:8083/api/clients";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Client>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<List<Client>>() {
                    }
            );
            log.info("Clients Response: {}", response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Note> getNotes(String clientGuid, String agency) {
        String url = "http://cleverdev-old-client:8083/api/notes?clientGuid=" + clientGuid + "&agency=" + agency;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<List<Note>> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<List<Note>>() {
                    }
            );
            log.info("Notes Response: {}", response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            e.printStackTrace();
            return null;
        }
    }
}

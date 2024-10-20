package com.cleverdev.cleverdev.ld.lient.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private String guid;
    private String agency;
    private String firstName;
    private String lastName;
    private String status;
    private String dob;
    private String createdDateTime;
}

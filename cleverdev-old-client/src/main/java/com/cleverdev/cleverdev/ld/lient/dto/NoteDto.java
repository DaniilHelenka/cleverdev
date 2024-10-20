package com.cleverdev.cleverdev.ld.lient.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private Long id;
    private String clientGuid;
    private String agency;
    private String noteText;
    private String createdDateTime;
}

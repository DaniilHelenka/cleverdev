package com.cleverdev.cleverdev.testtask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@Table(name = "notes")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientGuid;
    private String agency;
    private String noteText;
    private String createdDateTime;
}

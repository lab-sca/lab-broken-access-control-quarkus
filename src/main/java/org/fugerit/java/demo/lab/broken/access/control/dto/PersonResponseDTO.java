package org.fugerit.java.demo.lab.broken.access.control.dto;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Risposta del servizio che ritorna persone")
public class PersonResponseDTO {

    @Schema(description = "il nome della persona", examples = { "MARIE" }, required = true)
    private String firstName;

    @Schema(description = "il cognome della persona", examples = { "CURIE" }, required = true)
    private String lastName;

    @Schema(description = "il titolo della persona", examples = { "Fisica" }, required = true)
    private String title;

    @Schema(description = "il nome della persona", examples = { "guest" })
    private String minRole;

    @Schema(description = "ID della persona inserita")
    private Long id;

    @Schema(description = "Data di inserimento della persona")
    private LocalDateTime creationDate;

}

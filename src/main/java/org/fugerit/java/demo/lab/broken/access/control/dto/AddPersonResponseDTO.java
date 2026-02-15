package org.fugerit.java.demo.lab.broken.access.control.dto;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Richiesta del servizio di aggiunta di una persona")
public class AddPersonResponseDTO {

    @Schema(description = "ID della persona inserita")
    private Long id;

    @Schema(description = "Data di inserimento della persona")
    private LocalDateTime creationDate;

}

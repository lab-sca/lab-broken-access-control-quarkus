package org.fugerit.java.demo.lab.broken.access.control.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(description = "Richiesta per il servizio di aggiunta di una persona")
public class AddPersonRequestDTO {

    private static final String NAME_PATTERN = "^[\\p{L}\\s-]+$";
    private static final String NAME_MESSAGE = "Può contenere solo lettere, spazi e trattini";

    @NotBlank(message = "Il nome è obbligatorio")
    @Size(max = 512, message = "Il nome non può superare i 512 caratteri")
    @Pattern(regexp = NAME_PATTERN, message = "Il nome: " + NAME_MESSAGE) // ← MANCAVA QUESTA!
    @Schema(description = "il nome della persona", examples = { "MARIE" }, required = true)
    private String firstName;

    @NotBlank(message = "Il cognome è obbligatorio")
    @Size(max = 512, message = "Il cognome non può superare i 512 caratteri")
    @Pattern(regexp = NAME_PATTERN, message = "Il cognome: " + NAME_MESSAGE) // ← MANCAVA QUESTA!
    @Schema(description = "il cognome della persona", examples = { "CURIE" }, required = true)
    private String lastName;

    @NotBlank(message = "Il titolo è obbligatorio")
    @Size(max = 512, message = "Il titolo non può superare i 512 caratteri")
    @Pattern(regexp = NAME_PATTERN, message = "Il titolo: " + NAME_MESSAGE) // ← MANCAVA QUESTA!
    @Schema(description = "il titolo della persona", examples = { "Fisica" }, required = true)
    private String title;

    @Size(max = 32, message = "Il ruolo minimo non può superare i 32 caratteri")
    @Pattern(regexp = "^(admin|user|guest)?$", message = "Il ruolo minimo deve essere: admin, user, guest oppure vuoto")
    @Schema(description = "il ruolo minimo richiesto per visualizzare la persona", examples = { "guest" })
    private String minRole;

}
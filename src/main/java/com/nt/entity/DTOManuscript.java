package com.nt.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOManuscript {

    @NotBlank(message = "Manuscript title cannot be blank")
    @Size(min = 5, max = 255)
    private String title;

    @NotBlank
    @Size(min = 2, max = 100)
    private String journalName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String authorName;

    @NotNull
    @PastOrPresent
    private LocalDate submissionDate;
}

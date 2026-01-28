package com.nt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manuscripts")
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Manuscript title cannot be blank")
    @Size(min = 5, max = 255, message = "Title must be between 5 and 255 characters")
    private String title;

    @NotBlank(message = "Journal name cannot be blank")
    @Size(min = 2, max = 100, message = "Journal name must be between 2 and 100 characters")
    private String journalName;

    @NotBlank(message = "Author name cannot be blank")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters")
    private String authorName;

    @NotNull(message = "Submission date cannot be null")
    @PastOrPresent(message = "Submission date cannot be in the future")
    private LocalDate submissionDate;

    @Enumerated(EnumType.STRING)
    private ManuscriptStatus status = ManuscriptStatus.SUBMITTED;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;



    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull(message = "Publisher cannot be null")
    private Publisher publisher;
}


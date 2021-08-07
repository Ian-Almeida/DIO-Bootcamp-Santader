package com.dio.controlepontoacesso.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserCategory userCategory;
    private String username;
    @ManyToOne
    private Company company;
    @ManyToOne
    private AccessLevel accessLevel;
    @ManyToOne
    private WorkTime workTime;
    private BigDecimal tolerance;
    private LocalDateTime journeyStart;
    private LocalDateTime journeyEnd;
}

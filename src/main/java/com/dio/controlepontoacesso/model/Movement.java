package com.dio.controlepontoacesso.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

//    @AllArgsConstructor
//    @NoArgsConstructor
//    @EqualsAndHashCode
//    @Embeddable
//    public static class MovementId implements Serializable {
//        @GeneratedValue(strategy= GenerationType.IDENTITY)
//        private Long idMovement;
//        private Long idUser;
//    }
//
//    @EmbeddedId
//    private MovementId id;

    private LocalDateTime entryDate;
    private LocalDateTime outDate;
    private BigDecimal period;
    @OneToOne
    private Occurrence occurrence;
    @OneToOne
    private Calendar calendar;
}

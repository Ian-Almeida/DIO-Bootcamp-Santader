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
//@IdClass(AnnualLeave.PKs.class)
public class AnnualLeave {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "movement_id", referencedColumnName = "id")
    private Movement movementId;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

//    static class PKs implements Serializable{
//        Long id;
//        Long idMovement;
//        Long idUser;
//    }

//    @AllArgsConstructor
//    @NoArgsConstructor
//    @EqualsAndHashCode
//    @Embeddable
//    public static class AnnualLeaveId implements Serializable {
//        private Long idAnnualLeave;
//        private Long idMovement;
//        private Long idUser;
//    }

//    @EmbeddedId
//    private AnnualLeaveId id;
    @ManyToOne
    private UserCategory userCategory;
    private LocalDateTime workedDate;
    private BigDecimal workedTime;
    private BigDecimal hoursBalance;
}

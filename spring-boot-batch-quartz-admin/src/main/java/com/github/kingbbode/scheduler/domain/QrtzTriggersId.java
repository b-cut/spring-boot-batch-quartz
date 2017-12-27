package com.github.kingbbode.scheduler.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzTriggersId generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class QrtzTriggersId  implements java.io.Serializable {

    @Column(name="SCHED_NAME", nullable=false, length=120)
    private String schedName;

    @Column(name="TRIGGER_NAME", nullable=false, length=200)
    private String triggerName;

    @Column(name="TRIGGER_GROUP", nullable=false, length=200)
    private String triggerGroup;

}



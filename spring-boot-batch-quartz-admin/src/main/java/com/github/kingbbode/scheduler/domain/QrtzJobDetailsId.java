package com.github.kingbbode.scheduler.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzJobDetailsId generated by hbm2java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class QrtzJobDetailsId  implements java.io.Serializable {

    @Column(name="SCHED_NAME", nullable=false, length=120)
    private String schedName;

    @Column(name="JOB_NAME", nullable=false, length=200)
    private String jobName;

    @Column(name="JOB_GROUP", nullable=false, length=200)
    private String jobGroup;

}



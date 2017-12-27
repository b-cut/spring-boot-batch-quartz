package com.github.kingbbode.scheduler.domain;

import com.github.kingbbode.scheduler.dto.SchedulerResponse;
import com.github.kingbbode.scheduler.utils.JobDataMapConverter;
import lombok.Getter;
import lombok.Setter;
import org.quartz.JobDataMap;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * QrtzJobDetails generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name="QRTZ_JOB_DETAILS")
public class QrtzJobDetails  implements java.io.Serializable {
    
    @EmbeddedId
    private QrtzJobDetailsId id;

    @Column(name="DESCRIPTION", length=250)
    private String description;

    @Column(name="JOB_CLASS_NAME", nullable=false, length=250)
    private String jobClassName;

    @Column(name="IS_DURABLE", nullable=false, length=1)
    private String isDurable;

    @Column(name="IS_NONCONCURRENT", nullable=false, length=1)
    private String isNonconcurrent;

    @Column(name="IS_UPDATE_DATA", nullable=false, length=1)
    private String isUpdateData;

    @Column(name="REQUESTS_RECOVERY", nullable=false, length=1)
    private String requestsRecovery;

    @Column(name="JOB_DATA")
    private JobDataMap jobData;

    @OneToMany
    @JoinColumns( {
            @JoinColumn(name="SCHED_NAME", referencedColumnName="SCHED_NAME", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="JOB_NAME", referencedColumnName="JOB_NAME", nullable=false, insertable=false, updatable=false),
            @JoinColumn(name="JOB_GROUP", referencedColumnName="JOB_GROUP", nullable=false, insertable=false, updatable=false) } )
    private Set<QrtzTriggers> qrtzTriggerses;

    public SchedulerResponse toSchedulerResponse() {
        String[] SchedulerName = this.id.getSchedName().split("_");
        String[] jobName = this.id.getJobName().split("_");
        return SchedulerResponse.builder()
                .name(SchedulerName[0])
                .version(SchedulerName.length < 2 ? "undefined" : SchedulerName[1])
                .jobName(jobName[jobName.length-1])
                .build();
    }
    
    @SuppressWarnings("unchecked")
    public SchedulerResponse toSchedulerDetailResponse() {
        String[] SchedulerName = this.id.getSchedName().split("_");
        String[] jobName = this.id.getJobName().split("_");
        return SchedulerResponse.builder()
                .name(SchedulerName[0])
                .version(SchedulerName.length < 2 ? "undefined" : SchedulerName[1])
                .jobName(jobName[jobName.length-1])
                .cronTriggerList(
                        qrtzTriggerses.stream().filter(QrtzTriggers::isCronType)
                            .map(QrtzTriggers::getQrtzCronTriggers)
                            .map(QrtzCronTriggers::toCronTriggerResponse)
                            .collect(Collectors.toList())
                        )
                .params(JobDataMapConverter.convertJobDataToDefaultMap(this.jobData))
                .build();
    }
}


package com.github.kingbbode.scheduler.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * QrtzSimpropTriggers generated by hbm2java
 */
@Getter
@Setter
@Entity
@Table(name="QRTZ_SIMPROP_TRIGGERS")
public class QrtzSimpropTriggers  implements java.io.Serializable {

    @EmbeddedId
    private QrtzTriggersId id;

    @Column(name="STR_PROP_1", length=512)
    private String strProp1;

    @Column(name="STR_PROP_2", length=512)
    private String strProp2;

    @Column(name="STR_PROP_3", length=512)
    private String strProp3;

    @Column(name="INT_PROP_1")
    private Integer intProp1;

    @Column(name="INT_PROP_2")
    private Integer intProp2;

    @Column(name="LONG_PROP_1")
    private Long longProp1;

    @Column(name="LONG_PROP_2")
    private Long longProp2;

    @Column(name="DEC_PROP_1", precision=13, scale=4)
    private BigDecimal decProp1;

    @Column(name="DEC_PROP_2", precision=13, scale=4)
    private BigDecimal decProp2;

    @Column(name="BOOL_PROP_1", length=1)
    private String boolProp1;

    @Column(name="BOOL_PROP_2", length=1)
    private String boolProp2;
}



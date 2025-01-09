package com.spds.fps.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

@Data
@Entity
@Table(schema = "fps", name = "fps_address")
@NoArgsConstructor
public class FpsAddress extends Auditable implements Serializable {

    private static final long serialVersionUID = 3064947814879237357L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fps_address_seq_id")
    @SequenceGenerator(name = "fps_address_seq_id", sequenceName = "fps_address_seq_id", schema = "fps", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "perm_location_code_plc_code")
    private Long permLocationCodePlcCode;

    @Column(name = "tehsil_block_codes_tehsil_code")
    private String tehsilBlockCodesTehsilCode;

    @Column(name = "house_no_ll")
    private String houseNoLl;

    @Column(name = "house_no_en")
    private String houseNoEn;

    @Column(name = "landmark_ll")
    private String landmarkLl;

    @Column(name = "landmark_en")
    private String landmarkEn;

    @Column(name = "pin_pal")
    private Long pinPal;

    @Column(name = "version")
    private Long version;

    @Column(name = "address_type_id")
    private Long addressTypeId;

    @Column(name = "plot_no")
    private String plotNo;

    @Column(name = "khata_no")
    private String khataNo;

    @Column(name = "mouza")
    private String mouza;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "east_boundary")
    private String eastBoundary;

    @Column(name = "west_boundary")
    private String westBoundary;

    @Column(name = "north_boundary")
    private String northBoundary;

    @Column(name = "south_boundary")
    private String southBoundary;

    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "tahsil_id")
    private Long tahsilId;

    @Column(name = "fps_id")
    private Long fpsId;
}

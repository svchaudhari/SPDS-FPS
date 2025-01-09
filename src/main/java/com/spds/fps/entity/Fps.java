package com.spds.fps.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

@Data
@Entity
@Table(schema = "fps", name = "fps")
@NoArgsConstructor
public class Fps extends Auditable implements Serializable {

    private static final long serialVersionUID = 1626227746755001727L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fps_seq_id")
    @SequenceGenerator(name = "fps_seq_id", sequenceName = "fps_seq_id", schema = "fps", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "reservation_category_rcat_code")
    private Long reservationCategoryRcatCode;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "license_valid_from")
    private LocalDateTime licenseValidFrom;

    @Column(name = "license_valid_upto")
    private LocalDateTime licenseValidUpto;

    @Column(name = "rc_nos")
    private Long rcNos;

    @Column(name = "owner_age")
    private Long ownerAge;

    @Column(name = "owner_gender")
    private Long owner_gender;

    @Column(name = "license_category")
    private Long licenseCategory;

    @Column(name = "application_id")
    private Long applicationId;

    @Column(name = "owner_name_ll")
    private String ownerNameLl;

    @Column(name = "owner_name_en")
    private String ownerNameEn;

    @Column(name = "owner_location")
    private String ownerLocation;

    @Column(name = "caste_category_code")
    private Long casteCategoryCode;

    @Column(name = "owner_education")
    private Long ownerEducation;

    @Column(name = "shop_type")
    private String shopType;

    @Column(name = "shop_no")
    private Long shopNo;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "fps_license_auth_no")
    private String fpsLicenseAuthNo;

    @Column(name = "fps_name_ll")
    private String fpsNameLl;

    @Column(name = "fps_name_en")
    private String fpsNameEn;

    @Column(name = "father_name_en")
    private String fatherNameEn;

    @Column(name = "father_name_ll")
    private String fatherNameLl;

    @Column(name = "mother_name_ll")
    private String motherNameLl;

    @Column(name = "mother_name_en")
    private String motherNameEn;

    @Column(name = "income_tax_amt_paid")
    private String incomeTaxAmtPaid;

    @Column(name = "license_issue_date")
    private LocalDateTime licenseIssueDate;

    @Column(name = "dist_name_en")
    private String distNameEn;

    @Column(name = "annual_income")
    private Long annualIncome;

    @Column(name = "fps_status")
    private String fpsStatus;

    @Column(name = "pan_card_no")
    private String panCardNo;

    @Column(name = "license_type")
    private String licenseType;

    @Column(name = "old_license_no")
    private String oldLicenseNo;

    @Column(name = "designation")
    private String designation;

    @Column(name = "income_tax_paid_id")
    private Long incomeTaxPaidId;

    @Column(name = "occupation_code")
    private Long occupationCode;

    @Column(name = "building_id")
    private Long buildingId;

    @Column(name = "ownership_of_premises_id")
    private Long ownershipOfPremisesId;

    @Column(name = "roofing_id")
    private Long roofingId;

    @Column(name = "insp_code")
    private String inspCode;

    @Column(name = "fps_type")
    private String fpsType;

    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "zone_id")
    private Long zoneId;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "village_id")
    private Long villageId;

    @Column(name = "depot_id")
    private String depotId;

    @Column(name = "office_id")
    private String officeId;

/*
    @Column(name = "la_code")
    private String laCode;

    @Column(name = "va_code")
    private String vaCode;

    @Column(name = "lv_date")
    private LocalDateTime lvDate;

    @Column(name = "stt_no")
    private Long sttNo;

    @Column(name = "sc_no")
    private String scNo;

    @Column(name = "smartcard_no")
    private String smartcardNo;

    @Column(name = "loc_code")
    private Long locCode;

    @Column(name = "fps_id")
    private String fpsId;

    @Column(name = "compound_wall_id")
    private Long compoundWallId;

    @Column(name = "fps_codes_fps_codes")
    private Long fpsCodesFpsCodes;
*/

}

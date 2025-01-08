package com.spds.fps.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@Table(schema = "fps", name = "fps_document")  // database name
@NoArgsConstructor
public class FpsDocument extends Auditable implements Serializable {

    private static final long serialVersionUID = -276752107506010200L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fps_document_seq_id")
    @SequenceGenerator(name = "fps_document_seq_id", sequenceName = "fps_document_seq_id", schema = "fps", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "shop_no")
    private String shopNo;

    @Column(name = "d_authorization_certificate")
    private Long dAuthorizationCertificate;

    @Column(name = "d_rice_card_no")
    private String dRiceCardNo;

    @Column(name = "d_al_mobile_no")
    private String dAlMobileNo;

    @Column(name = "d_email_id")
    private String dEmailId;

    @Column(name = "d_aadhar_photo")
    private Long dAadharPhoto;

    @Column(name = "nominee_photo")
    private Long nomineePhoto;

    @Column(name = "nominee_relation")
    private String nomineeRelation;

    @Column(name = "nominee_mobile")
    private String nomineeMobile;

    @Column(name = "nominee_aadhar_photo")
    private Long nomineeAadharPhoto;

    @Column(name = "d_rice_mem_uid")
    private String dRiceMemUid;

    @Column(name = "f_door_no")
    private String fDoorNo;

    @Column(name = "f_village")
    private String fVillage;

    @Column(name = "f_landmark")
    private String fLandmark;

    @Column(name = "f_latitude")
    private String fLatitude;

    @Column(name = "f_longitude")
    private String fLongitude;

    @Column(name = "f_pincode")
    private String fPincode;

    @Column(name = "fps_photo")
    private Long fpsPhoto;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "license_valid_from")
    private LocalDateTime licenseValidFrom;

    @Column(name = "license_valid_upto")
    private LocalDateTime licenseValidUpto;

    @Column(name = "shop_type")
    private String shopType;

    @Column(name = "nom_1_uid")
    private String nom1Uid;

    @Column(name = "d_name")
    private String dName;

    @Column(name = "d_father_name")
    private String dFatherName;

    @Column(name = "d_aadhar_no")
    private String dAadharNo;

    @Column(name = "d_mobile_no")
    private String dMobileNo;

    @Column(name = "d_photo")
    private Long dPhoto;

    @Column(name = "d_gender")
    private Long dGender;

    @Column(name = "d_caste")
    private Long dCaste;

    @Column(name = "d_status_group")
    private String dStatusGroup;

    @Column(name = "fps_id")
    private Long fpsId;

    @Column(name = "fps_dealer_details_id")
    private Long fpsDealerDetailsId;
}

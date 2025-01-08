package com.spds.fps.entity;


import com.spds.fps.util.GeneralUtil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Entity
@Table(schema = "fps", name = "fps_dealer_details")  // database name
@NoArgsConstructor
public class FpsDealerDetails extends Auditable implements Serializable {

    private static final long serialVersionUID = -5055873154781371418L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fps_dealer_details_seq_id")
    @SequenceGenerator(name = "fps_dealer_details_seq_id", sequenceName = "fps_dealer_details_seq_id", schema = "fps", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "shop_no")
    private String shopNo = GeneralUtil.generateRandomString(); //  autogenerate sequence

    @Column(name = "del_uid")
    private String delUid;

    @Column(name = "del_name")
    private String delName;

    @Column(name = "del_mob")
    private String delMob;

    @Column(name = "del_bfd_1")
    private String delBfd1;

    @Column(name = "del_bfd_2")
    private String delBfd2;

    @Column(name = "del_bfd_3")
    private String delBfd3;

    @Column(name = "nom_1_uid")
    private String nom1Uid;

    @Column(name = "nom_1_name")
    private String nom1Name;

    @Column(name = "nom_1_mob")
    private String nom1Mob;

    @Column(name = "nom_1_bfd_1")
    private String nom1Bfd1;

    @Column(name = "nom_1_bfd_2")
    private String nom1Bfd2;

    @Column(name = "nom_1_bfd_3")
    private String nom1Bfd3;

    @Column(name = "nom_2_uid")
    private String nom2Uid;

    @Column(name = "nom_2_name")
    private String nom2Name;

    @Column(name = "nom_2_mob")
    private String nom2Mob;

    @Column(name = "nom_2_bfd_1")
    private String nom2Bfd1;

    @Column(name = "nom_2_bfd_2")
    private String nom2Bfd2;

    @Column(name = "nom_2_bfd_3")
    private String nom2Bfd3;

    @Column(name = "demo_status")
    private String demoStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private String status;

    @Column(name = "fps_id")
    private Long fpsId;
/*
    @Column(name = "dealer_mapping_id")
    private Long dealerMappingId;

    @Column(name = "nominee_1_mapping_id")
    private Long nominee1MappingId;

    @Column(name = "nominee_2_mapping_id")
    private Long nominee2MappingId;

 */
}

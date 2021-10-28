package com.rizalpurnama.managementarisan.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
public class Arisan {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Size(max = 36)
    private String id;

    @Column(length = 10, nullable = false)
    @NotBlank
    private String kode;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    @NotNull
    private LocalDateTime tanggalAmbil;

    @Min(0) @NotNull
    private long nominalAmbil;

    @NotNull
    private LocalDateTime tanggalDapat;

    @Min(0) @NotNull
    private long nominalDapat;

    private String keterangan;
}

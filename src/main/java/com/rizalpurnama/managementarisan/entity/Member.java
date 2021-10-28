package com.rizalpurnama.managementarisan.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Size(max = 36)
    private String id;

    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Arisan> listArisan;
}

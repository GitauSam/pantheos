package com.phosphor.jumiaex.adapters.ds.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "customer")
public class JpaCustomer implements Serializable {

    private static final long serialVersionUID = 4471777119419172870L;

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phoneNumber;
}

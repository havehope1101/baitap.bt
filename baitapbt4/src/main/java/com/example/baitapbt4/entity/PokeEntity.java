package com.example.baitapbt4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="pokemon")

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Data
public class PokeEntity {
    @Id
    @Column
    private Integer id;

    @Column
    private String Name;

    @Column
    private String Type1;

    @Column
    private String Type2;

    @Column
    private double Total;

    @Column
    private double HP;

    @Column
    private Double Attack;

    @Column
    private Double Defense;

    @Column
    private Double SpAtk;

    @Column
    private Double SpDef;

    @Column
    private int Speed;

    @Column
    private int Generation;

    @Column
    private String Legendary;


}

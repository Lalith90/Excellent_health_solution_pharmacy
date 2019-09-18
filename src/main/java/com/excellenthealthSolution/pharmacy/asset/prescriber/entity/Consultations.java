package com.excellenthealthSolution.pharmacy.asset.prescriber.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "consultations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Consultations {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false, length = 45)
    private String name;



}

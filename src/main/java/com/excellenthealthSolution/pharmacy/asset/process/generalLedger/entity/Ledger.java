package com.excellenthealthSolution.pharmacy.asset.process.generalLedger.entity;

import com.excellenthealthSolution.pharmacy.asset.item.entity.Item;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Integer availableQuantity;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private BigDecimal salePrice;

    @Column(nullable = false)
    private int reorderLimit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;

    private LocalDate updatedAt;

    private LocalDate createdAt;

}

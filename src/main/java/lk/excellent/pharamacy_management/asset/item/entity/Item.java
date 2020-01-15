package lk.excellent.pharamacy_management.asset.item.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.excellent.pharamacy_management.asset.commonAsset.Enum.Category;
import lk.excellent.pharamacy_management.asset.commonAsset.Enum.Status;
import lk.excellent.pharamacy_management.asset.commonAsset.entity.SupplierItem;
import lk.excellent.pharamacy_management.asset.process.finance.entity.InvoiceQuantity;
import lk.excellent.pharamacy_management.asset.process.generalLedger.entity.Ledger;
import lk.excellent.pharamacy_management.asset.process.goodReceivingManagement.entity.GrnQuantity;
import lk.excellent.pharamacy_management.asset.process.purchaseOrder.entity.ItemQuantity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@JsonFilter("Item")
public class Item {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "This code is already add or enter incorrectly")
    private String code;

    private String description;

    @NotNull
    private String generic;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal cost;

    private BigDecimal selling;

    private int soh;

    private int reorderLimit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;

    private LocalDate updatedAt;

    private LocalDate createdAt;

    @OneToMany(mappedBy = "item")
    private List<SupplierItem> supplierItems;

    @OneToMany(mappedBy = "item")
    private List<Ledger> ledgers;

    @OneToMany(mappedBy = "item")
    private List<GrnQuantity> grnQuantities;

    @OneToMany(mappedBy = "item")
    private List<ItemQuantity> itemQuantities;

    @OneToMany(mappedBy = "item")
    private List<InvoiceQuantity> invoiceQuantities;

    /*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "invoice_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    private List<Invoice> invoices;*/

    @Transient
    private int quantity;
}

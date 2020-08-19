package com.manhpd.unitofwork.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PmOrderItemPK {

    private static long serialVersionUID = 1L;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof PmOrderItemPK)) {
            return false;
        }

        PmOrderItemPK pmOrderItemPK = (PmOrderItemPK) other;
        return this.orderId == pmOrderItemPK.orderId
            && this.productId == pmOrderItemPK.productId;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;

        hash = hash * prime + this.orderId;
        hash = hash * prime + this.productId;

        return hash;
    }

}

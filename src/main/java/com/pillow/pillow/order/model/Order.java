package com.pillow.pillow.order.model;

import com.pillow.pillow.common.model.BaseModel;
import com.pillow.pillow.order.model.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatus status = OrderStatus.CREATED;

    @OneToMany(mappedBy = "order",orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addItem(OrderItem item){
        orderItems.add(item);
        item.assignOrder(this);
        calculatePrice();
    }

    public void removeItem(OrderItem item){
        orderItems.remove(item);
        item.assignOrder(null);
        calculatePrice();
    }

    public void calculatePrice(){
        this.totalAmount = orderItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public void updateStatus(OrderStatus status){
        if(this.status == OrderStatus.CANCELED){
            throw new IllegalStateException("Cannot update the canceled order");
        }
        this.status = status;
    }
}

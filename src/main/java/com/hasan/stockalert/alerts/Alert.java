package com.hasan.stockalert.alerts;

import com.hasan.stockalert.assets.AssetType;
import com.hasan.stockalert.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "alerts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_type")
    private AssetType assetType;

    @Column(name = "asset_symbol")
    private String assetSymbol;

    @Column(name = "alert_type")
    private String alertType;

    @Column(name = "alert_value")
    private Double alertValue;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_triggered")
    private Boolean isTriggered;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}

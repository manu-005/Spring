package com.xworkz.conference.entity.bannerEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceBannerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bannerId;

    private String bannerName;

    private String bannerType;
    private String bannerPath;
    private long bannerSize;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}

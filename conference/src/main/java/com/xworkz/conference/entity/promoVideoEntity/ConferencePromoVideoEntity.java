package com.xworkz.conference.entity.promoVideoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferencePromoVideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promoVideoId;

    private String promoVideoName;

    private String promoVideoType;
    private String promoVideoPath;
    private long promoVideoSize;

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

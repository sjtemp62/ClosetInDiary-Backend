package me.parkseongjong.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "outfit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "folder")
    private String folder;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Builder
    public Outfit(User user, String category, String folder, String description) {
        this.user = user;
        this.category = category;
        this.folder = folder;
        this.description = description;
    }
}
package com.example.blog.ortak;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    private Long id;

    @NotNull
    @CreatedDate
    private Calendar creationDate;
    @LastModifiedDate
    private Calendar lastUpdateDate;
    @NotNull
    @CreatedBy
    private String creatorName;
    @LastModifiedBy
    private String lastUpdaterName;
    @NotNull
    @Version
    private int revisionNumber;
    @Column(name = "is_active")
    private boolean isActive = true;

    public BaseEntity(Long id) {
        this.id = id;
    }

}
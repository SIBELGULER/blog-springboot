package com.example.blog.ortak;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
public abstract class BaseDTO implements Serializable {
    private Long id;
    private boolean isActive = true;
    private Calendar creationDate;

    public BaseDTO(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof com.example.blog.ortak.BaseDTO)) {
            return false;
        }
        com.example.blog.ortak.BaseDTO that = (com.example.blog.ortak.BaseDTO) o;
        return isActive == that.isActive &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive);
    }
}

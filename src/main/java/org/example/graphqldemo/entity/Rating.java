package org.example.graphqldemo.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {
    ONE_STAR("⭐"),
    TWO_STARS("⭐⭐"),
    THREE_STARS("⭐⭐⭐"),
    FOUR_STARS("⭐⭐⭐⭐"),
    FIVE_STARS("⭐⭐⭐⭐⭐");

    private String star;
    Rating(String star) {
        this.star = star;
    }
    @JsonValue
    public String getStar() {
        return star;
    }
}

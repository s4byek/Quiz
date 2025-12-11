package com.example.quiz.model;


public enum Category {
    SCIENCE("Наука"),
    HISTORY("История"),
    GEOGRAPHY("География"),
    LITERATURE("Литература"),
    SPORTS("Спорт"),
    ENTERTAINMENT("Развлечения");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}

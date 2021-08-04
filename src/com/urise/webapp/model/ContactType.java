package com.urise.webapp.model;

public enum ContactType {
    MOBILE_HONE("Мобильный телефон"),
    HOME_PHONE("Домашний телефон"),
    SKYPE("Skype"),
    MAIL("E-mail"),
    LINKEDIN("LinkedIn"),
    GITHUB("Github"),
    STACKOVERFLOW("Stackoverflow"),
    HOME_PAGE("Личная страничка");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

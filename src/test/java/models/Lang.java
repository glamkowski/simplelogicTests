package models;

public enum Lang {

    POLISH("PL"),
    ENGLISH("EN");

    String language;

    private Lang (String lang) {
        this.language = lang;
    }
}

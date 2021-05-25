package org.example.Word.model;

import java.io.Serializable;

public class WWord implements Serializable {
    private Long id;

    private String spell;

    private String meaningstr;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getMeaningstr() {
        return meaningstr;
    }

    public void setMeaningstr(String meaningstr) {
        this.meaningstr = meaningstr;
    }
}
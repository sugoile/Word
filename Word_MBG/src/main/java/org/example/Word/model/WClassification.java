package org.example.Word.model;

import java.io.Serializable;

public class WClassification implements Serializable {
    private Long id;

    private String classification;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
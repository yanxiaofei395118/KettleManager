package com.gdp.km.trans.bean;

public class RTransformationWithBLOBs extends RTransformation {
    private String description;

    private String extendedDescription;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription == null ? null : extendedDescription.trim();
    }
}
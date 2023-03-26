package com.challenge.challenge.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SpecialityEnum {

    DERMATOLOGY("Dermatology"),
    OPHTHALMOLOGY("Ophthalmology"),
    RADIOLOGY("Radiology"),
    FAMILY_MEDICINE("Family medicine"),
    PEDIATRICS("Pediatrics");

    private final String value;

    SpecialityEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public SpecialityEnum create(String name) {
        for (SpecialityEnum specialityEnum : SpecialityEnum.values()) {
            if (name.equalsIgnoreCase(specialityEnum.name())) {
                return specialityEnum;
            }
        }
        throw new IllegalArgumentException("Unknown Speciality");
    }
}

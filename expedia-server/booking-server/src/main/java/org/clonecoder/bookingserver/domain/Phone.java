package org.clonecoder.bookingserver.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Phone {
    private String phone;

    public Phone(String phone) {
        this.phone = phone;
    }
}

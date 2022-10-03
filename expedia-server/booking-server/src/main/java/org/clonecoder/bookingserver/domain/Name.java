package org.clonecoder.bookingserver.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Name {
    private String first;
    private String last;

    public Name(String guestLastName, String guestFirstName) {
        this.last = last;
        this.first = first;
    }
}
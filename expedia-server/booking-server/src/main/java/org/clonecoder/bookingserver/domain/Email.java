package org.clonecoder.bookingserver.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }
}

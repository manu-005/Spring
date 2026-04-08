package com.xworkz.conference.entity.tpoDelegates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitedDelegatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invitedDelegateId;

    private String delegateName;

    private String delegateEmail;

    private Long delegatesMobileNumber;

    private String delegatesOrganizationName;

    private boolean delegateAvailability;

    private Long conferenceId;

    private String tpoEmail;
}

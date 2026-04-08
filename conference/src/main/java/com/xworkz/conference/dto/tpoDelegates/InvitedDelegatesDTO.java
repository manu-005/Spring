package com.xworkz.conference.dto.tpoDelegates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitedDelegatesDTO {

    private Long invitedDelegateId;

    @NotBlank(message = "Please enter delegates full name")
    @Size(min = 4, max = 20, message = "Full Name size must be between 4 and 20")
    private String delegateName;

    @NotBlank(message = "Please enter delegates email")
    @Email(message = "Invalid email format")
    private String delegateEmail;

    @NotNull(message = "Mobile number is required")
    @Min(value = 6000000000L, message = "Number must start from 6 to 9")
    @Max(value = 9999999999L, message = "Invalid mobile number")
    private Long delegatesMobileNumber;

    @NotBlank(message = "Please enter delegates organization name")
    @Size(min = 4, max = 50, message = "Organization Name size must be between 4 and 50")
    private String delegatesOrganizationName;

    private boolean delegateAvailability;
}

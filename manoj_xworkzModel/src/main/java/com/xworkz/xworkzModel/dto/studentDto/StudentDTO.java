package com.xworkz.xworkzModel.dto.studentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int studentId;

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Mobile number is required")
    @Min(value = 6000000000L, message = "Number must start from 6 to 9")
    @Max(value = 9999999999L, message = "Invalid mobile number")
    private Long mobile;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NotBlank(message = "Course mode is required")
    private String courseMode;   // Online / Offline

    @NotNull(message = "Joining date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    private boolean active;

    // ✅ For receiving uploaded file from form
    @NotNull(message = "Profile image is required")
    private MultipartFile profileImage;

    // ✅ For storing image id in DB
    private String profileImageId;
}

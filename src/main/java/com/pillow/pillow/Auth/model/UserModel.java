package com.pillow.pillow.Auth.model;

import com.pillow.pillow.Auth.model.Enum.UserRole;
import com.pillow.pillow.Auth.model.Enum.UserStatus;
import com.pillow.pillow.common.Model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends BaseModel {

    @Id
    @GeneratedValue()
    @UuidGenerator
    private UUID id;

    @NotBlank
    private String name;

    @Column(name = "phone_number", unique = true)
    private String phone;

    @Column(nullable = false ,unique = true)
    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @NotBlank
    private String password;

}

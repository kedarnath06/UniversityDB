package com.JPA.JPA.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*As we dont want a new table as Guardian we dont create Guardian entity
So we have to embed the Guardia class with the Student class*/
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(
        name = "name",
        column = @Column(name = "guardian_name")
    ),
    @AttributeOverride(
        name = "email",
        column = @Column(name = "guardian_email")
    ),
    @AttributeOverride(
        name = "mobile",
        column = @Column(name = "guardian_mobile")
    )
})
public class Guardian {

  private String name;
  private String email;
  private String mobile;

}


package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("ADMIN")
@Getter @Setter @NoArgsConstructor
public class Admin extends User {

}

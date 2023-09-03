package com.eng.GRH.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@Table(name = "employees")
public class Employee {

    @Id()
    private String Matricule;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prénom")
    private String prenom;


    @Enumerated(EnumType.STRING)
    @Column(name="resourceType")
    private System type;   //NSR/SR(4/3)

    @Column(name = "Debut_ca/cr")
    private LocalDate debut_ca_cr;  //Debut de conjet (ca/cr)
    @Column(name = "Nombre_jours")
    private long nomb_j;  //Nombre des jours de conjet
    @Column(name = "Fin_ca/cr")
    private LocalDate fin_ca_cr;  //Date fin de conjet

    @Column(name = "Date_revise")
    private LocalDate date_rev;  //Date de revise
    @Column(name ="Date_prev" )
    private LocalDate date_prev;   //Date de previse
    @Column(name ="Fin_prev" )
    private LocalDate fin_prev;  //Date de fin de previse
    
    @Column(name = "Omcojet")
    private boolean onconjet;

    public Employee() {

    }


}

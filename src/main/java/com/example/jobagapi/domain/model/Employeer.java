package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employeers")
public class Employeer extends AuditModel{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;
        @OneToOne(mappedBy = "employeer")
        private User user;
        @NotNull
        public String posicion;


        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name ="company_profile_id",referencedColumnName = "id")
        private CompanyProfile companyProfile;

        public Employeer(){}


        public Long getId() {
                return id;
        }

        public Employeer setId(Long id) {
                this.id = id;
                return this;
        }

        public String getPosicion() {
                return posicion;
        }

        public Employeer setPosicion(String posicion) {
                this.posicion = posicion;
                return this;
        }


}

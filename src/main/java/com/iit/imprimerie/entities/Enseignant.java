package com.iit.imprimerie.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Enseignant implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String cin;
private String prenom;
private String nom;
private String adress;
private String email;
private String phone;
private String login;
private String password;
@JsonIgnore
@OneToMany(mappedBy = "ens",fetch=FetchType.LAZY)
private List<Matiere> lm;
@JsonIgnore
@OneToMany(mappedBy="ens" ,cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.LAZY)
private List<DemandeTirage> ld;
@ManyToOne
@JoinColumn(name = "id_dep",referencedColumnName="id_dep")
private Departement dep;
@JsonIgnore
@OneToMany(mappedBy = "ens",fetch=FetchType.LAZY)
private List<Document> ldoc;



}

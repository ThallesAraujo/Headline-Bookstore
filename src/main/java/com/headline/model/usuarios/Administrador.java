package com.headline.model.usuarios;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Administrador")
public class Administrador extends Usuario {	
	

}

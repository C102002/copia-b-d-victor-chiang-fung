select integ.primnom, hab.nombre
	from vah_integrantes integ, vah_habilidades hab, vah_int_hab i_h
		where (i_h.idIntegrante = integ.idIntegrante) and (i_h.idHabilidad = hab.idHabilidad);
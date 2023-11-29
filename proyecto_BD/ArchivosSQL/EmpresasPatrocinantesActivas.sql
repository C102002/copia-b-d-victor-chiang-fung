select esc.nombre, emp.nombre, patro.fechaInicio
	from vah_escuelas esc, vah_personas_juridicas emp, vah_hist_patrocinios patro
		where (esc.idescuela = patro.idEscuela) and (emp.idempresa = patro.idpersonajur) and (patro.fechafin is null);
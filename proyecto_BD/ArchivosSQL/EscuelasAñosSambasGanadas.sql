SELECT esc.nombre, titu.anio, samb.titulo
	FROM vah_escuelas esc, vah_hist_titulos titu, vah_samba samb
		WHERE ((esc.idEscuela = titu.idEscuela) and (esc.idEscuela = samb.idEscuela)) and (titu.anio = samb.aniocarnaval);
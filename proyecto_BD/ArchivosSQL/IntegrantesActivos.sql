SELECT inte.primnom, inte.primap, hist.fechaIngreso
	FROM vah_integrantes inte, vah_hist_integrante hist
		WHERE (inte.idIntegrante = hist.idIntegrante) and (hist.fechaRetiro is NULL) and (hist.idEscuela = 4);
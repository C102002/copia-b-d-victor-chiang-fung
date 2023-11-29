select inte.primnom, inte.primap, paren.nexo, par.primnom, par.primap
	from vah_integrantes inte, vah_integrantes par, vah_parentesco paren
		where (inte.idintegrante = paren.idintegrante) and (par.idintegrante = paren.idpariente);
select esc.nombre, inte.primnom, inte.primap, rol.nombrerol, org.aniocarnaval
	from vah_escuelas esc, vah_integrantes inte, vah_org_carnaval org, vah_roles rol
		where (esc.idescuela = org.idescuela) and (inte.idintegrante = org.idintegrante) 
		and (org.idrol = rol.idrol); 
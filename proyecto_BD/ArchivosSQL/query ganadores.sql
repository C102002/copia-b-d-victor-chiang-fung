SELECT 
extract(year FROM g.anio) anio,
p.nombre,
p.tipo,
p.descripcion,
e.nombre
FROM vah_ganadores g,  vah_premios_especiales p, vah_escuelas e
WHERE 
	 UPPER(e.nombre)  like  UPPER('%G.R.E.S. E%')
	 and
	 e.idescuela=g.idescuela
	 and
	 g.idpremioespecial=p.idpremioespecial
ORDER BY g.anio ASC
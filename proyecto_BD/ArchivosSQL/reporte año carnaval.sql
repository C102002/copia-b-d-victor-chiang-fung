SELECT 
extract(year FROM org.aniocarnaval) anio,
CONCAT(CONCAT(i.primnom,' '),i.primap) nombre,
r.nombrerol,
r.descripcion
FROM vah_org_carnavales org,  vah_hist_integrantes h, vah_escuelas e, vah_roles r, vah_integrantes i
WHERE 
	 UPPER(e.nombre)  like  UPPER('%G.R.E.S. Estácio de Sá%')
	 and
	 e.idescuela=h.idescuela
	 and
	 h.idescuela=org.idescuela
	 and
	 org.idrol=r.idrol
	 and
	 h.idintegrante=i.idintegrante
ORDER BY org.aniocarnaval, r.nombrerol, nombre ASC
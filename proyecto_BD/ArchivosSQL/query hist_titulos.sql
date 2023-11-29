
SELECT 
extract(year FROM h.anio) anio,
h.grupo,
Concat(to_char (Coalesce (h.monto,0),'999,990'),' R$') monto,
e.nombre
FROM vah_hist_titulos h,  vah_escuelas e
WHERE 
	 UPPER(e.nombre)  like  UPPER('%G.R.E.S. E%')
	 and
	 e.idescuela=h.idescuela
ORDER BY h.anio ASC
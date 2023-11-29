--Consulta para reporte de ficha de escuela
SELECT e.nombre,
	e.fechafundacion,
	e.direccionsede,
	e.historia
FROM vah_escuelas e
WHERE 
		 UPPER(e.nombre)  like  UPPER(CONCAT(CONCAT( '%',$P{Escuela}),'%'));

--Consulta para subreporte de ganadores de premio
SELECT 
extract(year FROM g.anio) anio,
p.nombre,
p.tipo,
p.descripcion
FROM vah_ganadores g,  vah_premios_especiales p, vah_escuelas e
WHERE 
 UPPER(e.nombre)  like  UPPER(CONCAT(CONCAT( '%', $P{Escuela} ),'%'))
	 and
	 e.idescuela=g.idescuela
	 and
	 g.idpremioespecial=p.idpremioespecial
ORDER BY g.anio ASC;

--Consulta para subreporte de noches de samba
SELECT 
extract(year FROM h.fechainicio) anio,
h.nombre,
	h.costounitario,
	to_char(h.fechainicio,'DD Mon YYYY') fechainicio,
	to_char(h.fechafin,'DD Mon YYYY') fechafin,
	coalesce ( h.totalasistencias,0) totalasistencias,
	coalesce ( h.descripcion,'No tiene descripcion') descripcion
FROM vah_escuelas e,
	vah_hist_eventos_anual_sem h
WHERE 
 UPPER(e.nombre)  like  UPPER(CONCAT(CONCAT( '%', $P{Escuela} ),'%'))
	 AND e.idescuela = h.idescuela 
	 AND h.tipoevento = 'NS' 
	 AND extract(year FROM current_date) = extract(year FROM h.fechainicio)
ORDER BY h.fechainicio ASC,
	h.fechafin ASC,
	h.costounitario ASC;

--Consulta para subreporte del histórico de títulos
SELECT 
extract(year FROM h.anio) anio,
h.grupo,
Concat(to_char (Coalesce (h.monto,0),'999,990'),' R$') monto,
e.nombre
FROM vah_hist_titulos h,  vah_escuelas e
WHERE 
 UPPER(e.nombre)  like  UPPER(CONCAT(CONCAT( '%', $P{Escuela} ),'%'))
	 and
	 e.idescuela=h.idescuela
ORDER BY h.anio ASC;

--Consulta para el subreporte de las organizaciones de carnaval
SELECT 
extract(year FROM org.aniocarnaval) anio,
CONCAT(CONCAT(i.primnom,' '),i.primap) nombre,
r.nombrerol,
r.descripcion
FROM vah_org_carnavales org,  vah_hist_integrantes h, vah_escuelas e, vah_roles r, vah_integrantes i
WHERE 
 UPPER(e.nombre)  like  UPPER(CONCAT(CONCAT( '%', $P{Escuela} ),'%'))
	 and
	 e.idescuela=h.idescuela
	 and
	 h.idescuela=org.idescuela
	 and
	 org.idrol=r.idrol
	 and
	 h.idintegrante=i.idintegrante
ORDER BY org.aniocarnaval, r.nombrerol, nombre ASC;

--Consulta para el reporte de ficha de integrante en escuela
SELECT esc.nombre nombreEscuela,
              inte.fechanacimiento, inte.primnom, inte.segnom, inte.primap, inte.segap, inte.nacionalidad, inte.apodo, inte.cpf,
              hist.fechaingreso, hist.fechaRetiro
	FROM vah_escuelas esc,  vah_integrantes inte,  vah_hist_integrantes hist
		WHERE  (inte.idIntegrante = $P!{ParamIdIntegrante}) AND
		(esc.idEscuela = $P!{ParamIdEscuela}) AND
		(inte.idIntegrante = hist.idIntegrante) AND 
		(hist.idEscuela = esc.idEscuela)
			ORDER BY esc.idEscuela,inte.idIntegrante, hist.fechaingreso asc;

--Consulta para el reporte de ingresos anuales y semanales
select h.nombre,h.totalasistencias, h.costounitario, h.fechainicio, h.fechafin, sum(h.totalasistencias) totalas, sum(h.costounitario) totalcos
from vah_hist_eventos_anual_sem h, vah_escuelas e
where h.idescuela=e.idescuela and
	h.fechainicio >= $P{pini} and  
	h.fechafin < $P{pfin}  and 
	upper(e.nombre) like upper( CONCAT( CONCAT('%',$P{nombre}),'%' ) ) and 
	h.tipoevento = 'G'
group by h.nombre,h.totalasistencias, h.costounitario, h.fechainicio, h.fechafin;

--Consulta para subreporte de noches de samba
select h.nombre,h.totalasistencias, h.costounitario, h.fechainicio, h.fechafin, sum(h.totalasistencias) totalas, sum(h.costounitario) totalcos
from vah_hist_eventos_anual_sem h, vah_escuelas e
where h.idescuela=e.idescuela and
upper(e.nombre) like upper( CONCAT( CONCAT('%',$P{nombre}),'%' ) ) and
h.fechainicio >= $P{pini} and  
h.fechafin < $P{pfin} and 
h.tipoevento = 'NS'
group by h.nombre,h.totalasistencias, h.costounitario, h.fechainicio, h.fechafin];

--Consulta para subreporte de premios monetarios
select h.anio, h.monto 
from vah_hist_titulos h, vah_escuelas e
where h.monto is not null
	and	e.idescuela = h.idescuela
		and upper(e.nombre) like upper( CONCAT( CONCAT('%',$P{nombre}),'%' ) ) 
			and h.anio >= make_date($P{año},1,1) 
				and	h.anio < make_date($P{año}+1,1,1);

--Consulta para reporte de total de asistencias
SELECT sum( s.totalasistencias) asistencia,
	s.tipoevento
FROM vah_hist_eventos_anual_sem s,
	vah_escuelas e
WHERE 
	 UPPER(e.nombre)  like  UPPER(CONCAT($P{nombre} , '%'))
	 AND e.idescuela = s.idescuela 
	 AND s.fechainicio >= make_date($P{fecha}, 1, 1)
	 AND s.fechafin < make_date($P{fecha}+1, 1, 1)
	 AND s.tipoevento = 'G' 
GROUP BY s.tipoevento;

SELECT sum( s.totalasistencias) asistencia,
	s.tipoevento
FROM vah_hist_eventos_anual_sem s,
	vah_escuelas e
WHERE 
	 UPPER(e.nombre)  like  UPPER(CONCAT($P{nombre} , '%'))
	 AND e.idescuela = s.idescuela 
	 AND s.fechainicio >= make_date($P{fecha}, 1, 1)
	 AND s.fechafin < make_date($P{fecha}+1, 1, 1)
	 AND s.tipoevento = 'NS' 
GROUP BY s.tipoevento
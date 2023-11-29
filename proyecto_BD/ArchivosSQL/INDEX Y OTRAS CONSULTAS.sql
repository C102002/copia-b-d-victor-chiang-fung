-- CREATE INDEX VAH_index_donsmontos ON vah_donaciones(monto);
-- CREATE INDEX VAH_index_regiones ON vah_estados(region);
-- CREATE INDEX VAH_index_ciudades ON vah_ciudades(nombre);
-- CREATE INDEX VAH_index_habs ON vah_habilidades(nombre);
-- CREATE INDEX VAH_index_eventos_anual ON vah_hist_eventos_anual_sem(tipoEvento, totalasistencias);
-- CREATE INDEX VAH_index_premios ON vah_premios_especiales(nombre);
-- CREATE INDEX VAH_index_personasnatu ON vah_personas_naturales(cpf, primnom, primap, email);
-- CREATE INDEX VAH_index_personasjuri ON vah_personas_juridicas(cpnj, nombre, email);
-- CREATE INDEX VAH_index_org_carna ON vah_org_carnavales(aniocarnaval, idrol);
-- CREATE INDEX VAH_index_integrantes ON vah_integrantes(primnom, primap, apodo, cpf);
-- CREATE INDEX VAH_index_titulos ON vah_hist_titulos(anio, monto);
-- CREATE INDEX VAH_index_hist_patros ON vah_hist_patrocinios(fechainicio, fechafin);
-- CREATE INDEX VAH_index_hist_intes ON vah_hist_integrantes(fechaingreso, fecharetiro);

/*
-- TOTAL DINERO POR EVENTOS_ANUALES_SEMESTRALES
select e.nombre, sum(a.costounitario*a.totalasistencias) Monto_Total
from vah_escuelas e, vah_hist_eventos_anual_sem a
where e.idescuela=a.idescuela
group by e.nombre

-- TOTAL DINERO POR EVENTO_ANUAL_SEMESTRAL
select distinct a.nombre, e.nombre, sum(a.costounitario*a.totalasistencias)
from vah_escuelas e, vah_hist_eventos_anual_sem a
where a.idescuela=e.idescuela
group by a.idevento, a.nombre, e.nombre
order by a.nombre

-- PROMEDIO DE DONACIONES POR ESCUELA
select distinct e.idescuela, e.nombre, avg(d.monto) PromedioMontos
from vah_escuelas e, vah_donaciones d
where e.idescuela=d.idescuela
group by e.idescuela, e.nombre
order by avg(d.monto) asc;

-- CANTIDAD DE ESCUELAS POR REGION
select s.region, count(distinct e.idescuela)
from vah_escuelas e, vah_estados s
where e.idestado = s.idestado
group by s.region

*/

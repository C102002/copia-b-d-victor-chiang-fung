SET datestyle = "ISO, DMY";
select e.primnom,e.segnom,j.fechaIngreso, j.fechaRetiro
from VAH_integrantes e inner join VAH_hist_integrante j on e.idIntegrante=j.idIntegrante 
inner join VAH_org_carnaval l on l.anioCarnaval<= coalesce (j.fecharetiro,'21-06-2023')
and j.fecharetiro is null
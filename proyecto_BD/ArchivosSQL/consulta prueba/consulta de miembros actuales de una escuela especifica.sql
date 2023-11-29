select l.idEscuela ,l.idEscuela,e.idIntegrante,j.idIntegrante,l.nombre,e.primNom, e.segNom, j.fechaIngreso , j.fechaRetiro
from VAH_escuelas l inner join VAH_Hist_integrante j 
on l.idEscuela=j.idEscuela
inner join VAH_integrantes e 
	on e.idIntegrante=j.idIntegrante 
	and fechaRetiro is null
Group by l.idEscuela ,l.idEscuela,e.idIntegrante,j.idIntegrante,l.nombre,e.primNom, e.segNom, j.fechaIngreso , j.fechaRetiro

	
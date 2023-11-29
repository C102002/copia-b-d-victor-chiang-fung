select l.idEscuela ,h.idPatrocinio,l.nombre,h.fechaInicio,j.nombre,h.fechaFin
from VAH_escuelas l
inner join VAH_Hist_patrocinios h 
	on l.idEscuela=h.idEscuela
 inner join VAH_personas_Juridicas j
	on j.idEmpresa=h.idPersonaJur
	and h.fechaFin is Null

group by l.idEscuela ,h.idPatrocinio,l.nombre,h.fechaInicio,j.nombre,h.fechaFin;
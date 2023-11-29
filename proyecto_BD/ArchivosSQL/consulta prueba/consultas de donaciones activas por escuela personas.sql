select l.idEscuela ,h.idPatrocinio,l.nombre,h.fechaInicio,j.primnom,h.fechaFin
from VAH_escuelas l
inner join VAH_Hist_patrocinios h 
	on l.idEscuela=h.idEscuela
 inner join VAH_personas_Naturales j
	on j.idPersona=h.idPersonaNat
	and h.fechaFin is Null

group by l.idEscuela ,h.idPatrocinio,l.nombre,h.fechaInicio,j.primnom,h.fechaFin;
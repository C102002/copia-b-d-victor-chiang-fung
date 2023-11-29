select	e.idEscuela,j.idEscuela,j.anio,w.anioCarnaval,e.nombre,e.direccionSede,j.anio,w.titulo
from	VAH_escuelas e inner join VAH_hist_titulos j on j.idEscuela=e.idEscuela
	 	inner join	VAH_samba w on j.anio=w.anioCarnaval		
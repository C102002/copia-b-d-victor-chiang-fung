select e.nombre,e.region,j.nombre
from VAH_escuelas j ,VAH_estados e
where(e.idEstado=j.idEstado) order by j.nombre ASC

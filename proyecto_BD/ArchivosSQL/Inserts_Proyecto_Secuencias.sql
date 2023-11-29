--SET datestyle = "ISO, DMY";


ALTER SEQUENCE VAH_sec_estados RESTART;
ALTER SEQUENCE VAH_sec_ciudades RESTART;
ALTER SEQUENCE VAH_sec_escuelas RESTART;
ALTER SEQUENCE VAH_sec_colores RESTART;
ALTER SEQUENCE VAH_sec_sambas RESTART;
ALTER SEQUENCE VAH_sec_Eventos_Anual_Sem RESTART;
ALTER SEQUENCE VAH_sec_personas_Naturales RESTART;
ALTER SEQUENCE VAH_sec_personas_Juridicas RESTART;
ALTER SEQUENCE VAH_sec_hist_Patrocinios RESTART;
ALTER SEQUENCE VAH_sec_donaciones RESTART;
ALTER SEQUENCE VAH_sec_integrantes RESTART;
ALTER SEQUENCE VAH_sec_roles RESTART;
ALTER SEQUENCE VAH_sec_premios_Especiales RESTART;
ALTER SEQUENCE VAH_sec_habilidades RESTART;



INSERT INTO  VAH_estados(nombre,region)
	VALUES ('RIO DE JANEIRO', 'SUDESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('SÃO PAULO', 'SUDESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('MINAS GERAIS', 'SUDESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('PARANÁ', 'SUR');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('GOIÁS', 'CENTRO-OESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('MATO GROSSO', 'CENTRO-OESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('ALAGOAS', 'NORDESTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('TOCANTINS', 'NORTE');

INSERT INTO  VAH_estados(nombre,region)
	VALUES ('MARANHÃO', 'NORDESTE');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (1, 'RIO DE JANEIRO');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (1,'NITERÓI');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (2,'SANTOS');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (3,'BELO HORIZONTE');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (4,'PONTA GROSSA');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (5,'PIRENÓPOLIS');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (6,'CUIABÁ');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (7,'PILAR');

INSERT INTO  VAH_ciudades(idEstado,nombre)
	VALUES (8,'COLMÉIA');

--Inserts para Habilidades

INSERT INTO VAH_habilidades(nombre,descripcion)
	VALUES ('CANTANTE', 'Destaca como intérprete y cantante');

INSERT INTO VAH_habilidades(nombre,descripcion)
	VALUES ('BAILA SAMBA ENREDO', 'Destreza en la danza de Samba-Enredo');

INSERT INTO VAH_habilidades(nombre,descripcion)
	VALUES ('ANIMADOR', 'Inspira energía a grupos de personas en eventos');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('COREÓGRAFO', 'Destaca como planificador de bailes');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('DIRECTOR', 'Dirige y ordena bailes, personas');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('ESCENÓGRAFO', 'Organiza los elementos visuales para espectáculos');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('ESTILISTA', 'Dirige la elección e implementación de vestimentas');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('DISEÑADOR', 'Destaca en el diseño de vestuarios');

INSERT INTO VAH_habilidades(nombre,descripcion) 
    VALUES ('COMPOSITOR', 'Destaca en las composiciones musicales');

--Inserts de colores

INSERT INTO  VAH_colores (nombre)
	VALUES ( 'AMARILLO');

INSERT INTO  VAH_colores (nombre)
	VALUES ( 'AZUL');

INSERT INTO  VAH_colores (nombre)
	VALUES ('AZUL REAL');

INSERT INTO  VAH_colores (nombre)
	VALUES ('AZUL TURQUESA');

INSERT INTO  VAH_colores (nombre)
	VALUES ('ORO');

INSERT INTO  VAH_colores (nombre)
	VALUES ('BLANCO');

INSERT INTO  VAH_colores (nombre)
	VALUES ('PLATA');

INSERT INTO  VAH_colores (nombre)
	VALUES ('AZUL MARINO');

INSERT INTO  VAH_colores (nombre)
	VALUES ('ÍNDIGO');

INSERT INTO  VAH_colores (nombre)
	VALUES ('ROJO');

INSERT INTO  VAH_colores (nombre)
	VALUES ('NEGRO');



INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
	VALUES ( 1, 1, 'G.R.E.S. Unidos Da Tijuca', 
			'31-12-1931', 'Av. Francisco Bicalho, 47 - Santo Cristo, Rio de Janeiro - RJ, 20220-310, Brasil ',
			CONCAT('Unidos da Tijuca surgió de la comunidad de Morro do Borel, localizada en el barrio de Tijuca ',
				  'en la zona norte de Rio de Janeiro. Cuando se fundó, esta fue la quinta escola de samba en ser creada. ',
				  'Se formó a partir de la unión de 4 blocos ya existentes: Velho Ismael Francisco e Dona Blandira, ',
				  'Velho Pacifico, Caroço y Dona Amélia')
		   );

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
	VALUES (1, 1, 'G.R.E.S. Tradição', '1-10-1984', 
	'Estrada Intendente Magalhães - Madureira, Rio de Janeiro - RJ, 21341-332, Brasil', 
	CONCAT('Fue creada por familiares de un ex-patrono de Portela. Nació el mismo año que se creó la LIESA. ',
			'La escuela tuvo uno de los ascensos más rápidos de la historia de Rio de Janeiro, quedando en el ',
			'Grupo 2-B en su primer año y en el Grupo Especial en 3 años. '));

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia) 
	VALUES (1, 1, 'G.R.E.S. Unidos Da Ponte', '3-nov-1952', 
	'R. Floriana, 32 - Coelho da Rocha, São João de Meriti - RJ, 25550-630, Brasil',
	CONCAT('Fue fundada por las familias Macário y Oliveira. En 1957 la escuela se afilió a la AESCRJ, ',
	'por iniciativa de su presidente Carmelita Brasil, que fue la primera mujer en dirigir una escola de samba. ',
	'A partir del año 1959 comenzaron a desfilar en la ciudad de Rio de Janeiro.'));

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
    VALUES ( 1, 1, 
		'G.R.E.S. Estácio de Sá', 
		'27-02-1955', 
		'Av. Francisco Bicalho, 47 - Santo Cristo, Rio de Janeiro - RJ, 20220-310, Brasil',		
		CONCAT('El Estácio de Sá fue fundado el 7 de febrero de 1955, con el nombre de Unidos ',
			'de São Carlos, a partir de la fusión de las escuelas de samba Cada Ano Sai Melhor, ',
			'Recreio de São Carlos y Paraíso das Morenas.'
		)
	);

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
	VALUES ( 1, 1, 
		'G.R.E.S. Caprichosos de Pilares', 
		'19-02-1949',
		'R. Faleiro, 1 - Pilares, Rio de Janeiro - RJ, 20771-090, Brasil',
		CONCAT('Caprichosos de Pilares fue fundada por una disidencia de Unidos de Terra Nova, ',
			'que era un colegio ubicado en la comarca conocida como Terra Nova, hoy parte de Pilares. ',
			'Cansados del descuido durante los desfiles y de los malos resultados de los Unidos de Terra Nova, ',
			'miembros de la escuela y bailarines de samba de Pilares decidieron fundar su propia escuela'
		)
	);

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
	VALUES ( 1, 2, 
		'G.R.E.S. Unidos do Viradouro', 
		'24-06-1946', 
		'Av. Francisco Bicalho, 47 - Santo Cristo, Rio de Janeiro - RJ, 20220-310, Brasil ',
		CONCAT('La fundación de Viradouro fue idea de Nelson dos Santos. Apasionado por la samba y el ',
			'carnaval, Jangada frecuentaba el bloque União do Viradouro. Después de pelearse con los ',
			'líderes de la asociación, el cantante de samba decidió desconectarse y fundar una escuela ',
			'de samba. Para ello, reunió a amigos y juerguistas de la región, así como a jugadores y ',
			'aficionados de un equipo de fútbol de la localidad'
		)
	);

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia)
	VALUES ( 1, 1, 'G.R.E.S. Porto da Pedra', 
			'03-08-1978','Tv. João Silva, 84 - Porto da Pedra, São Gonçalo - RJ, 24436-000, Brasil',
			CONCAT('En los años setenta , había un club de fútbol en São Gonçalo llamado Porto da Pedra Futebol Clube , que tenía los colores rojo y blanco y reunía a los vecinos del barrio. Entre estos integrantes se formó la idea de formar una cuadra callejera, cuadra que desfiló en 1975 y 1976 por las calles de la ciudad. ', '') );

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia) 
	VALUES ( 1, 1, 'G.R.E.S. São Clemente', 
			'25-10-1961','Av. Pres. Vargas, 3102 - Cidade Nova, Rio de Janeiro - RJ, 20210-031, Brasil',
			CONCAT('En 1951, un grupo de vecinos del barrio, encabezado por Ivo da Rocha Gomes, decidió crear un equipo de fútbol.Fue nombrado São Clemente Futebol Clube en referencia a la Rua São Clemente, donde vivía la mayoría de los jugadores. El equipo tenía los colores azul y blanco, inspirados en la Selección Carioca de Fútbol . El grupo entrenaba en la cancha de la UFRJ y participaba de campeonatos en Río de Janeiro y otras ciudades.', '') );

INSERT INTO VAH_escuelas(idEstado,idCiudad,nombre,fechaFundacion,direccionSede,historia) 
	VALUES ( 1, 1, 'G.R.E.S. União da Ilha do Governador',
			'07-03-1953','Estrada do Galeão, 322 - Cacuia, Rio de Janeiro - RJ, 21931-242, Brasil',
			CONCAT('A pesar de albergar el desfile de carnaval, Cacuia no contaba con ninguna escuela de samba representativa. El barrio tenía un equipo de fútbol, União Futebol Clube.  El equipo tricolor, azul, rojo y blanco, fue dirigido por el entrenador Maurício Gazelle. Sus jugadores vivían en la isla y competían en campeonatos locales.',''));

--Inserts para Unidos Da Tijuca


INSERT INTO VAH_esc_col
	VALUES (1, 1);
	
INSERT INTO VAH_esc_col
	VALUES (1, 2);

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 970055353, 1);
--Inserts de integrantes
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad)
	VALUES ('23-07-1952', 'José', 'Horta', 'de Sousa Vieira', 'M', 00005847085, 'Fernando', 'Portugués');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, apodo, cpf, nacionalidad)
	VALUES ('31-05-1957', 'Wantuir', 'de Oliveira', 'Tavares', 'M', 'Wantuir', 00007998054,'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, apodo, nacionalidad)
	VALUES ('19-07-1974', 'Rosiane', 'deSousa', 'Pinheiro', 'F', 00012213349 , 'Raimunda', 'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, apodo, nacionalidad)
	VALUES ('24-02-1960', 'Antonio', 'Ricardo', 'de Sousa', 'M', 00009625989, 'Rixxah', 'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad,apodo)
	VALUES ('23-04-1999', 'João', 'Benicio', 'Da Silva', 'M', 00005877085, 'Samuel', 'Brasileño','Godzilla');

INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad)
	VALUES ('23-05-1989', 'Fabio', 'Montibelo', 'Da Silva', 'M', 00008847585, 'Jose', 'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad) 
VALUES ('04-07-1977', 'Edson', 'Marinho', 'Dattoli', 'M', 00005743284, 'Edson', 'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad, apodo) 
VALUES ('12-09-1983', 'Carlos', 'Leandro', 'Amorelli', 'M', 00005221184, 'Brasileño', 'Nene');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad, apodo) 
VALUES ('28-04-1964', ' Hélio', 'Nunes', 'Almeida', 'M', 00004991132, 'Carlos', 'Brasileño', 'Heles');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES ('31-05-1984', 'Juan', 'de Oliveira', 'Marinho', 'M', 00007448054,'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES ('26-09-1982', 'Maria', 'de Oliveira', 'Marinho', 'F', 00004548054,'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES ('12-05-1989', 'Roberta', 'de Oliveira', 'Marinho', 'F', 00005448054,'Brasileño');
INSERT INTO VAH_integrantes(fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
	VALUES('15-02-1974', 'Julio', 'Marinho', 'Dattoli', 'M', 00002544678, 'Brasileño');
INSERT INTO VAH_integrantes( fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
	VALUES('12-08-1958', 'Mauro ', 'Quintaes', 'Joao', 'M', 00001044678, 'Brasileño');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 1, '1-1-1987', 'SI', '31-12-1992');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 1, '1-1-1997', 'SI', '31-12-1999');

INSERT INTO VAH_hist_Integrantes(idEscuela,idIntegrante, fechaIngreso, autoridad)
	VALUES (1, 1, '1-1-2001', 'SI');

--Inserts de roles
INSERT INTO VAH_roles(nombreRol,descripcion)
	VALUES ('PRESIDENTE', 'Director general de la escuela'),
	('INTÉRPRETE', 'Cantante principal de la pieza'),
	('RAINHA DE BATERIA', 'Bailarina principal que lidera el frente del desfile de la escuela'),
	('MADRINHA DE BATERIA', 'Bailarina que acompaña a la reina de batería'),
	('PORTA-BANDEIRA', 'Portador de la Bandera de la Escuela'),
	('COREOGRAFO', 'Diseñador de bailes y actos'),
	('ESTILISTA', 'Diseñador del vestuario'),
	('ESCENÓGRAFO', 'Diseñador del escenario y otros'),
	('ESCULTOR', 'Creador de elementos de la escenografía');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1987', 1, '1-1-1987');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1987', 1, '1-1-1988');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1987', 1, '1-1-1989');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1987', 1, '1-1-1990');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1987', 1, '1-1-1992');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1997', 1, '1-1-1997');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1997', 1, '1-1-1998');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-1997', 1, '1-1-1999');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2001');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2002');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2003');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2004');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2005');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2006');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2007');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2008');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2009');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2010');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2011');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2012');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2013');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2014');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2015');

INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2016');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2017');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2018');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2019');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2020');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2022');
	
INSERT INTO VAH_org_carnavales
	VALUES (1, 1, '1-1-2001', 1, '1-1-2023');


INSERT INTO VAH_int_Hab
	VALUES (2, 1);

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2001', 'NO', '31-12-2002');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2004', 'NO', '31-12-2008');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2019', 'NO', '31-12-2023');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2001', 2, '1-1-2001');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2001', 2, '1-1-2002');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2004', 2, '1-1-2004');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2004', 2, '1-1-2005');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2004', 2, '1-1-2006');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2004', 2, '1-1-2007');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2004', 2, '1-1-2008');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2019', 2, '1-1-2019');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2019', 2, '1-1-2020');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2019', 2, '1-1-2022');

INSERT INTO VAH_org_carnavales
	VALUES (1, 2, '1-1-2019', 2, '1-1-2023');


--Inserts para Tradição

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 32871533, 2);

INSERT INTO VAH_esc_col
	VALUES (2, 3);

INSERT INTO VAH_esc_col
	VALUES (2, 4);

INSERT INTO VAH_esc_col
	VALUES (2, 5);

INSERT INTO VAH_esc_col
	VALUES (2, 6);

INSERT INTO VAH_esc_col
	VALUES (2, 7);

INSERT INTO VAH_hist_Integrantes
	VALUES (2, 2, '1-1-1999', 'NO', '31-12-2000');

INSERT INTO VAH_org_carnavales
	VALUES (2, 2, '1-1-1999', 2, '1-1-1999');

INSERT INTO VAH_org_carnavales
	VALUES (2, 2, '1-1-1999', 2, '1-1-2000');



INSERT INTO VAH_int_Hab
	VALUES (3, 2);

INSERT INTO VAH_int_Hab
	VALUES (3, 3);

INSERT INTO VAH_hist_Integrantes
	VALUES (2, 3, '1-1-1998', 'NO', '31-12-2000');

INSERT INTO VAH_hist_Integrantes
	VALUES (2, 3, '1-1-2003', 'NO', '31-12-2005');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-1998', 3, '1-1-1998');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-1998', 3, '1-1-1999');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-1998', 3, '1-1-2000');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-2003', 3, '1-1-2003');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-2003', 3, '1-1-2004');

INSERT INTO  VAH_org_carnavales
	VALUES (2, 3, '1-1-2003', 4, '1-1-2005');


--Inserts para Unidos Da Ponte

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (51, 21, 964564497, 3);

INSERT INTO VAH_esc_col
	VALUES (3, 8);

INSERT INTO VAH_esc_col
	VALUES (3, 9);

INSERT INTO VAH_esc_col
	VALUES (3, 6);


INSERT INTO VAH_int_Hab
	VALUES (4, 1);

INSERT INTO VAH_hist_Integrantes
	VALUES (3, 4, '1-1-2001', 'NO', '31-12-2002');

INSERT INTO VAH_org_carnavales
	VALUES (3, 4, '1-1-2001', 2, '1-1-2001');

INSERT INTO VAH_org_carnavales
	VALUES (3, 4, '1-1-2001', 2, '1-1-2002');

--Inserts para las empresas
INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 30872504000123, 'Itaú Unibanco Holding S.A.', 'PRIV', 'itaujudicial@itau-unibanco.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 11, 50191879, 1);

INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 17155730000164, 'CEMIG', 'PRIV', 'ri@cemig.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 31, 35065024, 2);

INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 06047087007222, 'Rede D''Or Sao Luiz S.A.', 'PRIV', 'centroestudos.jbq@saoluiz.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 21, 30034330, 3);

-- Patrocinadores
INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email) VALUES (434725340, 'JBS', 'PRIV', 'jbs@comjbs.com.br'); -- JBS    
INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email) VALUES ( 524725322, 'MARFRIG GLOBAL FOODS', 'PRIV', 'marfrig@mfcompany.com.br'); -- Marfrig Global Foods
INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email) VALUES ( 632472532, 'WEG', 'PRIV', 'weg@wegindus.com.br'); -- WEG
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 99972539, 4);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 82344558, 5);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 71213127, 6);

INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 02429144000193, 'Cpfl Energia S.A.', 'PRIV', 'backofficetributario@cpfl.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 19, 37568020, 7);

INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 26896348000100 , 'Habib’s', 'PRIV', 'habibs786@hotmail.com ');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 01, 274666786, 8);

INSERT INTO VAH_personas_Juridicas(cpnj,nombre,tipoEmpresa,email)
	VALUES ( 4710439000126, 'Ultrapar', 'PRIV', ' imprensa@ultra.com.br.');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 11, 31777014, 9);

--inserts personas naturales
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00005743284, 'Jose', 'Manrinho', 'Briceño', 'jmanrhino112@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00006143333, 'Carlos', 'Briceño', 'Perez', 'cbribripe112@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00008743444, 'Pedro', 'Parra', 'Rivera', 'pedrrrariv2@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00008741234, 'Lionel', 'Rivera', 'Alvarez', 'lioalv123@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00007743224, 'Javier', 'Alvarez', 'Parra', 'jaalvapa11@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00004712584, 'Maria', 'Parra', 'Briceño', 'mriparbrice22@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00006755584, 'Rosa', 'Rivera', 'Alvarez', 'rosarirez22@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00005743243, 'Karla', 'Manrinho', 'Briceño', 'karmarnhic23@gmail.com');
INSERT INTO VAH_personas_Naturales(cpf,primNom,primAp,segAp,email) VALUES (00006741241, 'Karina', 'Rivera', 'Rivera', 'karivriv4242@gmail.com');


-- Inserts para Porto da Pedra

INSERT INTO VAH_esc_col
	VALUES (7, 10);

INSERT INTO VAH_esc_col
	VALUES (7, 6);

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 26068623, 7);

INSERT INTO VAH_hist_Integrantes
	VALUES (7, 5, '1-1-2020', 'SI');

INSERT INTO VAH_hist_Integrantes
	VALUES (7, 6, '1-1-2012', 'SI', '1-1-2020');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2012');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2013');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2014');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2015');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2016');
		
INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2017');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2018');

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2019');	

INSERT INTO VAH_org_carnavales
	VALUES (7, 6, '1-1-2012', 1, '1-1-2020');

INSERT INTO VAH_org_carnavales
	VALUES (7, 5, '1-1-2020', 1, '1-1-2021');

INSERT INTO VAH_org_carnavales
	VALUES (7, 5, '1-1-2020', 1, '1-1-2022');

INSERT INTO VAH_org_carnavales
	VALUES (7, 5, '1-1-2020', 1, '1-1-2023');

INSERT INTO VAH_hist_Integrantes
	VALUES (7, 2, '1-1-1995', 'NO', '31-12-1998');
	
INSERT INTO VAH_hist_Integrantes
	VALUES (7, 2, '1-1-2024', 'NO');

INSERT INTO VAH_org_carnavales
	VALUES (7, 2, '1-1-1995', 2, '1-1-1995');

INSERT INTO VAH_org_carnavales
	VALUES (7, 2, '1-1-1995', 2, '1-1-1996');

INSERT INTO VAH_org_carnavales
	VALUES (7, 2, '1-1-1995', 2, '1-1-1997');

INSERT INTO VAH_org_carnavales
	VALUES (7, 2, '1-1-1995', 2, '1-1-1998');
--Coloco el premio especial de carnaval de rio

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-1995','Segunda División Río Janeiro');

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-2001','Segunda División Río Janeiro');

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-2023','Segunda dision Rio Janeiro');

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-1982','Primera División Sao Gonçalo');

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-1979','Bloques São Gonçalo');

INSERT INTO VAH_hist_Titulos
	values(7,'01-01-1980','Bloques São Gonçalo');

--Inserts de Sao clemente

INSERT INTO VAH_esc_col
	VALUES (8, 11);

INSERT INTO VAH_esc_col
	VALUES (8, 1);

--Inserts Unión de la isla del gobernador

INSERT INTO VAH_esc_col
	VALUES (9,6);

INSERT INTO VAH_esc_col
	VALUES (9,10);

INSERT INTO VAH_esc_col
	VALUES (9,2);

--Inserts de los patrocinios

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(7,'01-01-2002',7);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(8,'01-01-2022',8);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(9,'01-01-2012',9);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(1,'01-01-2014',1);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(2,'01-01-2011',2);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur,fechaFin)values(3,'01-01-2001',3,'01-01-2023');

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur,fechaFin)values(7,'01-01-2007',7,'01-01-2015');

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(7,'01-01-2002',8);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(7,'01-01-2002',9);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(8,'01-01-2020',1);

INSERT INTO VAH_hist_Patrocinios(idEscuela,fechaInicio,idPersonaJur)
values(1,'01-01-2012',8);

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (4, 4, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (5, 5, '1-1-2017');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (6, 6, '1-1-2020');

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (4, 6, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio, fechaFin) VALUES (5, 5, '1-1-2007','1-1-2010');INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (6, 4, '1-1-2002');

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio, fechaFin) VALUES (4, 3, '1-1-2012','1-1-2019');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio, fechaFin) VALUES (5, 2, '1-1-2017','1-1-2018');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaJur, fechaInicio) VALUES (6, 1, '1-1-2010');

--Historico de patrocinios de personas naturales
INSERT INTO VAH_hist_Patrocinios(idEscuela,  idPersonaNat, fechaInicio) VALUES (6, 1, '1-1-2010');
INSERT INTO VAH_hist_Patrocinios(idEscuela,  idPersonaNat, fechaInicio) VALUES (2, 2, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaNat, fechaInicio,FechaFin) VALUES (1, 1, '1-1-2014','01-01-2023');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaNat, fechaInicio,fechaFin) VALUES (1, 1, '1-1-2015','01-01-2019');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaNat, fechaInicio,fechaFin) VALUES (3, 1, '1-1-2012','01-01-2022');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPersonaNat, fechaInicio) VALUES (4, 1, '1-1-2002');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela) VALUES (55, 21, 25042883, 4);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela) VALUES (55, 21, 38226246, 5);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela) VALUES (55, 21, 28280658, 6);

INSERT INTO VAH_esc_col VALUES (4, 10);
INSERT INTO VAH_esc_col VALUES (4, 6);
INSERT INTO VAH_esc_col VALUES (5, 6);
INSERT INTO VAH_esc_col VALUES (5, 3);
INSERT INTO VAH_esc_col VALUES (5, 4);
INSERT INTO VAH_esc_col VALUES (6, 10);
INSERT INTO VAH_esc_col VALUES (6, 6);



INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 7, '1-1-2023', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (5, 8, '1-1-2017', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (6, 9, '1-1-2023', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 10, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 11, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 12, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 13, '1-1-2019', 'NO');

INSERT INTO VAH_org_carnavales VALUES (4, 7, '1-1-2023', 1, '1-1-2023');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2017');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2018');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2019');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2020');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2021');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2022');
INSERT INTO VAH_org_carnavales VALUES (5, 8, '1-1-2017', 1, '1-1-2023');
INSERT INTO VAH_org_carnavales VALUES (6, 9, '1-1-2023', 1, '1-1-2023');

INSERT INTO VAH_org_carnavales VALUES (4, 10, '1-1-2020', 4, '1-1-2020');
INSERT INTO VAH_org_carnavales VALUES (4, 11, '1-1-2020', 4, '1-1-2023');
INSERT INTO VAH_org_carnavales VALUES (4, 12, '1-1-2020', 6, '1-1-2021');
INSERT INTO VAH_org_carnavales VALUES (4, 12, '1-1-2020', 7, '1-1-2022');

INSERT INTO VAH_hist_Titulos values(4,'01-01-1958','UGESB');
INSERT INTO VAH_hist_Titulos values(4,'01-01-1964','GRUPO 2', 40000);
INSERT INTO VAH_hist_Titulos values(4,'01-01-1961','UGESB',20200);
INSERT INTO VAH_hist_Titulos values(4,'01-01-2003','GRUPO 1',10555);
INSERT INTO VAH_hist_Titulos values(5,'01-01-1964','UGESB',10200);
INSERT INTO VAH_hist_Titulos values(5,'01-01-1992','UGESB', 3000);
INSERT INTO VAH_hist_Titulos values(5,'01-01-2004','GRUPO 2',8000);
INSERT INTO VAH_hist_Titulos values(6,'01-01-1979','GRUPO 3');
INSERT INTO VAH_hist_Titulos values(6,'01-01-1980','GRUPO 1');
INSERT INTO VAH_hist_Titulos values(6,'01-01-1999','GRUPO 1');
INSERT INTO VAH_hist_Titulos values(6,'01-01-2000','UGESB');


INSERT INTO VAH_int_Hab VALUES (7, 4);
INSERT INTO VAH_int_Hab VALUES (7, 5);
INSERT INTO VAH_int_Hab VALUES (7, 9);
INSERT INTO VAH_int_Hab VALUES (8, 6);
INSERT INTO VAH_int_Hab VALUES (8, 7);
INSERT INTO VAH_int_Hab VALUES (8, 8);
INSERT INTO VAH_int_Hab VALUES (8, 9);
INSERT INTO VAH_int_Hab VALUES (9, 5);

INSERT INTO VAH_int_Hab VALUES (10, 4);
INSERT INTO VAH_int_Hab VALUES (10, 6);
INSERT INTO VAH_int_Hab VALUES (11, 2);
INSERT INTO VAH_int_Hab VALUES (11, 6);
INSERT INTO VAH_int_Hab VALUES (12, 7);

INSERT INTO VAH_parentescos VALUES (7,10,'S','Primos');
INSERT INTO VAH_parentescos VALUES (7,11,'S','Primos');
INSERT INTO VAH_parentescos VALUES (7,12,'S','Primos');
INSERT INTO VAH_parentescos VALUES (7,13,'S','Hermanos');
INSERT INTO VAH_parentescos VALUES (10,11,'S','Hermanos');
INSERT INTO VAH_parentescos VALUES (10,12,'S','Hermanos');
INSERT INTO VAH_parentescos VALUES (10,13,'S','Primos');
INSERT INTO VAH_parentescos VALUES (11,12,'S','Hermanos');
INSERT INTO VAH_parentescos VALUES (11,13,'S','Primos');
INSERT INTO VAH_parentescos VALUES (12,13,'S','Primos');




--Donaciones empresas

INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (4, 12, '04-04-2013', 1000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (4, 12, '07-04-2013', 4000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (4, 12, '14-04-2013', 200);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (4, 12, '28-04-2013', 2000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (4, 12, '14-09-2013', 5000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (5, 13, '14-07-2018', 200);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (5, 13, '07-02-2019', 2000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (6, 14, '04-10-2020', 800);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (6, 14, '07-07-2021', 400);

--Donaciones de personas naturales
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (6,21, '04-04-2013', 1000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (6,21, '04-04-2014', 1500);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (2,22, '04-04-2013', 1500);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, fechaDonacion, monto) VALUES (2,22, '04-04-2020', 1500);

--Inserts para histórico de eventos
INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion) 
	VALUES (1, 'Noche de Samba', 48, 'NS', '07-02-2022', '07-02-2022', 53, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion)
	VALUES (1, 'Ensayo abierto', 35, 'G', '20-02-2022', '20-02-2022', 117, 'Último ensayo antes del carnaval, abierto a la audiencia');

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion)
	VALUES (2, 'Noche de Samba', 50, 'NS', '10-02-2022', '10-02-2022', 66, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion)
	VALUES (3, 'Karaoke', 24, 'G', '25-05-2022', '25-05-2022', 150, 'Noche de Karaoke con los temas de la escuela');

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion)
	VALUES (4, 'Noche de Samba', 48, 'NS', '02-02-2022', '02-02-2022', 45, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion)
	VALUES (4, 'Ensayo Abierto', 30, 'G', '22-02-2022', '22-02-2022', 98, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion) 
	VALUES (5, 'Noche de Samba', 45, 'NS', '06-02-2022', '06-02-2022', 57, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion) 
	VALUES (6, 'Noche de Samba', 51, 'NS', '10-02-2022', '10-02-2022', 71, NULL);

INSERT INTO VAH_hist_Eventos_Anual_Sem(idEscuela,nombre,
costoUnitario,tipoEvento,fechaInicio,fechaFin, totalAsistencias, descripcion) 
	VALUES (8, 'Noche de Samba', 55, 'NS', '07-02-2022', '07-02-2022', 36, NULL);


--Inserts para premios especiales
INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Estandarte de Oro', 'Escuela', 'Estandarte de Oro otorgado a una Escuela', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Estandarte de Oro', 'Samba-Enredo (Especial)', 'Estandarte de Oro otorgado por la Samba-Enredo', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Estandarte de Oro', 'Samba-Enredo (Grupo 2)', 'Estandarte de Oro otorgado por la Samba-Enredo', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('S@mba-Net', 'Mejor Desfile', 'Premio S@mba-Net al mejor desfile del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('S@mba-Net', 'Intérprete', 'Premio S@mba-Net al mejor intérprete del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('S@mba-Net', 'Comisión de frente', 'Premio S@mba-Net a la mejor comisión de frente', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Tamborín de Oro', 'Intérprete', 'Tamborín de Oro al mejor intérprete del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Plumas & Paetés', 'Coreógrafo', 'Premio al mejor coreógrafo del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales(nombre,tipo,descripcion,idEstado,idEstadoCiudad,idCiudad)
	VALUES ('Plumas & Paetés', 'Maquillador', 'Premio al mejor maquillador del año', 1, NULL, NULL);

INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad,fechaRetiro) VALUES (7, 14, '1-1-1995', 'NO','31-1-1998');

--Inserts de las sambas
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (7, '01-01-1979','Fiesta junina','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (7, '01-01-1980','Temporada','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-1982','En el reino de la fantasía','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-1994','Nuevo Sol de la Mañana','','SAMBA ENREDO');
--Inserts de sambas de mauro quintaes (7,5), (7,21), (7,22)

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-1995','Patria, ciudad en busca de la felicidad','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-2001','Un sueño posible: crecer y vivir es ahora la ley','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-2023','La invención del Amazonas un sueño posible: crecer y vivir es ahora la ley','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-1980','Delmiro Gouveia','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-1987','As Três Faces da Moeda	','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-1999','O Dono da Terra','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2010','É segredo!','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2012','O Dia em Que Toda a Realeza Desembarcou na Avenida para Coroar o Rei Luiz do Sertão','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2014','Acelera, Tijuca!','','SAMBA ENREDO');
--Sambas de wantuir

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2004','O sonho da criação e a criação do sonho: a arte da ciência no tempo do impossível','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2005','Entrou por em lado, saiu pelo outro… quem quiser que invente outro!','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2006','Ouvindo tudo o que vejo, vou vendo tudo o que ouço','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2007','De lambida em lambida, a Tijuca dá um click na avenida','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2008','Vou juntando o que eu quiser, minha mania vale ouro. Sou Tijuca, trago a arte colecionando','','SAMBA LOLOCO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2019','Cada macaco no seu galho. Ó, meu pai, me dê o pão que eu não morro de fome!','','SAMBA EMBOLO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (1, '01-01-2020','Onde moram os sonhos','','FREVO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-1996','La juerga en el mundo - Un carnaval de carnavales','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo)  VALUES (7, '01-01-1998','Samba de pies y manos en el aire, ¡esto es un robo!','','SAMBA ENREDO');
--sambas 23 a 33

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (4,'01-01-1958','Glória mil - Santos Dumont','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (4,'01-01-1964','"IV séculos de glória da Bahia"','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (4,'01-01-1961','Música, poesia e arte','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (4,'01-01-2003','Um banho da natureza - Cachoeiras de Macacu','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (5,'01-01-1964','IV Centenário do Rio de Janeiro','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (5,'01-01-1992','Brasil feito a mão... do barro ao carnaval','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (5,'01-01-2004','Xuxa e seu reino encantado no carnaval da imaginação','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (6,'01-01-1979','Ainda um paraíso tropical','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (6,'01-01-1980','Os três encantos do rei','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (6,'01-01-1999','Anita Garibaldi - Heroína das sete magias','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (6,'01-01-2000','Brasil: visões de paraísos e infernos','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2010','“Rei Senhor, Rei Zumbi, Rei Nagô Eu também tô aí, tô aí sim sinhô”','“O negro lá na África era um rei Foi artesão, foi caçador Guerreiro, feiticeiro, camponês Exímio dançador Tinha sua própria lei E a liberdade sem favor Dono dos ouros, das pratas Dos rios, das matas (bis)','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2011','Outras informações julgadas necessárias','Vem, no calor da bateria É hora de seguir a procissão Tá aí, meu querido Padim Ciço, A nossa romaria em teu louvor O pai desse povo tão mestiço Seu Santo, e padrinho protetor Um líder natural, poder de comandar Mão firme...','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2012','Ziraldo: páginas da vida de um maluco genial!','Nesta noite de magia,a alegria está no ar Meu Condor vai prá folia Abre o livro e faz sonhar No universo encantado vem comigo viajar No pulsar da batucada vamos todos "Ziraldar" Da infância em Caratinga Trouxe a arte como herança Desenhando fez a vida','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2013','Das maravilhas do mar, fez-se o esplendor de uma noite','Deixa-me encantar Com tudo teu E revelar, lalaiá lá O que vai acontecer Nesta noite de esplendor O mar subiu na linha do horizonte Desaguando como fonte Ao vento a ilusão teceu O mar (oi, o mar) Por onde andei mareou (mareou) Rolou na dança das ondas No verso do cantador','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2014','Sonhar com rei dá leão!','Sonhar com anjo é borboleta, Sem contemplação, Sonhar com rei dá leão, E nesta festa de real valor, Não erre, não, O palpite certo é Beija-Flor (Beija-Flor)','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2015','Nhá Chica, a beata negra e guerreira do Brasil!','Avante condor Viaja nessa história de superação Vai Francisca guerreira Iluminada pela luz do criador Na África Ressoa o tambor A nobreza de uma raça “Minha Sinhá” Aliança de fé, esperança e amor Livre pra seguir seu coração Expressando asua devoção','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2016',' Clementina, cade você?','Eu vou cantarolar a noite inteira dando um banho na tristeza faço a festa começar eu sou Tradição, eu sou guerreira De Mangueira a Madureira fiz meu samba ecoar firmei partido lá na casa de sinhá mas batuque na cozinha a sinhá não quis deixar e quem diria fui aplaudida','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2017',' O Lago dos Cisnes','Um violino toca e anuncia A ópera vai começar Dois corações Amor sem fim... Bailam com os tamborins O mal se fez Em uma feitiçaria Um cisne coroado, assim surgia Derrama o pranto E o lago se formou A realeza se rende ao amor E o destino então reinou','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2018',' Sabá - soberana da Etiópia, sedutora de Jerusalém','Lá onde os deuses criaram a chama guerreira Nasceu a beleza em forma de mulher A terra dos nossos ancestrais Ouviu a voz da Rainha Makeda De Judá, vem chegando O rei e a sabedoria, valentia Salomão, paixão de sua vida Na jornada rumo à Jerusalém "Negra como as tendas de quedar" Tués a Rainha de Sabá','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,anioCarnaval,titulo,letra,tipo) VALUES (2,'01-01-2019',' Gira baiana - salve as mães do samba!','Niña iluminada de Orum Trae las bendiciones de Oxalá Baianity axé…la luz de ser Mujer Hizo de Río su Gatois Derrotó los cuarteles y grilletes de los esclavos Levantó las Banderas de las Naciones Y en el xirê de los rituales Aparece la Madre de los Carnavales','SAMBA ENREDO');



INSERT INTO VAH_autores values(1,14,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,15,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,16,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,17,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,18,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,19,1,2,'2004-01-01');
INSERT INTO VAH_autores values(1,20,1,2,'2019-01-01');
--
INSERT INTO VAH_autores values(7,21,7, 14, '1-1-1995');
INSERT INTO VAH_autores values(7,22,7, 14, '1-1-1995');
INSERT INTO VAH_autores values(7,5,7, 14, '1-1-1995');

--Inserts de ganadores de los premios especiales

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(2,'01-01-1987',3);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(4,'01-01-1973',3);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(4,'01-01-1972',2);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(4,'01-01-1985',2);

INSERT INTO VAH_ganadores(anio,idPremioEspecial,idEscuelaIntegrante,fechaIngreso,idIntegrante) VALUES ('01-01-2002',5,3,'01-01-2001',4);

INSERT INTO VAH_ganadores(idEscuela,anio,idPremioEspecial) VALUES (3,'01-01-2004',6);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(5,'01-01-1978',3);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(5,'01-01-2012',4);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(6,'01-01-1997',1);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(5,'01-01-1992',2);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(5,'01-01-2016',3);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(8,'01-01-2001',4);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(9,'01-01-2011',1);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(9,'01-01-2003',4);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(9,'01-01-2006',4);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(9,'01-01-2015',6);

INSERT INTO VAH_ganadores (idEscuela,anio,idPremioEspecial)
VALUES(9,'01-01-2016',6);
--SET datestyle = "ISO, DMY";
INSERT INTO VAH_estados
	VALUES (1, 'RIO DE JANEIRO', 'SUDESTE');

INSERT INTO VAH_estados
	VALUES (2, 'SÃO PAULO', 'SUDESTE');

INSERT INTO VAH_estados
	VALUES (3, 'MINAS GERAIS', 'SUDESTE');

INSERT INTO VAH_estados
	VALUES (4, 'PARANÁ', 'SUR');

INSERT INTO VAH_estados
	VALUES (5, 'GOIÁS', 'CENTRO-OESTE');

INSERT INTO VAH_estados
	VALUES (6, 'MATO GROSSO', 'CENTRO-OESTE');

INSERT INTO VAH_estados
	VALUES (7, 'ALAGOAS', 'NORDESTE');

INSERT INTO VAH_estados
	VALUES (8, 'TOCANTINS', 'NORTE');

INSERT INTO VAH_estados
	VALUES (9, 'MARANHÃO', 'NORDESTE');

INSERT INTO VAH_ciudades
	VALUES (1, 1, 'RIO DE JANEIRO');

INSERT INTO VAH_ciudades
	VALUES (1, 2, 'NITERÓI');

INSERT INTO VAH_ciudades
	VALUES (2, 3, 'SANTOS');

INSERT INTO VAH_ciudades
	VALUES (3, 4, 'BELO HORIZONTE');

INSERT INTO VAH_ciudades
	VALUES (4, 5, 'PONTA GROSSA');

INSERT INTO VAH_ciudades
	VALUES (5, 6, 'PIRENÓPOLIS');

INSERT INTO VAH_ciudades
	VALUES (6, 7, 'CUIABÁ');

INSERT INTO VAH_ciudades
	VALUES (7, 8, 'PILAR');

INSERT INTO VAH_ciudades
	VALUES (8, 9, 'COLMÉIA');

--Inserts para Habilidades

INSERT INTO VAH_habilidades
	VALUES (1, 'CANTANTE', 'Destaca como intérprete y cantante');

INSERT INTO VAH_habilidades
	VALUES (2, 'BAILA SAMBA ENREDO', 'Destreza en la danza de Samba-Enredo');

INSERT INTO VAH_habilidades
	VALUES (3, 'ANIMADOR', 'Inspira energía a grupos de personas en eventos');

--Inserts para Unidos Da Tijuca

INSERT INTO VAH_escuelas
	VALUES (1, 1, 1, 'G.R.E.S. Unidos Da Tijuca', 
			'31-12-1931', 'Av. Francisco Bicalho, 47 - Santo Cristo, Rio de Janeiro - RJ, 20220-310, Brasil ',
			CONCAT('Unidos da Tijuca surgió de la comunidad de Morro do Borel, localizada en el barrio de Tijuca ',
				  'en la zona norte de Rio de Janeiro. Cuando se fundó, esta fue la quinta escola de samba en ser creada. ',
				  'Se formó a partir de la unión de 4 blocos ya existentes: Velho Ismael Francisco e Dona Blandira, ',
				  'Velho Pacifico, Caroço y Dona Amélia')
		   );

INSERT INTO VAH_colores
	VALUES (1, 'AMARILLO');

INSERT INTO VAH_colores
	VALUES (2, 'AZUL');

INSERT INTO VAH_esc_col
	VALUES (1, 1);
	
INSERT INTO VAH_esc_col
	VALUES (1, 2);

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 970055353, 1);

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad)
	VALUES (1, '23-07-1952', 'José', 'Horta', 'de Sousa Vieira', 'M', 00005847085, 'Fernando', 'Portugués');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 1, '1-1-1987', 'SI', '31-12-1992');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 1, '1-1-1997', 'SI', '31-12-1999');

INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad)
	VALUES (1, 1, '1-1-2001', 'SI');

INSERT INTO VAH_roles
	VALUES (1, 'PRESIDENTE', 'Director general de la escuela');

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

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, apodo, cpf, nacionalidad)
	VALUES (2, '31-05-1957', 'Wantuir', 'de Oliveira', 'Tavares', 'M', 'Wantuir', 00007998054,'Brasileño');

INSERT INTO VAH_int_Hab
	VALUES (2, 1);

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2001', 'NO', '31-12-2002');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2004', 'NO', '31-12-2008');

INSERT INTO VAH_hist_Integrantes
	VALUES (1, 2, '1-1-2019', 'NO', '31-12-2023');

INSERT INTO VAH_roles
	VALUES (2, 'INTÉRPRETE', 'Cantante principal de la pieza');

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

INSERT INTO VAH_escuelas
	VALUES (2, 1, 1, 'G.R.E.S. Tradição', '1-10-1984', 
	'Estrada Intendente Magalhães - Madureira, Rio de Janeiro - RJ, 21341-332, Brasil', 
	CONCAT('Fue creada por familiares de un ex-patrono de Portela. Nació el mismo año que se creó la LIESA. ',
			'La escuela tuvo uno de los ascensos más rápidos de la historia de Rio de Janeiro, quedando en el ',
			'Grupo 2-B en su primer año y en el Grupo Especial en 3 años. '));

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 32871533, 2);

INSERT INTO VAH_colores
	VALUES (3, 'AZUL REAL');

INSERT INTO VAH_colores
	VALUES (4, 'AZUL TURQUESA');

INSERT INTO VAH_colores
	VALUES (5, 'ORO');

INSERT INTO VAH_colores
	VALUES (6, 'BLANCO');

INSERT INTO VAH_colores
	VALUES (7, 'PLATA');

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

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, apodo, nacionalidad)
	VALUES (3, '19-07-1974', 'Rosiane', 'deSousa', 'Pinheiro', 'F', 00012213349 , 'Raimunda', 'Brasileño');

INSERT INTO VAH_int_Hab
	VALUES (3, 2);

INSERT INTO VAH_int_Hab
	VALUES (3, 3);

INSERT INTO VAH_hist_Integrantes
	VALUES (2, 3, '1-1-1998', 'NO', '31-12-2000');

INSERT INTO VAH_hist_Integrantes
	VALUES (2, 3, '1-1-2003', 'NO', '31-12-2005');

INSERT INTO VAH_roles
	VALUES (3, 'RAINHA DE BATERIA', 'Bailarina principal que lidera el frente del desfile de la escuela');

INSERT INTO VAH_roles
	VALUES (4, 'MADRINHA DE BATERIA', 'Bailarina que acompaña a la reina de batería');

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

INSERT INTO VAH_escuelas 
	VALUES (3, 1, 1, 'G.R.E.S. Unidos Da Ponte', '3-nov-1952', 
	'R. Floriana, 32 - Coelho da Rocha, São João de Meriti - RJ, 25550-630, Brasil',
	CONCAT('Fue fundada por las familias Macário y Oliveira. En 1957 la escuela se afilió a la AESCRJ, ',
	'por iniciativa de su presidente Carmelita Brasil, que fue la primera mujer en dirigir una escola de samba. ',
	'A partir del año 1959 comenzaron a desfilar en la ciudad de Rio de Janeiro.'));

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (51, 21, 964564497, 3);

INSERT INTO VAH_colores
	VALUES (8, 'AZUL MARINO');

INSERT INTO VAH_colores
	VALUES (9, 'ÍNDIGO');

INSERT INTO VAH_esc_col
	VALUES (3, 8);

INSERT INTO VAH_esc_col
	VALUES (3, 9);

INSERT INTO VAH_esc_col
	VALUES (3, 6);

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, apodo, nacionalidad)
	VALUES (4, '24-02-1960', 'Antonio', 'Ricardo', 'de Sousa', 'M', 00009625989, 'Rixxah', 'Brasileño');

INSERT INTO VAH_int_Hab
	VALUES (4, 1);

INSERT INTO VAH_hist_Integrantes
	VALUES (3, 4, '1-1-2001', 'NO', '31-12-2002');

INSERT INTO VAH_org_carnavales
	VALUES (3, 4, '1-1-2001', 2, '1-1-2001');

INSERT INTO VAH_org_carnavales
	VALUES (3, 4, '1-1-2001', 2, '1-1-2002');

--Inserts para las empresas
INSERT INTO VAH_personas_juridicas
	VALUES (1, 30872504000123, 'Itaú Unibanco Holding S.A.', 'PRIV', 'itaujudicial@itau-unibanco.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 11, 50191879, 1);

INSERT INTO VAH_personas_juridicas
	VALUES (2, 17155730000164, 'CEMIG', 'PRIV', 'ri@cemig.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 31, 35065024, 2);

INSERT INTO VAH_personas_juridicas
	VALUES (3, 06047087007222, 'Rede D''Or Sao Luiz S.A.', 'PRIV', 'centroestudos.jbq@saoluiz.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 21, 30034330, 3);

INSERT INTO VAH_escuelas
    VALUES (4, 1, 1, 
		'G.R.E.S. Estácio de Sá', 
		'27-02-1955', 
		'Av. Francisco Bicalho, 47 - Santo Cristo, Rio de Janeiro - RJ, 20220-310, Brasil',		
		CONCAT('El Estácio de Sá fue fundado el 7 de febrero de 1955, con el nombre de Unidos ',
			'de São Carlos, a partir de la fusión de las escuelas de samba Cada Ano Sai Melhor, ',
			'Recreio de São Carlos y Paraíso das Morenas.'
		)
	);

INSERT INTO VAH_escuelas
	VALUES (5, 1, 1, 
		'G.R.E.S. Caprichosos de Pilares', 
		'19-02-1949',
		'R. Faleiro, 1 - Pilares, Rio de Janeiro - RJ, 20771-090, Brasil',
		CONCAT('Caprichosos de Pilares fue fundada por una disidencia de Unidos de Terra Nova, ',
			'que era un colegio ubicado en la comarca conocida como Terra Nova, hoy parte de Pilares. ',
			'Cansados del descuido durante los desfiles y de los malos resultados de los Unidos de Terra Nova, ',
			'miembros de la escuela y bailarines de samba de Pilares decidieron fundar su propia escuela'
		)
	);

INSERT INTO VAH_escuelas
	VALUES (6, 1, 2, 
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

-- Inserts para Porto da Pedra

INSERT INTO VAH_escuelas (idEscuela, idEstado, idCiudad, nombre, fechaFundacion,direccionSede,historia)
	VALUES (7, 1, 1, 'G.R.E.S. Porto da Pedra', 
			'03-08-1978','Tv. João Silva, 84 - Porto da Pedra, São Gonçalo - RJ, 24436-000, Brasil',
			CONCAT('En los años setenta , había un club de fútbol en São Gonçalo llamado Porto da Pedra Futebol Clube , que tenía los colores rojo y blanco y reunía a los vecinos del barrio. Entre estos integrantes se formó la idea de formar una cuadra callejera, cuadra que desfiló en 1975 y 1976 por las calles de la ciudad. ', '') );

INSERT INTO VAH_colores
	VALUES (10,'ROJO');

INSERT INTO VAH_esc_col
	VALUES (7, 10);

INSERT INTO VAH_esc_col
	VALUES (7, 6);

INSERT INTO VAH_telefonos(codInt, codArea, numero, idEscuela)
	VALUES (55, 21, 26068623, 7);


INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad,apodo)
	VALUES (5, '23-04-1999', 'João', 'Benicio', 'Da Silva', 'M', 00005877085, 'Samuel', 'Brasileño','Godzilla');

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad)
	VALUES (6, '23-05-1989', 'Fabio', 'Montibelo', 'Da Silva', 'M', 00008847585, 'Jose', 'Brasileño');

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

--Inserts para las empresas

INSERT INTO VAH_personas_juridicas
	VALUES (7, 02429144000193, 'Cpfl Energia S.A.', 'PRIV', 'backofficetributario@cpfl.com.br');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 19, 37568020, 7);

INSERT INTO VAH_personas_juridicas
	VALUES (8, 26896348000100 , 'Habib’s', 'PRIV', 'habibs786@hotmail.com ');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 01, 274666786, 8);

INSERT INTO VAH_personas_juridicas
	VALUES (9, 4710439000126, 'Ultrapar', 'PRIV', ' imprensa@ultra.com.br.');

INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica)
	VALUES (55, 11, 31777014, 9);

--Inserts de Sao clemente
INSERT INTO VAH_escuelas (idEscuela, idEstado, idCiudad, nombre, fechaFundacion,direccionSede,historia)
	VALUES (8, 1, 1, 'G.R.E.S. São Clemente', 
			'25-10-1961','Av. Pres. Vargas, 3102 - Cidade Nova, Rio de Janeiro - RJ, 20210-031, Brasil',
			CONCAT('En 1951, un grupo de vecinos del barrio, encabezado por Ivo da Rocha Gomes, decidió crear un equipo de fútbol.Fue nombrado São Clemente Futebol Clube en referencia a la Rua São Clemente, donde vivía la mayoría de los jugadores. El equipo tenía los colores azul y blanco, inspirados en la Selección Carioca de Fútbol . El grupo entrenaba en la cancha de la UFRJ y participaba de campeonatos en Río de Janeiro y otras ciudades.', '') );

INSERT INTO VAH_colores
	VALUES (11,'NEGRO');

INSERT INTO VAH_esc_col
	VALUES (8, 11);

INSERT INTO VAH_esc_col
	VALUES (8, 1);

--Inserts Unión de la isla del gobernador

INSERT INTO VAH_escuelas (idEscuela, idEstado, idCiudad, nombre, fechaFundacion,direccionSede,historia)
	VALUES (9, 1, 1, 'G.R.E.S. União da Ilha do Governador',
			'07-03-1953','Estrada do Galeão, 322 - Cacuia, Rio de Janeiro - RJ, 21931-242, Brasil',
			CONCAT('A pesar de albergar el desfile de carnaval, Cacuia no contaba con ninguna escuela de samba representativa. El barrio tenía un equipo de fútbol, União Futebol Clube.  El equipo tricolor, azul, rojo y blanco, fue dirigido por el entrenador Maurício Gazelle. Sus jugadores vivían en la isla y competían en campeonatos locales.',''));

INSERT INTO VAH_esc_col
	VALUES (9,6);

INSERT INTO VAH_esc_col
	VALUES (9,10);

INSERT INTO VAH_esc_col
	VALUES (9,2);

--Inserts de los patrocinios

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(7,1,'01-01-2002',7);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(8,2,'01-01-2022',8);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(9,3,'01-01-2012',9);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(1,4,'01-01-2014',1);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(2,5,'01-01-2011',2);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur,fechaFin)
values(3,6,'01-01-2001',3,'01-01-2023');

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur,fechaFin)
values(7,7,'01-01-2007',7,'01-01-2015');

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(7,8,'01-01-2002',8);

INSERT INTO VAH_hist_Patrocinios(idEscuela,idPatrocinio,fechaInicio,idPersonaJur)
values(7,9,'01-01-2002',9);

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

INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad) 
VALUES (7, '04-07-1977', 'Edson', 'Marinho', 'Dattoli', 'M', 00005743284, 'Edson', 'Brasileño');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad, apodo) 
VALUES (8, '12-09-1983', 'Carlos', 'Leandro', 'Amorelli', 'M', 00005221184, 'Brasileño', 'Nene');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, segNom, nacionalidad, apodo) 
VALUES (9, '28-04-1964', ' Hélio', 'Nunes', 'Almeida', 'M', 00004991132, 'Carlos', 'Brasileño', 'Heles');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES (10, '31-05-1984', 'Juan', 'de Oliveira', 'Marinho', 'M', 00007448054,'Brasileño');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES (11, '26-09-1982', 'Maria', 'de Oliveira', 'Marinho', 'F', 00004548054,'Brasileño');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
VALUES (12, '12-05-1989', 'Roberta', 'de Oliveira', 'Marinho', 'F', 00005448054,'Brasileño');
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
	VALUES(13, '15-02-1974', 'Julio', 'Marinho', 'Dattoli', 'M', 00002544678, 'Brasileño');

INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 7, '1-1-2023', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (5, 8, '1-1-2017', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (6, 9, '1-1-2023', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 10, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 11, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 12, '1-1-2020', 'NO');
INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad) VALUES (4, 13, '1-1-2019', 'NO');

INSERT INTO VAH_roles VALUES (5, 'PORTA-BANDEIRA', 'Portador de la Bandera de la Escuela');
INSERT INTO VAH_roles VALUES (6, 'COREOGRAFO', 'Diseñador de bailes y actos');
INSERT INTO VAH_roles VALUES (7, 'ESTILISTA', 'Diseñador del vestuario');
INSERT INTO VAH_roles VALUES (8, 'ESCENÓGRAFO', 'Diseñador del escenario y otros');
INSERT INTO VAH_roles VALUES (9, 'ESCULTOR', 'Creador de elementos de la escenografía');

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

-- Patrocinadores
INSERT INTO VAH_personas_Juridicas VALUES (4, 434725340, 'JBS', 'PRIV', 'jbs@comjbs.com.br'); -- JBS    
INSERT INTO VAH_personas_Juridicas VALUES (5, 524725322, 'MARFRIG GLOBAL FOODS', 'PRIV', 'marfrig@mfcompany.com.br'); -- Marfrig Global Foods
INSERT INTO VAH_personas_Juridicas VALUES (6, 632472532, 'WEG', 'PRIV', 'weg@wegindus.com.br'); -- WEG
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 99972539, 4);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 82344558, 5);
INSERT INTO VAH_telefonos(codInt, codArea, numero, idPJuridica) VALUES (55, 21, 71213127, 6);

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (4, 12, 4, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (5, 13, 5, '1-1-2017');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (6, 14, 6, '1-1-2020');

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (4, 15, 6, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio, fechaFin) VALUES (5, 16, 5, '1-1-2007','1-1-2010');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (6, 17, 4, '1-1-2002');

INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio, fechaFin) VALUES (4, 18, 3, '1-1-2012','1-1-2019');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio, FechaFin) VALUES (5, 19, 2, '1-1-2017','1-1-2018');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaJur, fechaInicio) VALUES (6, 20, 1, '1-1-2010');

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

INSERT INTO VAH_habilidades VALUES (4, 'COREÓGRAFO', 'Destaca como planificador de bailes');
INSERT INTO VAH_habilidades VALUES (5, 'DIRECTOR', 'Dirige y ordena bailes, personas');
INSERT INTO VAH_habilidades VALUES (6, 'ESCENÓGRAFO', 'Organiza los elementos visuales para espectáculos');
INSERT INTO VAH_habilidades VALUES (7, 'ESTILISTA', 'Dirige la elección e implementación de vestimentas');
INSERT INTO VAH_habilidades VALUES (8, 'DISEÑADOR', 'Destaca en el diseño de vestuarios');
INSERT INTO VAH_habilidades VALUES (9, 'COMPOSITOR', 'Destaca en las composiciones musicales');

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

INSERT INTO VAH_personas_Naturales VALUES (1, 00005743284, 'Jose', 'Manrinho', 'Briceño', 'jmanrhino112@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (2, 00006143333, 'Carlos', 'Briceño', 'Perez', 'cbribripe112@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (3, 00008743444, 'Pedro', 'Parra', 'Rivera', 'pedrrrariv2@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (4, 00008741234, 'Lionel', 'Rivera', 'Alvarez', 'lioalv123@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (5, 00007743224, 'Javier', 'Alvarez', 'Parra', 'jaalvapa11@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (6, 00004712584, 'Maria', 'Parra', 'Briceño', 'mriparbrice22@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (7, 00006755584, 'Rosa', 'Rivera', 'Alvarez', 'rosarirez22@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (8, 00005743243, 'Karla', 'Manrinho', 'Briceño', 'karmarnhic23@gmail.com');
INSERT INTO VAH_personas_Naturales VALUES (9, 00006741241, 'Karina', 'Rivera', 'Rivera', 'karivriv4242@gmail.com');

--Historico de patrocinios de personas naturales
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio) VALUES (6, 21, 1, '1-1-2010');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio) VALUES (2, 22, 2, '1-1-2012');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio,FechaFin) VALUES (1, 23, 1, '1-1-2014','01-01-2023');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio,fechaFin) VALUES (1, 24, 1, '1-1-2015','01-01-2019');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio,fechaFin) VALUES (3, 25, 1, '1-1-2012','01-01-2022');
INSERT INTO VAH_hist_Patrocinios(idEscuela, idPatrocinio, idPersonaNat, fechaInicio) VALUES (4, 26, 1, '1-1-2002');

--Donaciones de personas naturales
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (6,21, 10, '04-04-2013', 1000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (6,21, 11, '04-04-2014', 1500);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (2,22, 12, '04-04-2013', 1500);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (2,22, 13, '04-04-2020', 1500);


INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (4, 12, 1, '04-04-2013', 1000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (4, 12, 2, '07-04-2013', 4000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (4, 12, 3, '14-04-2013', 200);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (4, 12, 4, '28-04-2013', 2000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (4, 12, 5, '14-09-2013', 5000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (5, 13, 6, '14-07-2018', 200);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (5, 13, 7, '07-02-2019', 2000);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (6, 14, 8, '04-10-2020', 800);
INSERT INTO VAH_donaciones(idEscuela, idPatrocinio, idDonacion, fechaDonacion, monto) VALUES (6, 14, 9, '07-07-2021', 400);

--Inserts para histórico de eventos
INSERT INTO vah_hist_eventos_anual_sem 
	VALUES (1, 1, 'Noche de Samba', 48, 'NS', '07-02-2022', '07-02-2022', 53, NULL);

INSERT INTO vah_hist_eventos_anual_sem
	VALUES (1, 2, 'Ensayo abierto', 35, 'G', '20-02-2022', '20-02-2022', 117, 'Último ensayo antes del carnaval, abierto a la audiencia');

INSERT INTO vah_hist_eventos_anual_sem
	VALUES (2, 3, 'Noche de Samba', 50, 'NS', '10-02-2022', '10-02-2022', 66, NULL);

INSERT INTO vah_hist_eventos_anual_sem
	VALUES (3, 4, 'Karaoke', 24, 'G', '25-05-2022', '25-05-2022', 150, 'Noche de Karaoke con los temas de la escuela');

INSERT INTO vah_hist_eventos_anual_sem
	VALUES (4, 5, 'Noche de Samba', 48, 'NS', '02-02-2022', '02-02-2022', 45, NULL);

INSERT INTO vah_hist_eventos_anual_sem
	VALUES (4, 6, 'Ensayo Abierto', 30, 'G', '22-02-2022', '22-02-2022', 98, NULL);

INSERT INTO vah_hist_eventos_anual_sem 
	VALUES (5, 7, 'Noche de Samba', 45, 'NS', '06-02-2022', '06-02-2022', 57, NULL);

INSERT INTO vah_hist_eventos_anual_sem 
	VALUES (6, 8, 'Noche de Samba', 51, 'NS', '10-02-2022', '10-02-2022', 71, NULL);

INSERT INTO vah_hist_eventos_anual_sem 
	VALUES (8, 9, 'Noche de Samba', 55, 'NS', '07-02-2022', '07-02-2022', 36, NULL);


--Inserts para premios especiales
INSERT INTO VAH_premios_Especiales
	VALUES (1, 'Estandarte de Oro', 'Escuela', 'Estandarte de Oro otorgado a una Escuela', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales
	VALUES (2, 'Estandarte de Oro', 'Samba-Enredo (Especial)', 'Estandarte de Oro otorgado por la Samba-Enredo', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales
	VALUES (3, 'Estandarte de Oro', 'Samba-Enredo (Grupo 2)', 'Estandarte de Oro otorgado por la Samba-Enredo', NULL, 1, 1);

INSERT INTO VAH_premios_Especiales
	VALUES (4, 'S@mba-Net', 'Mejor Desfile', 'Premio S@mba-Net al mejor desfile del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales
	VALUES (5, 'S@mba-Net', 'Intérprete', 'Premio S@mba-Net al mejor intérprete del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales
	VALUES (6, 'S@mba-Net', 'Comisión de frente', 'Premio S@mba-Net a la mejor comisión de frente', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales
	VALUES (7, 'Tamborín de Oro', 'Intérprete', 'Tamborín de Oro al mejor intérprete del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales
	VALUES (8, 'Plumas & Paetés', 'Coreógrafo', 'Premio al mejor coreógrafo del año', 1, NULL, NULL);

INSERT INTO VAH_premios_Especiales
	VALUES (9, 'Plumas & Paetés', 'Maquillador', 'Premio al mejor maquillador del año', 1, NULL, NULL);
INSERT INTO VAH_integrantes(idIntegrante, fechaNacimiento, primNom, primAp, segAp, genero, cpf, nacionalidad)
	VALUES(14, '12-08-1958', 'Mauro ', 'Quintaes', 'Joao', 'M', 00001044678, 'Brasileño');

INSERT INTO VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso, autoridad,fechaRetiro) VALUES (7, 14, '1-1-1995', 'NO','31-1-1998');


INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo) VALUES (7, 1, '01-01-1979','Fiesta junina','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo) VALUES (7, 2, '01-01-1980','Temporada','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 3, '01-01-1982','En el reino de la fantasía','','SAMBA ENREDO');
INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 4, '01-01-1994','Nuevo Sol de la Mañana','','SAMBA ENREDO');
--Inserts de sambas de mauro quintaes

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 5, '01-01-1995','Patria, ciudad en busca de la felicidad','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 21, '01-01-1996','La juerga en el mundo - Un carnaval de carnavales','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7,22, '01-01-1998','Samba de pies y manos en el aire, ¡esto es un robo!','','SAMBA ENREDO');
--

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 6, '01-01-2001','Un sueño posible: crecer y vivir es ahora la ley','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (7, 7, '01-01-2023','La invención del Amazonas un sueño posible: crecer y vivir es ahora la ley','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 8, '01-01-1980','Delmiro Gouveia','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 9, '01-01-1987','As Três Faces da Moeda	','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 10, '01-01-1999','O Dono da Terra','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 11, '01-01-2010','É segredo!','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 12, '01-01-2012','O Dia em Que Toda a Realeza Desembarcou na Avenida para Coroar o Rei Luiz do Sertão','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 13, '01-01-2014','Acelera, Tijuca!','','SAMBA ENREDO');
--Sambas de wantuir

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 14, '01-01-2004','O sonho da criação e a criação do sonho: a arte da ciência no tempo do impossível','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 15, '01-01-2005','Entrou por em lado, saiu pelo outro… quem quiser que invente outro!','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 16, '01-01-2006','Ouvindo tudo o que vejo, vou vendo tudo o que ouço','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 17, '01-01-2007','De lambida em lambida, a Tijuca dá um click na avenida','','SAMBA ENREDO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 18, '01-01-2008','Vou juntando o que eu quiser, minha mania vale ouro. Sou Tijuca, trago a arte colecionando','','SAMBA LOLOCO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 19, '01-01-2019','Cada macaco no seu galho. Ó, meu pai, me dê o pão que eu não morro de fome!','','SAMBA EMBOLO');

INSERT INTO VAH_sambas(idEscuela,idSamba,anioCarnaval,titulo,letra,tipo)  VALUES (1, 20, '01-01-2020','Onde moram os sonhos','','FREVO');

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

INSERT INTO VAH_sambas VALUES (4, 23, '01-01-1958','Glória mil - Santos Dumont','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (4, 24, '01-01-1964','"IV séculos de glória da Bahia"','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (4, 25, '01-01-1961','Música, poesia e arte','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (4, 26, '01-01-2003','Um banho da natureza - Cachoeiras de Macacu','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (5, 27, '01-01-1964','IV Centenário do Rio de Janeiro','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (5, 28, '01-01-1992','Brasil feito a mão... do barro ao carnaval','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (5, 29, '01-01-2004','Xuxa e seu reino encantado no carnaval da imaginação','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (6, 30, '01-01-1979','Ainda um paraíso tropical','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (6, 31, '01-01-1980','Os três encantos do rei','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (6, 32, '01-01-1999','Anita Garibaldi - Heroína das sete magias','','SAMBA ENREDO');
INSERT INTO VAH_sambas VALUES (6, 33, '01-01-2000','Brasil: visões de paraísos e infernos','','SAMBA ENREDO');
CREATE TABLE VAH_estados(
	idEstado NUMERIC(2) PRIMARY KEY NOT NULL, 
	nombre VARCHAR(40) UNIQUE NOT NULL,
	region VARCHAR(30) NOT NULL
);

CREATE TABLE VAH_ciudades(
	idEstado NUMERIC(2) NOT NULL CONSTRAINT FK_ESTADO REFERENCES VAH_estados(idEstado),
	idCiudad NUMERIC(3) NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	CONSTRAINT PK_CIUDAD PRIMARY KEY(idEstado, idCiudad)
);

CREATE TABLE VAH_escuelas(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT PK_ESCUELA PRIMARY KEY,
	idEstado NUMERIC(2) NOT NULL,
	idCiudad NUMERIC(3) NOT NULL,
	CONSTRAINT FK_CIUDAD FOREIGN KEY(idEstado, idCiudad) REFERENCES VAH_ciudades(idEstado, idCiudad),
	nombre VARCHAR(50) NOT NULL UNIQUE,
	fechaFundacion DATE NOT NULL,
	direccionSede VARCHAR(100) NOT NULL,
	historia VARCHAR(500) NOT NULL
);

CREATE TABLE VAH_hist_Titulos(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	anio DATE NOT NULL,
	CONSTRAINT PK_HistTitulos PRIMARY KEY(idEscuela, anio),
	grupo VARCHAR(30),
	monto NUMERIC CHECK(monto >= 1)
);

CREATE TABLE VAH_colores(
	idColor NUMERIC(3) NOT NULL CONSTRAINT PK_COLOR PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE VAH_esc_Col(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idColor NUMERIC(3) NOT NULL CONSTRAINT FK_COLOR REFERENCES VAH_colores(idColor),
	CONSTRAINT PK_ESC_COL PRIMARY KEY(idEscuela, idColor)
);

CREATE TABLE VAH_sambas(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idSamba NUMERIC NOT NULL,
	CONSTRAINT PK_SAMBA PRIMARY KEY(idEscuela, idSamba),
	anioCarnaval DATE NOT NULL,
	titulo VARCHAR(120) NOT NULL,
	letra VARCHAR(300) NOT NULL,
	tipo VARCHAR(20) NOT NULL CHECK(tipo in('SAMBA ENREDO','SAMBA LOLOCO','SAMBA EMBOLO','MARCHINHA','FREVO','MARACATO','SAMBAREGGAE'))
);

CREATE TABLE VAH_hist_Eventos_Anual_Sem(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idEvento NUMERIC NOT NULL,
	CONSTRAINT PK_HIST_EVENTOS PRIMARY KEY(idEscuela, idEvento),
	nombre VARCHAR(20) NOT NULL,
	costoUnitario NUMERIC NOT NULL CHECK(costoUnitario>=1),
	tipoEvento VARCHAR(2) NOT NULL CHECK(tipoEvento IN ('NS', 'G')),
	fechaInicio DATE NOT NULL,
	fechaFin DATE NOT NULL CHECK(fechaFin >= fechaInicio),
	totalAsistencias NUMERIC(4) CHECK(totalAsistencias >= 1),
	descripcion VARCHAR(80)
);

CREATE TABLE VAH_personas_Naturales( 
	idPersona NUMERIC(8) NOT NULL CONSTRAINT PK_PERSONA_NATURAL PRIMARY KEY,
	cpf NUMERIC(11) NOT NULL UNIQUE CHECK(cpf >= 1),
	primNom VARCHAR(15) NOT NULL,
	primAp VARCHAR(15) NOT NULL,
	segAp VARCHAR(15) NOT NULL,
	email VARCHAR(50) NOT NULL,
	segNom VARCHAR(15)
);

CREATE TABLE VAH_personas_Juridicas(
	idEmpresa NUMERIC(5) NOT NULL CONSTRAINT PK_PERSONA_JURIDICA PRIMARY KEY,
	cpnj NUMERIC(14) NOT NULL UNIQUE CHECK(cpnj >= 191),
	nombre VARCHAR(50) NOT NULL,
	tipoEmpresa VARCHAR(4) NOT NULL CHECK(tipoEmpresa in ('PUB', 'PRIV')),
	email VARCHAR(50) NOT NULL
);

CREATE TABLE VAH_telefonos(
	codInt NUMERIC(5) NOT NULL,
	codArea NUMERIC(4) NOT NULL,
	numero NUMERIC(15) NOT NULL,
	CONSTRAINT PK_TELEFONO PRIMARY KEY(codInt, codArea, numero),
	idEscuela NUMERIC(3) CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idPNatural NUMERIC(8) CONSTRAINT FK_PERSONA_NATURAL REFERENCES VAH_personas_Naturales(idPersona),
	idPJuridica NUMERIC(5) CONSTRAINT FK_PERSONA_JURIDICA REFERENCES VAH_personas_Juridicas(idEmpresa)
);

CREATE TABLE VAH_hist_Patrocinios(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idPatrocinio NUMERIC NOT NULL,
	CONSTRAINT PK_HIST_PATROCINIO PRIMARY KEY(idEscuela, idPatrocinio),
	fechaInicio DATE NOT NULL,
	idPersonaNat NUMERIC(8) CONSTRAINT FK_PERSONA_NATURAL REFERENCES VAH_personas_Naturales(idPersona),
	idPersonaJur NUMERIC(5) CONSTRAINT FK_PERSONA_JURIDICA REFERENCES VAH_personas_Juridicas(idEmpresa),
	fechaFin DATE CHECK(fechaFin >= fechaInicio)
);

CREATE TABLE VAH_donaciones(
	idEscuela NUMERIC(3) NOT NULL,
	idPatrocinio NUMERIC NOT NULL,
	CONSTRAINT FK_PATROCINIO FOREIGN KEY(idEscuela, idPatrocinio) REFERENCES VAH_hist_Patrocinios(idEscuela, idPatrocinio),
	idDonacion NUMERIC NOT NULL,
	CONSTRAINT PK_DONACION PRIMARY KEY(idEscuela, idPatrocinio, idDonacion),
	fechaDonacion DATE NOT NULL,
	monto NUMERIC NOT NULL CHECK(monto >= 1)
);

CREATE TABLE VAH_integrantes(
	idIntegrante NUMERIC(8) NOT NULL CONSTRAINT PK_INTEGRANTE PRIMARY KEY,
	fechaNacimiento DATE NOT NULL,
	primNom VARCHAR(15) NOT NULL,
	primAp VARCHAR(15) NOT NULL,
	segAp VARCHAR(15) NOT NULL,
	genero VARCHAR(1) NOT NULL CHECK(genero IN ('M', 'F')),
	nacionalidad  VARCHAR(20) NOT NULL,
	apodo VARCHAR(15),
	cpf NUMERIC(11) CHECK(cpf >= 1),
	segNom VARCHAR(15)
);

CREATE TABLE VAH_hist_Integrantes(
	idEscuela NUMERIC(3) NOT NULL CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idIntegrante NUMERIC(8) NOT NULL CONSTRAINT FK_INTEGRANTE REFERENCES VAH_integrantes(idIntegrante),
	fechaIngreso DATE NOT NULL,
	CONSTRAINT PK_HIST_INTEGRANTE PRIMARY KEY(idIntegrante, idEscuela, fechaIngreso),
	autoridad VARCHAR(2) NOT NULL CHECK(autoridad IN ('SI', 'NO')),
	fechaRetiro DATE CHECK(fechaRetiro >= fechaIngreso)
);

CREATE TABLE VAH_autores( 
	idEscuelaSamba NUMERIC(3) NOT NULL,
	idSamba NUMERIC NOT NULL,
	CONSTRAINT FK_SAMBA FOREIGN KEY(idEscuelaSamba, idSamba) REFERENCES VAH_sambas(idEscuela, idSamba),
	idEscuelaIntegrante NUMERIC(3) NOT NULL,
	idIntegrante NUMERIC(8) NOT NULL,
	fechaIngreso DATE NOT NULL,
	CONSTRAINT FK_HIST_INTEGRANTE FOREIGN KEY(idEscuelaIntegrante, idIntegrante, fechaIngreso) REFERENCES VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso),
	CONSTRAINT PK_AUTOR PRIMARY KEY(idEscuelaSamba, idSamba, idEscuelaIntegrante, idIntegrante, fechaIngreso)
);

CREATE TABLE VAH_roles(
	idRol NUMERIC(5) NOT NULL CONSTRAINT PK_ROL PRIMARY KEY,
	nombreRol VARCHAR(30) NOT NULL,
	descripcion VARCHAR(80) NOT NULL
);

CREATE TABLE VAH_org_Carnavales(
	idEscuela NUMERIC(3) NOT NULL,
	idIntegrante NUMERIC(8) NOT NULL,
	fechaIngreso DATE NOT NULL,
	CONSTRAINT FK_HIST_INTEGRANTE FOREIGN KEY(idIntegrante, idEscuela, fechaIngreso) REFERENCES VAH_hist_Integrantes(idIntegrante, idEscuela, fechaIngreso),
	idRol NUMERIC(5) NOT NULL CONSTRAINT FK_ROL REFERENCES VAH_roles(idRol),
	anioCarnaval DATE NOT NULL,
	CONSTRAINT PK_ORGANIZACION_CARNAVAL PRIMARY KEY(idEscuela, idIntegrante, fechaIngreso, idRol, anioCarnaval)
);

CREATE TABLE VAH_premios_Especiales(
	idPremioEspecial NUMERIC NOT NULL CONSTRAINT PK_PREMIO_ESPECIAL PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	tipo VARCHAR(30) NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
	idEstado NUMERIC(2) CONSTRAINT FK_ESTADO REFERENCES VAH_estados(idEstado),
	idEstadoCiudad NUMERIC(2),
	idCiudad NUMERIC(3),
	CONSTRAINT FK_CIUDAD FOREIGN KEY(idEstadoCiudad, idCiudad) REFERENCES VAH_ciudades(idEstado, idCiudad)
);

CREATE TABLE VAH_ganadores(
	idPremioEspecial NUMERIC NOT NULL CONSTRAINT FK_PREMIO_ESPECIAL REFERENCES VAH_premios_Especiales(idPremioEspecial),
	anio DATE NOT NULL,
	CONSTRAINT PK_GANADORES PRIMARY KEY(idPremioEspecial, anio),
	idEscuela NUMERIC(3) CONSTRAINT FK_ESCUELA REFERENCES VAH_escuelas(idEscuela),
	idEscuelaIntegrante NUMERIC(3),
	idIntegrante NUMERIC(8) , 
	fechaIngreso DATE,
	CONSTRAINT FK_HIST_INTEGRANTE FOREIGN KEY(idEscuelaIntegrante, idIntegrante, fechaIngreso) REFERENCES VAH_hist_Integrantes(idEscuela, idIntegrante, fechaIngreso)
);

CREATE TABLE VAH_parentescos(
	idIntegrante NUMERIC(8) NOT NULL CONSTRAINT FK_INTEGRANTE REFERENCES VAH_integrantes(idIntegrante),
	idPariente NUMERIC(8) NOT NULL CONSTRAINT FK_PARIENTE REFERENCES VAH_integrantes(idIntegrante),
	CONSTRAINT PK_PARENTESCO PRIMARY KEY(idIntegrante, idPariente),
	tipoParentesco VARCHAR(1) NOT NULL CHECK(tipoParentesco IN ('S', 'P')),
	nexo VARCHAR(20) NOT NULL
);

CREATE TABLE VAH_habilidades(
	idHabilidad NUMERIC(4) NOT NULL CONSTRAINT PK_HABILIDAD PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	descripcion VARCHAR(80) NOT NULL
);

CREATE TABLE VAH_int_Hab(
	idIntegrante NUMERIC(8) NOT NULL CONSTRAINT FK_INTEGRANTE REFERENCES VAH_integrantes(idIntegrante),
	idHabilidad NUMERIC(4) NOT NULL CONSTRAINT FK_HABILIDAD REFERENCES VAH_habilidades(idHabilidad),
	CONSTRAINT PK_INT_HAB PRIMARY KEY(idIntegrante, idHabilidad)
);
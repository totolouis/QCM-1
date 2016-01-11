DROP TABLE IF EXISTS "Eleves";
CREATE TABLE Eleves
(
   idEleve              int not null,
   nomEleve             varchar(254),
   prenomEleve          varchar(254),
   mdpEleve             varchar(254),
   primary key (idEleve)
   
);
DROP TABLE IF EXISTS "Note";
CREATE TABLE "Note" 
(
   "idEleve"            INTEGER              not null,
   "idQcm"              INTEGER              not null,
   "note"               FLOAT,
   constraint PK_NOTE primary key ("idEleve", "idQcm")
 FOREIGN key (idEleve) REFERENCES Eleves(idEleve)
  FOREIGN key (idQcm) REFERENCES Qcm(idQcm)
);
DROP TABLE IF EXISTS "Professeur";
CREATE TABLE "Professeur" 
(
   "matiere"            VARCHAR2(254),
   "idProfesseur"       INTEGER              not null,
   "nom"                VARCHAR2(254),
   "prenom"             VARCHAR2(254),
   "mdp"                VARCHAR2(254),
   constraint PK_PROFESSEUR primary key ("idProfesseur")
);
DROP TABLE IF EXISTS "Qcm";
CREATE TABLE "Qcm" 
(
   "idQcm"              INTEGER              not null,
   "idProfesseur"       INTEGER,
   "titre"              VARCHAR2(254),
   "dateDeMiseEnLigne"  DATE,
   "descritption"       VARCHAR2(254),
   constraint PK_QCM primary key ("idQcm")
   FOREIGN key (idProfesseur) REFERENCES Professeur(idProfesseur)
);
DROP TABLE IF EXISTS "Questions";
CREATE TABLE "Questions" 
(
   "idQcm"              INTEGER              not null,
   "idQuestion"         INTEGER              not null,
   "intitule"           VARCHAR2(254),
   constraint PK_QUESTIONS primary key ("idQcm", "idQuestion")
FOREIGN key (idQcm) REFERENCES QCM(idQcm)
);
DROP TABLE IF EXISTS "Reponses";
CREATE TABLE "Reponses" 
(
   "idQcm"              INTEGER              not null,
   "idQuestion"         INTEGER              not null,
   "idReponse"          INTEGER              not null,
   "intituleRep"        VARCHAR2(254),
   "bonneReponse"       SMALLINT,
   constraint PK_REPONSES primary key ("idQcm", "idQuestion", "idReponse")
FOREIGN key (idQcm) REFERENCES Qcm(idQcm)
  FOREIGN key (idQuestion) REFERENCES Questions(idQuestion) 
);

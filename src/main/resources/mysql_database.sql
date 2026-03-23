-- CREATE DATABASE IF NOT EXISTS university; para crearla y sin problemas
use university;

CREATE TABLE IF NOT EXISTS careers(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    duration_semesters INT NOT NULL DEFAULT 10
);

CREATE TABLE IF NOT EXISTS students(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    lastname VARCHAR(100),
    email VARCHAR(50),
    career_id INT NOT NULL,
    CONSTRAINT fk_career
		FOREIGN KEY(career_id)
        REFERENCES careers(id)
);

INSERT INTO careers(name, duration_semesters) VALUES
('MEDICINA', 12),
('PSICOLOGIA', 10);

INSERT INTO students(name, lastname, email, career_id) VALUES
('NICOLAS', 'BASTIDAS', 'nico@email.com', 1),
('MICHAEL', 'LAGOS', 'MICHE@email.com', 2);








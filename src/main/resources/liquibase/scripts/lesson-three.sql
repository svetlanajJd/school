-- liquibase formated sql
-- changeset sgorban:1
CREATE INDEX student_name_index ON student (name);
-- changeset sgorban:2
CREATE INDEX faculty_nc_index ON faculty (name,color);

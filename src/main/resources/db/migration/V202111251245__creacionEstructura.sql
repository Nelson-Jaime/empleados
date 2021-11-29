
CREATE TABLE IF NOT EXISTS proveedores (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(75) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  ciudad VARCHAR(75) NOT NULL,
  provincia VARCHAR(50) NOT NULL,
  telefono VARCHAR(50) NOT NULL
) ;

CREATE TABLE IF NOT EXISTS categoria (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(75) NOT NULL
) ;

CREATE TABLE IF NOT EXISTS pieza (
  id BIGSERIAL PRIMARY KEY,
  fk_idCategoria BIGINT NOT NULL REFERENCES categoria(id),
  nombre VARCHAR(75) NOT NULL,
  precio INTEGER NOT NULL
) ;

CREATE TABLE IF NOT EXISTS suministro (
  id BIGSERIAL PRIMARY KEY,
  fk_idProveedor BIGINT NOT NULL REFERENCES proveedores(id),
  fk_idPieza BIGINT NOT NULL REFERENCES pieza(id),
  fecha TIMESTAMP NOT NULL,
  cantidad INTEGER NOT NULL
) ;
CREATE TABLE IF NOT EXISTS chanson (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255),
    artiste VARCHAR(255),
    paroles TEXT
);
CREATE TABLE resume
(
 UUID CHAR(36) PRIMARY KEY NOT NULL,
 FULL_NAME TEXT NOT NULL
)

CREATE TABLE contact
(
	ID SERIAL PRIMARY KEY,
	TYPE TEXT NOT NULL,
	VALUE TEXT NOT NULL,
	RESUME_UUID CHAR(36) NOT NULL,
	CONSTRAINT CONTACT_RESUME_UUID_FK FOREIGN KEY (RESUME_UUID) REFERENCES resume (UUID) ON DELETE CASCADE
);

CREATE UNIQUE INDEX CONTACT_UUID_TYPE_INDEX ON contact (RESUME_UUID, TYPE);

CREATE TABLE section (
                         id          SERIAL PRIMARY KEY,
                         resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
                         type        TEXT     NOT NULL,
                         content     TEXT     NOT NULL
);
CREATE UNIQUE INDEX section_idx
    ON section (resume_uuid, type);
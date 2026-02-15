CREATE TABLE reactive_db.tbl_departments_tm (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    version INTEGER DEFAULT 0
);

CREATE TABLE reactive_db.tbl_users_tm (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    department_id BIGINT,
    birthdate DATE,
    last_login_date TIMESTAMP WITH TIME ZONE,
    status BOOLEAN DEFAULT TRUE,
    version INTEGER DEFAULT 0
);

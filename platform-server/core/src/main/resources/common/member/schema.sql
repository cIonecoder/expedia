DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS member_info;

CREATE TABLE member(
    id           INT(11)  unsigned auto_increment COMMENT '일련번호',
    email        VARCHAR(255) NOT NULL COMMENT '이메일',
    password     VARCHAR(255) NOT NULL COMMENT '패스워드',
    external_id  VARCHAR(255) DEFAULT NULL COMMENT 'OAuth 연동 아이디',
    active       TINYINT(1) NOT NULL DEFAULT 1 COMMENT '활성화 여부',
    created_at  DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '등록일시',
    created_by  VARCHAR(100) NOT NULL DEFAULT 'SYSTEM' COMMENT '등록자',
    last_modified_at  DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '수정일시',
    last_modified_by  VARCHAR(100) NOT NULL DEFAULT 'SYSTEM' COMMENT '수정자',
    PRIMARY KEY (id),
    UNIQUE (email)
);

CREATE TABLE member_info(
    id              INT(11)  unsigned auto_increment COMMENT '유저 정보 일련번호',
    account_id  INT(11) unsigned NOT NULL COMMENT '유저 계정 일련번호',
    last_name  VARCHAR(50) NOT NULL COMMENT '성',
    first_name VARCHAR(100) NOT NULL COMMENT '이름',
    birth_year CHAR(4) DEFAULT NULL COMMENT '생년월일 연도',
    birth_month CHAR(2) DEFAULT NULL COMMENT '생년월일 월',
    birth_date CHAR(2) DEFAULT NULL COMMENT '생년월일 일',
    gender CHAR(1)  DEFAULT NULL COMMENT '성별',
    phone_country_code VARCHAR(20) DEFAULT NULL COMMENT '연락처 국가 코드',
    phone      VARCHAR(20) DEFAULT NULL COMMENT '연락처',
    emergency_phone_country_code VARCHAR(20) DEFAULT NULL COMMENT '비상 연락처 국가 코드',
    emergency_phone      VARCHAR(20) DEFAULT NULL COMMENT '비상 연락처',
    created_at  DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '등록일시',
    created_by  VARCHAR(100) NOT NULL COMMENT '등록자',
    last_modified_at  DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '수정일시',
    last_modified_by  VARCHAR(100) NOT NULL  COMMENT '수정자',
    PRIMARY KEY (id)
);
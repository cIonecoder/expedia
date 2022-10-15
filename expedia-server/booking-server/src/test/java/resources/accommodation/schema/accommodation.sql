DROP TABLE IF EXISTS ACCOMMODATION CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_ROLE CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_ROOM CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_ROOM_FEE CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_ROOM_INFO CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_GROUP_COMMON_CODE CASCADE;
DROP TABLE IF EXISTS ACCOMMODATION_COMMON_CODE CASCADE;

CREATE TABLE ACCOMMODATION (
                               ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                               ACCOMMODATION_NAME VARCHAR(255) NOT NULL,
                               ACCOMMODATION_TYPE VARCHAR(255) NOT NULL,
                               BIZNO VARCHAR(255) NOT NULL,
                               CHECKIN_DESCRIPTION VARCHAR(255) NOT NULL,
                               CHECKIN_START_TIME TIME NOT NULL,
                               CHECKOUT_END_TIME TIME NOT NULL,
                               CITY VARCHAR(255) NOT NULL,
                               STATE VARCHAR(255) NOT NULL,
                               STREET VARCHAR(255) NOT NULL,
                               TEL_NO VARCHAR(255) NOT NULL,
                               ZIPCODE VARCHAR(255) NOT NULL,
                               COUNTRY_CD VARCHAR(255) NOT NULL,
                               MIN_CHECKIN_AGE INTEGER NOT NULL,
                               RESPE_EMAIL VARCHAR(255) NOT NULL,
                               RESPE_HPNO VARCHAR(255) NOT NULL,
                               RESPE_USER_ID VARCHAR(255) NOT NULL,
                               CREATED_AT TIMESTAMP NOT NULL,
                               CREATED_BY VARCHAR(255) NOT NULL,
                               LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                               LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                               PRIMARY KEY (ID)
);


CREATE TABLE ACCOMMODATION_ROLE (
                                    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                    ACCOMMODATION_ID BIGINT NOT NULL,
                                    PROG_STATUS_CD VARCHAR(255),
                                    STOPPED_RSN VARCHAR(255),
                                    STOPPED_DTS VARCHAR(255),
                                    CREATED_AT TIMESTAMP NOT NULL,
                                    CREATED_BY VARCHAR(255) NOT NULL,
                                    LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                    LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                    PRIMARY KEY (ID)
);

CREATE TABLE ACCOMMODATION_ROOM (
                                    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                    ACCOMMODATION_ID BIGINT NOT NULL,
                                    ROOM_TYPE VARCHAR(255) NOT NULL,
                                    ROOM_NAME VARCHAR(255) NOT NULL,
                                    MAX_ENTRANCE_CNT INTEGER NOT NULL,
                                    STOCK INTEGER NOT NULL,
                                    CREATED_AT TIMESTAMP NOT NULL,
                                    CREATED_BY VARCHAR(255) NOT NULL,
                                    LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                    LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                    PRIMARY KEY (ID)
);

CREATE TABLE ACCOMMODATION_ROOM_FEE (
                                        ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                        ACCOMMODATION_ROOM_ID BIGINT NOT NULL,
                                        ACTIVE INTEGER NOT NULL,
                                        FEE DECIMAL(19, 2) NOT NULL,
                                        FEE_NAME VARCHAR(255) NOT NULL,
                                        CREATED_AT TIMESTAMP NOT NULL,
                                        CREATED_BY VARCHAR(255) NOT NULL,
                                        LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                        LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                        PRIMARY KEY (ID)
);

CREATE TABLE ACCOMMODATION_ROOM_INFO (
                                         ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                         ACCOMMODATION_ROOM_ID BIGINT NOT NULL,
                                         ACCOMMODATION_COMMON_CODE_ID BIGINT NOT NULL,
                                         ACTIVE INTEGER NOT NULL,
                                         CREATED_AT TIMESTAMP NOT NULL,
                                         CREATED_BY VARCHAR(255) NOT NULL,
                                         LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                         LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                         PRIMARY KEY (ID)
);

CREATE TABLE ACCOMMODATION_GROUP_COMMON_CODE (
                                                 ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                                 GRP_CODE VARCHAR(255) NOT NULL,
                                                 GRP_CODE_NAME VARCHAR(255) NOT NULL,
                                                 GRP_CODE_DESC VARCHAR(255) NOT NULL,
                                                 CREATED_AT TIMESTAMP NOT NULL,
                                                 CREATED_BY VARCHAR(255) NOT NULL,
                                                 LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                                 LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                                 PRIMARY KEY (ID)
);

CREATE TABLE ACCOMMODATION_COMMON_CODE (
                                           ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
                                           ACCOMMODATION_GROUP_COMMON_CODE_ID BIGINT NOT NULL,
                                           CODE VARCHAR(255) NOT NULL,
                                           CODE_NAME VARCHAR(255) NOT NULL,
                                           CODE_DESC VARCHAR(255) NOT NULL,
                                           CREATED_AT TIMESTAMP NOT NULL,
                                           CREATED_BY VARCHAR(255) NOT NULL,
                                           LAST_MODIFIED_AT TIMESTAMP NOT NULL,
                                           LAST_MODIFIED_BY VARCHAR(255) NOT NULL,
                                           PRIMARY KEY (ID)
);

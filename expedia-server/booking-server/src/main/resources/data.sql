INSERT INTO ACCOMMODATION (
    ID,
    ACCOMMODATION_NAME,
    ACCOMMODATION_TYPE,
    BIZNO,
    CHECKIN_DESCRIPTION,
    CHECKIN_START_TIME,
    CHECKOUT_END_TIME,
    CITY,
    STATE,
    STREET,
    TEL_NO,
    ZIPCODE,
    COUNTRY_CD,
    MIN_CHECKIN_AGE,
    RESPE_EMAIL,
    RESPE_HPNO,
    RESPE_USER_ID,
    CREATED_AT,
    CREATED_BY,
    LAST_MODIFIED_AT,
    LAST_MODIFIED_BY)
VALUES (
           1,
           '테스트 숙박업체 1번',
           'HOTEL',
           '9315500384',
           '체크인 시간을 준수해주세요.',
           '15:00',
           '11:00',
           'SEOUL',
           'GANGNAM-GU',
           'GANGNAM-DAERO',
           '02-1258-1231',
           '12399',
           'KR',
           14,
           'admin1@gmail.com',
           '010-5912-1253',
           1,
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN');

INSERT INTO ACCOMMODATION_ROLE (
    ID,
    ACCOMMODATION_ID,
    PROG_STATUS_CD,
    STOPPED_RSN,
    STOPPED_DTS,
    CREATED_AT,
    CREATED_BY,
    LAST_MODIFIED_AT,
    LAST_MODIFIED_BY)
VALUES (
           1,
           1,
           '',
           '',
           '',
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );


INSERT INTO ACCOMMODATION_ROOM (ID,
                                ACCOMMODATION_ID,
                                ROOM_NAME,
                                ROOM_TYPE,
                                MAX_ENTRANCE_CNT,
                                STOCK,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES (
           1,
           1,
           '스탠다드',
           'STANDARD',
           5,
           10,
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );

INSERT INTO ACCOMMODATION_ROOM_FEE (ID,
                                    ACCOMMODATION_ROOM_ID,
                                    ACTIVE,
                                    FEE,
                                    FEE_NAME,
                                    CREATED_AT,
                                    CREATED_BY,
                                    LAST_MODIFIED_AT,
                                    LAST_MODIFIED_BY)
VALUES (
           1,
           1,
           1,
           10000,
           '스탠다드 기본요금',
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );


INSERT INTO ACCOMMODATION_ROOM_INFO (ID,
                                     ACTIVE,
                                     ACCOMMODATION_COMMON_CODE_ID,
                                     ACCOMMODATION_ROOM_ID,
                                     CREATED_AT,
                                     CREATED_BY,
                                     LAST_MODIFIED_AT,
                                     LAST_MODIFIED_BY)
VALUES (
           1,
           1,
           1,
           1,
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );

INSERT INTO ACCOMMODATION_COMMON_CODE (ID,
                                       ACCOMMODATION_GROUP_COMMON_CODE_ID,
                                       CODE,
                                       CODE_NAME,
                                       CODE_DESC,
                                       CREATED_AT,
                                       CREATED_BY,
                                       LAST_MODIFIED_AT,
                                       LAST_MODIFIED_BY)
VALUES (
           1,
           1,
           'A0001',
           '01',
           '비즈니스 시설',
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );

INSERT INTO ACCOMMODATION_GROUP_COMMON_CODE (ID,
                                             GRP_CODE,
                                             GRP_CODE_NAME,
                                             GRP_CODE_DESC,
                                             CREATED_AT,
                                             CREATED_BY,
                                             LAST_MODIFIED_AT,
                                             LAST_MODIFIED_BY)
VALUES (
           1,
           'A00001',
           'FACILITY',
           '편의시설',
           NOW(),
           'ADMIN',
           NOW(),
           'ADMIN'
       );

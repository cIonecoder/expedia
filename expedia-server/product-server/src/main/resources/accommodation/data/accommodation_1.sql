-- 신규등록 1. 테스트 숙박업체 1번
-- (1) 숙박업체
INSERT INTO ACCOMMODATION (ACCOMMODATION_NAME,
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
VALUES ('테스트 숙박업체 1번',
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

-- (2) 숙박업체 권한
INSERT INTO ACCOMMODATION_ROLE (ACCOMMODATION_ID,
                                PROG_STATUS_CD,
                                STOPPED_RSN,
                                STOPPED_DTS,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION),
        '',
        '',
        '',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');


-- (3) 숙박업체 객실 : 1. 싱글룸
INSERT INTO ACCOMMODATION_ROOM (ACCOMMODATION_ID,
                                ROOM_NAME,
                                ROOM_TYPE,
                                MAX_ENTRANCE_CNT,
                                STOCK,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION),
        'SINGLE ROOM',
        'SINGLE',
        2,
        10,
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (4) 숙박업체 객실 요금 : 1. 싱글룸
INSERT INTO ACCOMMODATION_ROOM_FEE (ACCOMMODATION_ROOM_ID,
                                    ACTIVE,
                                    FEE,
                                    FEE_NAME,
                                    CREATED_AT,
                                    CREATED_BY,
                                    LAST_MODIFIED_AT,
                                    LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        1,
        10000,
        'SINGLE ROOM BASIC FEE',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 2. 더블룸
INSERT INTO ACCOMMODATION_ROOM (ACCOMMODATION_ID,
                                ROOM_NAME,
                                ROOM_TYPE,
                                MAX_ENTRANCE_CNT,
                                STOCK,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION),
        'DOUBLE ROOM',
        'DOUBLE',
        2,
        10,
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 2. 더블룸
INSERT INTO ACCOMMODATION_ROOM_FEE (ACCOMMODATION_ROOM_ID,
                                    ACTIVE,
                                    FEE,
                                    FEE_NAME,
                                    CREATED_AT,
                                    CREATED_BY,
                                    LAST_MODIFIED_AT,
                                    LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        1,
        20000,
        'DOUBLE ROOM BASIC FEE',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 3. 스위트룸
INSERT INTO ACCOMMODATION_ROOM (ACCOMMODATION_ID,
                                ROOM_NAME,
                                ROOM_TYPE,
                                MAX_ENTRANCE_CNT,
                                STOCK,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION),
        'SWEET ROOM',
        'SWEET',
        2,
        10,
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 3. 스위트룸
INSERT INTO ACCOMMODATION_ROOM_FEE (ACCOMMODATION_ROOM_ID,
                                    ACTIVE,
                                    FEE,
                                    FEE_NAME,
                                    CREATED_AT,
                                    CREATED_BY,
                                    LAST_MODIFIED_AT,
                                    LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        1,
        50000,
        'SWEET ROOM BASIC FEE',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 4. VIP 룸
INSERT INTO ACCOMMODATION_ROOM (ACCOMMODATION_ID,
                                ROOM_NAME,
                                ROOM_TYPE,
                                MAX_ENTRANCE_CNT,
                                STOCK,
                                CREATED_AT,
                                CREATED_BY,
                                LAST_MODIFIED_AT,
                                LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION),
        'VIP ROOM',
        'VIP',
        2,
        10,
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 객실 : 4. VIP 룸
INSERT INTO ACCOMMODATION_ROOM_FEE (ACCOMMODATION_ROOM_ID,
                                    ACTIVE,
                                    FEE,
                                    FEE_NAME,
                                    CREATED_AT,
                                    CREATED_BY,
                                    LAST_MODIFIED_AT,
                                    LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        1,
        50000,
        'VIP ROOM BASIC FEE',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (5) 숙박업체 객실 부가정보 : 1. 비즈니스 시설
INSERT INTO ACCOMMODATION_ROOM_INFO (ACTIVE,
                                     ACCOMMODATION_COMMON_CODE_ID,
                                     ACCOMMODATION_ROOM_ID,
                                     CREATED_AT,
                                     CREATED_BY,
                                     LAST_MODIFIED_AT,
                                     LAST_MODIFIED_BY)
VALUES (1,
        1,
        (SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (5) 숙박업체 객실 부가정보 : 2. 헬스
INSERT INTO ACCOMMODATION_ROOM_INFO (ACTIVE,
                                     ACCOMMODATION_COMMON_CODE_ID,
                                     ACCOMMODATION_ROOM_ID,
                                     CREATED_AT,
                                     CREATED_BY,
                                     LAST_MODIFIED_AT,
                                     LAST_MODIFIED_BY)
VALUES (1,
        2,
        (SELECT MAX(ID) FROM ACCOMMODATION_ROOM),
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');
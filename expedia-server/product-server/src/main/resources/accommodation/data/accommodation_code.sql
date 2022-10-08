-- (1) 숙박업체 공통 코드 그룹
INSERT INTO ACCOMMODATION_GROUP_COMMON_CODE (GRP_CODE,
                                             GRP_CODE_NAME,
                                             GRP_CODE_DESC,
                                             CREATED_AT,
                                             CREATED_BY,
                                             LAST_MODIFIED_AT,
                                             LAST_MODIFIED_BY)
VALUES ('A00001',
        'FACILITY',
        '편의시설',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (2) 숙박업체 공통 코드 : 1. 비즈니스 시설
INSERT INTO ACCOMMODATION_COMMON_CODE (ACCOMMODATION_GROUP_COMMON_CODE_ID,
                                       CODE,
                                       CODE_NAME,
                                       CODE_DESC,
                                       CREATED_AT,
                                       CREATED_BY,
                                       LAST_MODIFIED_AT,
                                       LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_GROUP_COMMON_CODE),
        'A0001',
        '01',
        '비즈니스 시설',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');

-- (3) 숙박업체 공통 코드 : 2.헬스
INSERT INTO ACCOMMODATION_COMMON_CODE (ACCOMMODATION_GROUP_COMMON_CODE_ID,
                                       CODE,
                                       CODE_NAME,
                                       CODE_DESC,
                                       CREATED_AT,
                                       CREATED_BY,
                                       LAST_MODIFIED_AT,
                                       LAST_MODIFIED_BY)
VALUES ((SELECT MAX(ID) FROM ACCOMMODATION_GROUP_COMMON_CODE),
        'A0001',
        '02',
        '헬스',
        NOW(),
        'ADMIN',
        NOW(),
        'ADMIN');
INSERT INTO member(email, password, active)
SELECT * FROM (SELECT 'designjava@naver.com', '123!abACC123', '1') AS tmp
WHERE NOT EXISTS (
        SELECT email FROM member WHERE email = 'designjava@naver.com'
) LIMIT 1;
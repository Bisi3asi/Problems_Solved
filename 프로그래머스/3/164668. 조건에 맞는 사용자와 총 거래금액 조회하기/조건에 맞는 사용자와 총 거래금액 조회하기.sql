SELECT u.USER_ID, u.NICKNAME, SUM(b.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER u, USED_GOODS_BOARD b
WHERE u.USER_ID = b.Writer_ID
    AND b.STATUS = 'DONE'
GROUP BY u.USER_ID, u.NICKNAME
HAVING SUM(b.PRICE) >= 700000
ORDER BY 3
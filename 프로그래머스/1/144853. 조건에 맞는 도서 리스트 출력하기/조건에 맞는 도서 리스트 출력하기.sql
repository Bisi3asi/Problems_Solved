SELECT BOOK_ID, TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD') PUBLISHED_DATE
FROM BOOK
WHERE TO_CHAR(PUBLISHED_DATE, 'YYYY') LIKE '%2021%' 
AND CATEGORY = '인문'
ORDER BY 2 ASC

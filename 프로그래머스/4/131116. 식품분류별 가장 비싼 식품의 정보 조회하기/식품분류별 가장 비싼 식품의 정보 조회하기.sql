SELECT f.CATEGORY, f.PRICE AS MAX_PRICE, f.PRODUCT_NAME
FROM FOOD_PRODUCT f
INNER JOIN (
    SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
) sub ON f.CATEGORY = sub.CATEGORY AND f.PRICE = sub.MAX_PRICE
ORDER BY 2 DESC
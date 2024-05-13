SELECT a.FLAVOR
FROM
(
    SELECT FLAVOR, SUM(TOTAL_ORDER) HALF_ORDER
    FROM FIRST_HALF
    GROUP BY FLAVOR
) a
INNER JOIN
(
    SELECT FLAVOR, SUM(TOTAL_ORDER) JULY_ORDER
    FROM JULY
    GROUP BY FLAVOR
) b
ON a.FLAVOR = b.FLAVOR
ORDER BY (HALF_ORDER + JULY_ORDER) DESC
FETCH FIRST 3 ROWS ONLY
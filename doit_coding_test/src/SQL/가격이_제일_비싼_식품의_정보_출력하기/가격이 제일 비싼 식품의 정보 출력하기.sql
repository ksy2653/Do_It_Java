SELECT PRODUCT_ID,
       PRODUCT_NAME,
       PRODUCT_CD,
       CATEGORY,
       PRICE
       
FROM FOOD_PRODUCT

WHERE PRICE IN (SELECT MAX(PRICE)
               FROM FOOD_PRODUCT
               );
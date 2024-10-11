SELECT A.ITEM_ID,
       A.ITEM_NAME,
       A.RARITY

FROM ITEM_INFO AS A

JOIN ITEM_TREE AS B
ON A.ITEM_ID = B.ITEM_ID

WHERE B.PARENT_ITEM_ID IN (SELECT ITEM_ID
                            FROM ITEM_INFO
                            WHERE RARITY = 'RARE')
                            
ORDER BY ITEM_ID DESC;
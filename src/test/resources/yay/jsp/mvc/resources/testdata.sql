/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Dalfrak
 * Created: 8 nov. 2019
 */

DROP TABLE DISCOUNT_CODE IF EXISTS;

CREATE TABLE DISCOUNT_CODE (DISCOUNT_CODE CHAR PRIMARY KEY, RATE DECIMAL(2,2);

INSERT INTO DISCOUNT_CODE VALUES (H,16.00);
INSERT INTO DISCOUNT_CODE VALUES (M,11.00);
INSERT INTO DISCOUNT_CODE VALUES (L,7.00);
INSERT INTO DISCOUNT_CODE VALUES (N,0.00);

COMMIT;
SELECT salesman.name AS "Salesman", customer.cust_name, customer.city
FROM salesman INNER JOIN customer
ON salesman.city = customer.city;


SELECT customer.cust_name, salesman.name
FROM customer INNER JOIN salesman
ON customer.salesman_id = salesman.salesman_id
WHERE customer.grade = '100';


SELECT a.cust_name AS "Customer Name"
FROM customer a
INNER JOIN salesman b
ON a.salesman_id=b.salesman_id
WHERE b.commission>.12
AND b.city != a.city;



SELECT  a.ord_no,a.purch_amt,b.cust_name,b.city
FROM orders a
INNER JOIN customer b
ON a.customer_id=b.customer_id
WHERE a.purch_amt BETWEEN 500 AND 2000;

SELECT  a.ord_no,a.purch_amt,
b.cust_name,b.city
FROM orders a,customer b
WHERE a.customer_id=b.customer_id
AND a.purch_amt BETWEEN 500 AND 2000;
SELECT * FROM employees WHERE salary > 10000;

SELECT COUNT(*) FROM soft_uni.employees;

SELECT employee_id, first_name, salary FROM soft_uni.employees LIMIT 10;

SELECT * FROM soft_uni.employees WHERE first_name LIKE 'gu';

SELECT * FROM employees WHERE salary > 50000 OR 1 = 1;

UPDATE employees SET salary = salary * 2 WHERE employee_id = 1;

SELECT * FROM employees WHERE employee_id = 1;

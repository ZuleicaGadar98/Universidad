create procedure get_customers()

select customer_id, first_name, last_name
from customer;

call get_customers();

call increment (4);
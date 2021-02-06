# SpringBootandRestApi
I wrote Rest Api using Spring Boot and Oracle Stored Procedure.


create or replace procedure my_stored_procedure
(sp_account_nr in varchar,
sp_contact_nr in varchar,
sp_old_maturity_action in number,
sp_new_maturity_action in number,
sp_currency in varchar,
sp_result out number,
sp_message out varchar)
as
begin 

sp_result :=1;
sp_message :='Hello, this my first Rest Api';

end my_storded_procedure;

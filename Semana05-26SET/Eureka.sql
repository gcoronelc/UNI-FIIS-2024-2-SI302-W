
declare @cuenta varchar(20);
set @cuenta = '00200001';
select * from cuenta where chr_cuencodigo = @cuenta;
select * from movimiento where chr_cuencodigo = @cuenta;
go


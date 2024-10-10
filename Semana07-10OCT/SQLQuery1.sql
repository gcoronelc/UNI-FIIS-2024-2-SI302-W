
select * from matricula where mat_precio = 500;
go

select * from matricula;
go

-- Ya termino de pagar
select * from matricula where cur_id=1 and alu_id=3;
select * from PAGO where cur_id=1 and alu_id=3;
go

-- Ya termino de pagar
select * from matricula where cur_id=1 and alu_id=3;
select * from PAGO where cur_id=1 and alu_id=3;
go

select ISNULL(sum(pag_importe),0.0) importe from pago where cur_id=1 and alu_id=30;
go

-- Ya termino de pagar
select * from matricula where cur_id=1 and alu_id=4;
select * from PAGO where cur_id=1 and alu_id=4;
go

select count(1) siguiente from PAGO where cur_id=1 and alu_id=4;
go

insert into PAGO(cur_id,alu_id,pag_cuota,emp_id,pag_fecha,pag_importe)
values(?,?,?,?,GETDATE(),?)
GO



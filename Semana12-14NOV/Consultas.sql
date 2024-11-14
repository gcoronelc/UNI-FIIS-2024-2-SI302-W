select * from Contador where vch_conttabla='Cliente';
select top 3 * from cliente order by 1 desc;
go


declare @cuenta char(8);
set @cuenta = '00400001';
select top 1 * from sucursal where chr_sucucodigo='004';
select * from cuenta where chr_cuencodigo=@cuenta;
select * from movimiento where chr_cuencodigo=@cuenta order by 2 desc;
go

insert into cuenta(chr_cuencodigo,chr_monecodigo,chr_sucucodigo,
chr_emplcreacuenta,chr_cliecodigo,dec_cuensaldo,dtt_cuenfechacreacion,
vch_cuenestado,int_cuencontmov,chr_cuenclave) 
values(?,?,?,?,?,?,GETDATE(),'ACTIVO',1,?)

insert into Movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
values(?,1,GETDATE(),?,'001',?,NULL)

sp_help movimiento

SELECT * FROM TipoMovimiento;
GO

/*
Procesos
- Crear una cuenta
- Deposito
- Retiro
- Transferencia
- Cancelar cuenta
- 
*/

select * from Asignado;
select count(1) cont from Asignado where chr_emplcodigo='0005' and dtt_asigfechabaja is null
select count(1) cont from Empleado where chr_emplcodigo=?
go

select chr_sucucodigo from Asignado where chr_emplcodigo='0005' and dtt_asigfechabaja is null
go

update sucursal set int_sucucontcuenta = int_sucucontcuenta + 1 where chr_sucucodigo=?
select int_sucucontcuenta from Sucursal where chr_sucucodigo=?
go

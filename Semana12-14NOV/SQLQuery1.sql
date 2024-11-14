select * from TipoMovimiento;
select * from Parametro;
select * from CostoMovimiento;
go

declare @cuenta1 char(8), @cuenta2 char(8);
set @cuenta1 = '00100001';
set @cuenta2 = '00400001';
select * from cuenta where chr_cuencodigo=@cuenta1;
select * from cuenta where chr_cuencodigo=@cuenta2;
select * from movimiento where chr_tipocodigo like '00[89]' order by 1;
go

select count(1) cont from cuenta where chr_cuencodigo='00100001' and vch_cuenestado='ACTIVO'
go

with 
t1 as (
	select chr_monecodigo m1 from Cuenta where chr_cuencodigo='00100001'
),
t2 as (
	select chr_monecodigo m2 from Cuenta where chr_cuencodigo='00100002'
)
select count(1) cont from t1 join t2 on t1.m1=t2.m2;
go

select * from cuenta;
go


update cuenta 
set dec_cuensaldo = dec_cuensaldo + ?, 
int_cuencontmov = int_cuencontmov + 1
where chr_cuencodigo = ?
go

select int_cuencontmov from cuenta where chr_cuencodigo='00100001'
go

sp_help movimiento
go

select * from movimiento;
go

insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
values(?,?,getdate(),?,?,?,?)
go
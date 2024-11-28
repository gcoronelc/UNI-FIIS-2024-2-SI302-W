select * from empleado;

select chr_emplcodigo codigo, vch_emplpaterno paterno,
vch_emplmaterno materno, vch_emplnombre nombre 
from empleado
where vch_emplusuario = ? and vch_emplclave = ?;

select * from cuenta;

select * from movimiento;

select int_movinumero nro, dtt_movifecha fecha, 
chr_tipocodigo tipo, dec_moviimporte importe
from Movimiento
where chr_cuencodigo = ?;





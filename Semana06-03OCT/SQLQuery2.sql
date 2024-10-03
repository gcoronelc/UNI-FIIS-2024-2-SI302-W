use EDUCA2;
go

declare @IdCurso int;
set @IdCurso = 1;
select * from CURSO where cur_id = @IdCurso;
select * from MATRICULA where cur_id = @IdCurso;
go


declare @IdCurso int, @IdAlumno int;
set @IdCurso = 1;
set @IdAlumno = 8;
select * from CURSO where cur_id = @IdCurso;
select * from MATRICULA where cur_id = @IdCurso and alu_id = @IdAlumno;
select * from PAGO where cur_id = @IdCurso and alu_id = @IdAlumno;
go



sp_help matricula
go


select cur_id, alu_id, emp_id, mat_tipo,
convert(varchar(20),mat_fecha,103) mat_fecha,
mat_precio, mat_cuotas, mat_nota
from MATRICULA where cur_id=1
go

select cur_precio from  curso where cur_id=1;
go

select * from matricula;
go

insert into matricula()
values()

select * from curso;
go



update curso set cur_matriculados = cur_matriculados + 1
where cur_id =?
go
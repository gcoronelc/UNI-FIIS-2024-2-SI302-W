
declare @idCursoProg int;
set @idCursoProg = 2000;
select * from CursoProgramado where IdCursoProg = @idCursoProg;
select * from Matricula where IdCursoProg = @idCursoProg;
go
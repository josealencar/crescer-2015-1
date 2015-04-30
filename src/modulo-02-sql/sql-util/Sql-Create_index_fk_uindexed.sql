BEGIN

  ------------------------
  -- CONSULTA PRINCIPAL --
  ------------------------
  Declare cRows Cursor local fast_forward read_only
  For
    SELECT
        u.name owner,
        o.name table_name,
        fk.constid,
        object_name(fk.constid) constraint_name_fk, 
        count(c.name) TotalColumns
    FROM
        sysforeignkeys fk   
       Inner Join syscolumns c ON (fK.fkeyid = c.id and fk.fkey = c.colid)
       Inner Join sysobjects o ON c.id = o.id
       Inner join dbo.sysusers u on u.uid= o.uid
    WHERE 
        o.type = 'U'
    AND NOT EXISTS
    (
        SELECT 
            1
        FROM
            sysindexes i JOIN sysindexkeys ik ON (ik.id = i.id and i.indid = ik.indid)                  
        WHERE 
                i.id = o.id
            AND INDEXPROPERTY(i.id, i.name, 'IsStatistics') = 0
            AND ik.colid = c.colid
    ) 
    group by u.name,
             o.name,
             fk.constid,
             object_name(fk.constid)
    order by 1, 2, 3, 4;
  ------------------------
  Declare @vIndexCommand      varchar(4000);
  Declare @vOwner             varchar(128);
  Declare @vObjectName        varchar(128);
  Declare @vConstID           int;
  Declare @vConstraintName    varchar(128);
  Declare @vTotalColumns      int;
  Declare @vColumnName        varchar(128);
declare @vcount int
set @vcount = 0
  ------
  Open cRows;
  Fetch next from cRows Into @vOwner, @vObjectName, @vConstID, @vConstraintName, @vTotalColumns;
  While @@FETCH_STATUS = 0  Begin
       Set @vIndexCommand = '';

       -- BUSCA COLUNAS DA CHAVE-ESTRANGEIRA --
       Declare cColumns Cursor local fast_forward read_only
          For
            SELECT c.name
            FROM   sysforeignkeys fk   
               Inner Join syscolumns c ON (fK.fkeyid = c.id and fk.fkey = c.colid)
            WHERE fk.constid = @vConstID
            ORDER BY fk.keyno;

       Open cColumns;
       Fetch next from cColumns Into @vColumnName;
       While @@FETCH_STATUS = 0 Begin
         Set @vIndexCommand = @vIndexCommand + @vColumnName + ', ';
       Fetch next from cColumns Into @vColumnName;
       End;
       Close cColumns;
       Deallocate cColumns;

       Set @vIndexCommand = substring(@vIndexCommand, 1, len(@vIndexCommand)-1);
       Print 'Create index '+ replace(replace(@vConstraintName, 'FK', 'IX'), '__', '_') + ' on ['+ @vOwner +'].['+ @vObjectName + '] (' + @vIndexCommand + ')
go';

  set @vcount = @vcount + 1
  Fetch next from cRows Into @vOwner, @vObjectName, @vConstID, @vConstraintName, @vTotalColumns;
  End;

  Close cRows;
  Deallocate cRows;
print '----------------------------
total de ix: '+cast(@vcount as varchar(10))
END;
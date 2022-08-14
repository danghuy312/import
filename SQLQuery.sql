
--create table
CREATE TABLE CDR(
	id				INT				IDENTITY	PRIMARY KEY
,	phone_number	NVARCHAR(100)
,	code			NVARCHAR(100)
,	date_time		NVARCHAR(50)
)


GO
CREATE TABLE [LOG](
	id				INT				IDENTITY	PRIMARY KEY
,	phone_number	NVARCHAR(100)
,	code			NVARCHAR(100)
,	date_time		NVARCHAR(50)
)


GO
TRUNCATE TABLE dbo.CDR
    
GO
TRUNCATE TABLE dbo.[LOG]


GO
SELECT * FROM dbo.CDR

GO
SELECT * FROM dbo.[LOG]
#테이블 코멘트 추가
alter table USER COMMENT ='사용자';
#테이블 코멘트 조회
 select table_name
,table_comment
from information_schema.tables
where 1=1
and TABLE_SCHEMA ='merci'
and table_name = 'USER';
#컬럼 코멘트 조회
select table_name
,column_name
,column_comment
from information_schema.COLUMNS
where 1=1
 and table_schema = 'merci'
and  table_name ='TEST1T';

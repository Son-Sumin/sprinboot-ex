show tables;
desc cocktail;
select * from cocktail;
select * from cocktailimage;
select * from signature;
select * from user;


-- Cocktail------------------------------------------
select * from cocktail;
select * from cocktailimage;

select a.*, b.url 
  from cocktail a, cocktailimage b
 where a.no = b.cocktail_no;
 
 delete from cocktail where no='96';

-- Signature------------------------------------------
select * from signature;
select * from reviewsignature;

insert into signature values('1', '맹구', '맹구칵테일', '2023-02-13', '2023-02-13', '칵테일', '칵테일', 'alcohol', '0', '0');
insert into signature values('2', '짱구', '짱구칵테일', '2023-02-13', '2023-02-13', '칵테일', '칵테일', 'alcohol', '0', '0');
insert into signature values('3', '휸이', '훈이칵테일', '2023-02-13', '2023-02-13', '칵테일', '칵테일', 'alcohol', '0', '0');

insert into reviewsignature values('1', '가', '가가가', '2023-02-09', '2023-02-10', '2');
insert into reviewsignature values('2', '나', '나나나', '2023-02-09', '2023-02-10', '2');
insert into reviewsignature values('3', '다', '다다다', '2023-02-09', '2023-02-10', '2');

delete from signature where no='16';
drop table signature;

-- TEST ------------------------------------------
select * from test;
insert into test values(1, "맹구");
insert into test values(2, "짱구");
insert into test values(3, "훈이");
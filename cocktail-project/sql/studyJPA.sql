show tables;
desc cocktail;
select * from cocktail;
select * from cocktailimage;
select * from signature;
select * from user;

-- FK = 0으로 설정 후 1로 변경하기
SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;

-- Cocktail------------------------------------------
select * from cocktail;
select * from cocktailimage;

select * from cocktailRecipe;
select * from ingredient;

select a.*, b.url 
  from cocktail a, cocktailimage b
 where a.no = b.cocktail_no;
 
select b.name, c.*, a.amount, a.unit
  from cocktailRecipe a, cocktail b, ingredient c
 where a.cocktail_no = b.no
   and a.ingredient_no = c.no;
 
 delete from cocktail where no='95';

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
delete from fieldRow
where id in (1, 2);


insert into fieldRow
values (1, 'ship', null, null, null, null), (2, null, null, null, 'ship', null), (3, null, 'ship', null, null, null),
  (4, null, null, null, null, null), (5, null, null, 'ship', null, null);
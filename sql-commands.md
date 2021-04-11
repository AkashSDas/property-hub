# SQL Commands

## Create database and user

Create a database and a user and grant that user's all the permission related that database. Here I've kept the database and user names as `property_hub` and `dbadmin` respectively.

Below is the code for creating `database` and using it.

```sql
-- Create a database
create database property_hub;

-- See all the databases in the system
show databases;

-- Use the property_hub database
use property_hub;
```

Below is the code for creating a `user` and granting that user permission related a `database`.

```sql
-- Create user
create user 'dbadmin'@'localhost' identified by 'password';

-- Check users in mysql, in this system
select user, host from mysql.user;

-- Grant permissions related all the tables in property_hub
grant all privileges on property_hub.* to 'dbadmin'@'localhost';

-- To grant permission related to a specific table use below line
-- grant all privileges on property_hub.table_name to 'dbadmin'@'localhost';
```

## Create table for Property Owner entity

This table will have all the information regarding a property owner.

```sql
create table property_owner(
    id int auto_increment primary key,
    firstName varchar(256) not null,
    lastName varchar(256) not null,
    phoneNumber varchar(16) not null,
    email varchar(256),
    owner_image_url varchar(256) not null
);
```

Few fake values to insert in `property_owner` column.

```sql
-- id value is kept 0 as it is in auto incremental mode
insert into property_owner values(
    0,
    'Adaline', 'Johnston',
    '(739) 509-6126',
    'adaline@gmail.com',
    'https://images.unsplash.com/photo-1586297135537-94bc9ba060aa?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80'
);

insert into property_owner values(
    0,
    'Concepcion', 'Weimann',
    '(932) 929-4600',
    'concepcion@gmail.com',
    'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=800&q=80'
);

insert into property_owner values(
    0,
    'Herminio', 'Daniel',
    '849-452-2743',
    null,
    'https://images.unsplash.com/photo-1527980965255-d3b416303d12?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=800&q=80'
);

insert into property_owner values(
    0,
    'Loy', 'Rolfson',
    '613-710-9633',
    'loy@gmail.com',
    'https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80'
);

insert into property_owner values(
    0,
    'Jana', 'Harris',
    '836.265.6408',
    'jana@gmail.com',
    'https://images.unsplash.com/photo-1552374196-c4e7ffc6e126?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80'
);
```

After adding the data view the table.

```sql
select * from property_owner;
```

## Create table for Property entity

This table will have all the information regarding a property.

```sql
create table property(
    id int auto_increment primary key,
    title varchar(256) not null,
    description varchar(512) not null,
    address varchar(1028) not null,
    min_price float not null,
    max_price float not null,
    status varchar(16) not null, -- sold, rent, buy
    cover_image_url varchar(512) not null,
    gif_url varchar(512) not null,

    owner_id int not null,
    foreign key (owner_id) references property_owner(id) on delete cascade
);
```

Few fake values to insert in `property` column.

```sql
-- id value is kept 0 as it is in auto incremental mode
insert into property values(
    0,
    'Hackett, Stiedemann and McClure',
    'Soluta iusto earum et omnis numquam voluptatem id. Repellat animi suscipit aut optio.',
    '62225 Von Route, South port, New Hampshire',
    3000000,
    3500000,
    'buy',
    'https://images.unsplash.com/photo-1483097365279-e8acd3bf9f18?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=999&q=80',
    'https://media.giphy.com/media/kiwwkkln72KNCoXnS9/giphy.gif',
    1
);

insert into property values(
    0,
    'Brakus, Cummerata and Shanahan',
    'Soluta iusto earum et omnis numquam voluptatem id. Repellat animi suscipit aut optio.',
    '1126 Elmo Track, Majorland, South Carolina',
    2000000,
    2750000,
    'buy',
    'https://images.unsplash.com/photo-1449844908441-8829872d2607?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/xUySTIdfTltEDOd7eE/giphy.gif',
    1
);

insert into property values(
    0,
    'Brakus, Cummerata and Shanahan',
    'Soluta iusto earum et omnis numquam voluptatem id. Repellat animi suscipit aut optio.',
    '1126 Elmo Track, Majorland, South Carolina',
    2000000,
    2750000,
    'buy',
    'https://images.unsplash.com/photo-1449844908441-8829872d2607?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/xUySTIdfTltEDOd7eE/giphy.gif',
    1
);

insert into property values(
    0,
    'Ferry LLC',
    'Enim eum qui. Non magnam pariatur beatae voluptate corporis sed ut esse est. Necessitatibus optio quaerat itaque sunt voluptatem ut. Eius dolores quia quibusdam dolores. Debitis reiciendis debitis voluptate nobis laborum ab consequuntur rerum.',
    'Lorainestad, Schowalter Plaza, Minnesota',
    3255000,
    4750000,
    'sold',
    'https://images.unsplash.com/photo-1556680108-01422551152d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/ihdniDPIOaAEGTsjwd/giphy.gif',
    2
);

insert into property values(
    0,
    'Wintheiser - Botsford',
    'Maiores adipisci dolor blanditiis. Aut ea nam aperiam ex voluptatibus nemo a.',
    'Lorainestad, Schowalter Plaza, Minnesota',
    3255000,
    4750000,
    'rent',
    'https://images.unsplash.com/photo-1416331108676-a22ccb276e35?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1047&q=80',
    'https://media.giphy.com/media/elc5Bd2Dm1vk82mp59/giphy.gif',
    3
);

insert into property values(
    0,
    'Kling Inc',
    'Quod qui voluptates earum minus quod a et. Rerum aut et autem nulla odio quo recusandae voluptatem dolor. Consequatur et laborum voluptas quo id et eius nesciunt ducimus.',
    '79397 Blair Extension, North Kacie, Indiana',
    15255000,
    1750000,
    'buy',
    'https://images.unsplash.com/photo-1564013799919-ab600027ffc6?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/kc5RUQZqn5AOYMOaRo/giphy.gif',
    4
);

insert into property values(
    0,
    'Cole - Mueller',
    'Et error aut inventore alias. Est tenetur autem architecto hic distinctio voluptas exercitationem. Sunt sint omnis nam. Sit amet provident incidunt ut quisquam delectus qui consequuntur. Et eum nulla sed.',
    '23596 Gail Vista, North Merritt, Kansas',
    3255000,
    4750000,
    'sold',
    'https://images.unsplash.com/photo-1570129477492-45c003edd2be?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/l2Jeca1nILRz1Y4GQ/giphy.gif',
    5
);

insert into property values(
    0,
    'Friesen, McCullough and Klein',
    'Culpa quae quia aut molestias adipisci sed possimus aut quod. Qui eos facilis laborum voluptatem fuga. Vero aut minima quaerat voluptas provident et quas. Vero ducimus nemo maiores in cumque harum. Sit quas suscipit ratione totam similique.',
    'Treutel Spur, Port Naomiborough, Kentucky',
    1255000,
    1750000,
    'buy',
    'https://images.unsplash.com/photo-1584738766473-61c083514bf4?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'https://media.giphy.com/media/H7I40WY3dUCGh1YYcC/giphy.gif',
    3
);
```

After adding the data view the table.

```sql
select count(*) from property;
-- select * from property;
```

## Create table for Property Image URLs entity

This table will have all the urls of images of property and property id of whose images these are.

```sql
create table property_image_urls(
    id int auto_increment primary key,
    url varchar(512) not null,

    property_id int not null,
    foreign key (property_id) references property(id) on delete cascade
);
```

Few fake values to insert in `property` column.

```sql
-- id value is kept 0 as it is in auto incremental mode

insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1512917774080-9991f1c4c750?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 1);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1448630360428-65456885c650?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1047&q=80', 1);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1484154218962-a197022b5858?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1053&q=80', 1);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1529316738131-4d0e0761a38e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80', 1);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1493809842364-78817add7ffb?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 1);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1585942000692-394f0cfd2449?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80', 2);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1540518614846-7eded433c457?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1039&q=80', 2);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1494203484021-3c454daf695d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 2);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1422557279422-316d7de15921?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 2);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1598518620362-52ff96e5dcc5?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1055&q=80', 2);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1544984243-ec57ea16fe25?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80', 3);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1484101403633-562f891dc89a?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1053&q=80', 3);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1594166167189-c0405007727b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1060&q=80', 3);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1604833153032-f8e6b1bff0bf?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 3);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1602941525436-839a5be074ff?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 4);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1571512051010-5fd9cc69fadb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 4);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1469467188629-fcc2fdaefa30?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 4);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1495433324511-bf8e92934d90?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 4);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1558211583-d26f610c1eb1?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=995&q=80', 4);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1516455590571-18256e5bb9ff?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 5);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1055&q=80', 5);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1507149833265-60c372daea22?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1055&q=80', 5);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1501183638710-841dd1904471?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 5);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1513694203232-719a280e022f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1049&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1560184897-ad57012c0981?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1032&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1560448204-61dc36dc98c8?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1503174971373-b1f69850bded?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1087&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1541123603104-512919d6a96c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1493663284031-b7e3aefcae8e?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 6);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1571512051010-5fd9cc69fadb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 7);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1469467188629-fcc2fdaefa30?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80', 7);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1495433324511-bf8e92934d90?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 7);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1558211583-d26f610c1eb1?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=995&q=80', 7);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1516455590571-18256e5bb9ff?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 7);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1055&q=80', 8);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1507149833265-60c372daea22?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1055&q=80', 8);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1501183638710-841dd1904471?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80', 8);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1513694203232-719a280e022f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1049&q=80', 8);
insert into property_image_urls values(0, 'https://images.unsplash.com/photo-1560184897-ad57012c0981?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1032&q=80', 8)
```

After adding the data view the table.

```sql
select count(*) from property_image_urls;
-- select * from property_image_urls;
```

## Blog schema and dummy data

The blog table will the schema for an individual blog.

```sql
create table blog(
    id int auto_increment primary key,
    author_name varchar(256) not null,
    author_image_url varchar(256) not null,
    published_date varchar(256) not null,
    title varchar(256) not null,
    description varchar(512) not null,
    text text not null,
    cover_image_url varchar(256) not null,
    gif_url varchar(256) not null
);
```

Dummy data for `blog` table.

```sql
-- id value is kept 0 as it is in auto incremental mode

insert into blog values(
    0,
    'Adrianna Hyatt',
    'https://images.unsplash.com/photo-1544005313-94ddf0286df2?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80',
    'Sat Dec 26 2020',
    'Cormier - Boyle',
    'Sed optio repudiandae nam cumque ut.',
    'Quod enim nihil debitis qui. Omnis nisi commodi molestiae. Voluptas tenetur ullam quos. Eum ducimus ducimus sed soluta occaecati nobis cupiditate suscipit. Deserunt odio qui cupiditate voluptas.

    Dolor quibusdam qui. Voluptatum in labore soluta quia accusantium explicabo ut. Non ut consequatur tenetur molestiae fugit dolor. Enim quaerat velit odio. Id aut nihil neque quo sint vel. Voluptas eaque consequuntur omnis tempora nostrum distinctio eveniet nesciunt dolorem. Unde quidem reiciendis.

    Laboriosam tempora sit. Cumque sed sint amet optio autem. In harum iste vitae ducimus earum quidem eligendi eligendi. Impedit blanditiis dolorem nesciunt autem molestiae suscipit.',
    'https://images.unsplash.com/photo-1560518883-ce09059eeffa?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=966&q=80',
    'https://media.giphy.com/media/3oriff9kTXmH5yCyXu/giphy.gif'
);


insert into blog values(
    0,
    'Alana Homenick',
    'https://images.unsplash.com/photo-1548186890-ba74ed36275d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1052&q=80',
    'Tue Jul 07 2020',
    'Prohaska, Shanahan and O Hara',
    'Repellat quos inventore repudiandae.',
    'Quod enim nihil debitis qui. Omnis nisi commodi molestiae. Voluptas tenetur ullam quos. Eum ducimus ducimus sed soluta occaecati nobis cupiditate suscipit. Deserunt odio qui cupiditate voluptas.

    Dolor quibusdam qui. Voluptatum in labore soluta quia accusantium explicabo ut. Non ut consequatur tenetur molestiae fugit dolor. Enim quaerat velit odio. Id aut nihil neque quo sint vel. Voluptas eaque consequuntur omnis tempora nostrum distinctio eveniet nesciunt dolorem. Unde quidem reiciendis.

    Laboriosam tempora sit. Cumque sed sint amet optio autem. In harum iste vitae ducimus earum quidem eligendi eligendi. Impedit blanditiis dolorem nesciunt autem molestiae suscipit.',
    'https://images.unsplash.com/photo-1523755231516-e43fd2e8dca5?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=675&q=80',
    'https://media.giphy.com/media/l2Je6Ni3cdh6HANvG/giphy.gif'
);


insert into blog values(
    0,
    'Eulah Boyer',
    'https://images.unsplash.com/photo-1582791694770-cbdc9dda338f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80',
    'Sun Nov 01 2020',
    'Konopelski Group',
    'Dolorem enim ut error sit.',
    'Quod enim nihil debitis qui. Omnis nisi commodi molestiae. Voluptas tenetur ullam quos. Eum ducimus ducimus sed soluta occaecati nobis cupiditate suscipit. Deserunt odio qui cupiditate voluptas.

    Dolor quibusdam qui. Voluptatum in labore soluta quia accusantium explicabo ut. Non ut consequatur tenetur molestiae fugit dolor. Enim quaerat velit odio. Id aut nihil neque quo sint vel. Voluptas eaque consequuntur omnis tempora nostrum distinctio eveniet nesciunt dolorem. Unde quidem reiciendis.

    Laboriosam tempora sit. Cumque sed sint amet optio autem. In harum iste vitae ducimus earum quidem eligendi eligendi. Impedit blanditiis dolorem nesciunt autem molestiae suscipit.',
    'https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80',
    'https://media.giphy.com/media/xT5LMKlM1TiXqU7BQc/giphy.gif'
);


insert into blog values(
    0,
    'Felipa Green',
    'https://images.unsplash.com/photo-1590632727047-995c602605af?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1050&q=80',
    'Sun Sep 20 2020',
    'Ullrich - Ernser',
    'Sed optio repudiandae nam cumque ut.',
    'Quod enim nihil debitis qui. Omnis nisi commodi molestiae. Voluptas tenetur ullam quos. Eum ducimus ducimus sed soluta occaecati nobis cupiditate suscipit. Deserunt odio qui cupiditate voluptas.

    Dolor quibusdam qui. Voluptatum in labore soluta quia accusantium explicabo ut. Non ut consequatur tenetur molestiae fugit dolor. Enim quaerat velit odio. Id aut nihil neque quo sint vel. Voluptas eaque consequuntur omnis tempora nostrum distinctio eveniet nesciunt dolorem. Unde quidem reiciendis.

    Laboriosam tempora sit. Cumque sed sint amet optio autem. In harum iste vitae ducimus earum quidem eligendi eligendi. Impedit blanditiis dolorem nesciunt autem molestiae suscipit.',
    'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=867&q=80',
    'https://media.giphy.com/media/l0HlF6dClclrgSTgk/giphy.gif'
);


insert into blog values(
    0,
    'Vilma Keeling',
    'https://images.unsplash.com/photo-1558216144-fef86b75da36?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80',
    'Sat Dec 26 2020',
    'Emard, Armstrong and Gibson',
    'Sed optio repudiandae nam cumque ut.',
    'Quod enim nihil debitis qui. Omnis nisi commodi molestiae. Voluptas tenetur ullam quos. Eum ducimus ducimus sed soluta occaecati nobis cupiditate suscipit. Deserunt odio qui cupiditate voluptas.

    Dolor quibusdam qui. Voluptatum in labore soluta quia accusantium explicabo ut. Non ut consequatur tenetur molestiae fugit dolor. Enim quaerat velit odio. Id aut nihil neque quo sint vel. Voluptas eaque consequuntur omnis tempora nostrum distinctio eveniet nesciunt dolorem. Unde quidem reiciendis.

    Laboriosam tempora sit. Cumque sed sint amet optio autem. In harum iste vitae ducimus earum quidem eligendi eligendi. Impedit blanditiis dolorem nesciunt autem molestiae suscipit.',
    'https://images.unsplash.com/photo-1586105251261-72a756497a11?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=867&q=80',
    'https://media.giphy.com/media/l2Jef1ICqEKgJFseA/giphy.gif'
);
```

See all of the inserted data

```sql
-- select * from blog;
select count(*) from blog;
```

## Loan schema and dummy data

```sql
create table loan(
    id int auto_increment primary key,
    bank_name varchar(512) not null,
    bank_logo_image_url varchar(512) not null,
    min_loan_amount float not null,
    max_loan_amount float not null,
    description varchar(512) not null
);
```

Dummy data.

```sql
insert into loan values(
    0,
    'Price Group',
    'https://images.unsplash.com/photo-1553835973-dec43bfddbeb?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80',
    500000,
    1000000,
    'Libero distinctio fugiat mollitia.'
);

insert into loan values(
    0,
    'Rosenbaum LLC',
    'https://images.unsplash.com/photo-1549924231-f129b911e442?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80',
    750000,
    2500000,
    'Ipsum minus cum dolor.'
);

insert into loan values(
    0,
    'Leannon - Ebert',
    'https://images.unsplash.com/photo-1567446537708-ac4aa75c9c28?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80',
    500000,
    1000000,
    'Dolor est perferendis omnis in minus.'
);

insert into loan values(
    0,
    'Goodwin - Feeney',
    'https://images.unsplash.com/photo-1545231027-637d2f6210f8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80',
    550000,
    750000,
    'Animi magni explicabo odit accusantium quis unde.'
);

insert into loan values(
    0,
    'Kuhlman - Schamberger',
    'https://images.unsplash.com/photo-1562307534-a03738d2a81a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80',
    200000,
    2750000,
    'Et dignissimos non debitis corporis quod.'
);

insert into loan values(
    0,
    'Raynor LLC',
    'https://images.unsplash.com/photo-1557053964-937650b63311?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1159&q=80',
    1000000,
    10000000,
    'Libero distinctio fugiat mollitia.'
);
```

See all the inserted data.

```sql
-- select * from loan;
select count(*) from loan;
```

## Create users and passwords tables

```sql
-- Users table
create table users(
    id int auto_increment PRIMARY KEY,
    email varchar(255) not null unique
);

-- Passwords table
-- In java code encoding the bytes to string and saving it in db
-- While retriving, decoding the string to bytes
create table passwords(
    id int auto_increment primary key,
    hashedPassword varchar(256) not null,
    salt varchar(256) not null,
    userId int not null,
    foreign key (userId) references users(id) on delete cascade
);
```

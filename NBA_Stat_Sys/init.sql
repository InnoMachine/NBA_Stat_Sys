drop database if exists nba;
create database if not exists nba;

use nba;

create table if not exists teams
( teamname varchar(20),
abbreviation varchar(5),
city varchar(20),
conference varchar(2),
division varchar(15),
homefield varchar(40),
birthyear varchar(10),
imgPath varchar(40) );

create table if not exists players(
name varchar(30),
number varchar(10),
position varchar(5),
height varchar(5),
weight varchar(5),
birth varchar(15),
age int,
exp int,
school varchar(60),
actionimgpath varchar(100),
portraitimgpath varchar(100) );

create table if not exists games(
gamelabel varchar(40),
gamedate varchar(10),
versus varchar(10),
guestteam varchar(5),
hometeam varchar(5),
scoreoverall varchar(10),
score1st varchar(10),
score2nd varchar(10),
score3rd varchar(10),
score4th varchar(10),
guesttp text,
hometp text);

flush privileges;
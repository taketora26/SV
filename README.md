This is your new Play application
=================================

# DB構成
## MySQLのユーザーとデータベースの作成

```
mysql
create database siliconValley;
create user 'richard'@'localhost' identified by 'siliconValley';
grant all privileges on siliconValley.* to 'richard'@'localhost';
flush privileges;
```
```
mysql(テスト)
create database siliconValley_test;
create user 'richard'@'localhost' identified by 'siliconValley';
grant all privileges on siliconValley_test.* to 'richard'@'localhost';
flush privileges;
```


- マイグレーションの実行
```
sbt flywayMigrate -Dflyway.url=jdbc:mysql://localhost:3306/siliconValley -Dflyway.user=richard -Dflyway.password=siliconValley
```
- DBの初期化
```
sbt flywayClean -Dflyway.url=jdbc:mysql://localhost:3306/siliconValley -Dflyway.user=richard -Dflyway.password=siliconValley
```


- マイグレーションの実行(テスト)
```
sbt flywayMigrate -Dflyway.url=jdbc:mysql://localhost:3306/siliconValley_test -Dflyway.user=richard -Dflyway.password=siliconValley
```
- DBの初期化
```
sbt flywayClean -Dflyway.url=jdbc:mysql://localhost:3306/siliconValley_test -Dflyway.user=richard -Dflyway.password=siliconValley
```





Controllers
===========

- HomeController.scala:

  Shows how to handle simple HTTP requests.

- AsyncController.scala:

  Shows how to do asynchronous programming when handling a request.

- CountController.scala:

  Shows how to inject a component into a controller and use the component when
  handling requests.

Components
==========

- Module.scala:

  Shows how to use Guice to bind all the components needed by your application.

- Counter.scala:

  An example of a component that contains state, in this case a simple counter.

- ApplicationTimer.scala:

  An example of a component that starts when the application starts and stops
  when the application stops.

Filters
=======

- Filters.scala:

  Creates the list of HTTP filters used by your application.

- ExampleFilter.scala

  A simple filter that adds a header to every response.
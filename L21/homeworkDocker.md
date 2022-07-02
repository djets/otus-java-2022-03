
#L21 Homework - Doker

1. установите докер для вашей операционной системы. дальнейшие действия надо выполнять в консоли:
2. выполните docker run hello-world
3. убедитесь, что видите строки: Hello from Docker! This message shows that your installation appears to be working correctly.
4. узнайте размер образа hello-world
5. посмотрите какие контейнеры сейчас запущены
6. в одной консоли: выполните docker run -it ubuntu bash
7. в другой консоли еще раз посмотрите работающие контейнеры, убедитесь, что есть контейнер с образом ubuntu
8. вернитесь в консоль, где вы запустили "docker run -it ubuntu bash"
9. начните с выполнения команды ls, "походите" по файловой системе, убедитесь, что это "какая-то другая" операционная система
10. перейдите в каталог home и в нем создайте новый каталог test
11. выполните exit и убедитесь, что вернулись в "свою" операционную систему
12. еще раз выполните docker run -it ubuntu bash
13. перейдите к каталог home, убедитесь, что созданного вами каталога test нет
14. очень важный пункт: подумайте, куда пропал каталог test
15. запустите PostgreSQL 13.1 в докере
16. подключитесь к запущенному контейнеру с базой.
17. создайте таблицу tTestDoc с любыми полями
18. остановите и удалите контейнер
19. еще раз запустите контейнер с базой
20. подключитесь к базе данных, убедитесь, что таблицы tTestDoc нет
21. подумайте, почему пропала таблица
22. остановите контейнер работа завершена


1. ### Install Docker Desktop on Linux
   
    [Official doc](https://docs.docker.com/desktop/linux/install/)
    
    **Instalation per distro**/*Install Docker Desktop on Ubuntu*
    [console output](1.txt)
2. ### Hello world
    [console output](2.txt)
3. ### Message - Done
4. $sudo docker ps --size
5. $sudo docker ps
6. done
7. 
    djet@hammerdjet:~$ sudo docker ps
    CONTAINER ID   IMAGE     COMMAND   CREATED          STATUS         PORTS     NAMES
    bcccdbec232d   ubuntu    "bash"    10 seconds ago   Up 9 seconds             quizzical_galileo
8. done
9. done
    root@bcccdbec232d:/# ls
    bin   dev  home  lib32  libx32  mnt  proc  run   srv  tmp  var
    boot  etc  lib   lib64  media   opt  root  sbin  sys  usr
    root@bcccdbec232d:/# ls -lah ~/
    total 16K
    drwx------ 2 root root 4.0K May 31 15:45 .
    drwxr-xr-x 1 root root 4.0K Jul  2 05:57 ..
    -rw-r--r-- 1 root root 3.1K Oct 15  2021 .bashrc
    -rw-r--r-- 1 root root  161 Jul  9  2019 .profile
    root@bcccdbec232d:/# 
10. root@bcccdbec232d:/# mkdir /home/test
11. djet@hammerdjet:/$ 
12. done
13. 
    root@f1b86fa8624a:/# ls -lah /home/
    total 8.0K
    drwxr-xr-x 2 root root 4.0K Apr 18 10:28 .
    drwxr-xr-x 1 root root 4.0K Jul  2 06:13 ..
    root@f1b86fa8624a:/# 
14. при запуске происходит перезапуск экземпляра контейнера с дефолтным окружением. при выходе изменения/информация утрачивается.
15. 
    djet@hammerdjet:/$ sudo docker run -p 5433:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=otus -v "$(pwd)/init_db":/docker-entrypoint-initdb.d -d --name my_postgres postgres:13
    16aacc5f35945188a3c70f87fede95753604701288104b952d03bc832dd50778
16. 
    djet@hammerdjet:/$ sudo docker exec -it my_postgres bash
    root@16aacc5f3594:/#
17.  
    CREATE TABLE tTestDoc 
    (
        Id SERIAL PRIMARY KEY,
        FieldTest CHARACTER VARYING (30)
    );
    CREATE TABLE
    Query returned successfully in 67 msec.
18. 
    djet@hammerdjet:~$ sudo docker stop my_postgres
    my_postgres
19. done
20. done
21. при запуске происходит перезапуск экземпляра контейнера с дефолтным окружением. при выходе изменения/информация утрачивается.
22. exit



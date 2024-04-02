# Бронирование отелей

## Описание проекта
Данный проект является зависимостью к проекту [order-service](https://github.com/i-kravchenko/order-service).
Проект order-status формирует сообщение в очереди kafka. Текущий проект в ответ на это сообщение формирует другое сообщение и отправляет его в очередь с другим topic

## Стэк используемых технологий
* Java
* Gradle
* Kafka
* Zookeeper

## Инструкция
### Конфигурация проекта
[Пример файла](src/main/resources/application.yaml)
#### Основные настройки
* spring.kafka.bootstrap-servers - адрес брокера Kafka

Остальные параметры можно оставить без изменений

### Сборка и запуск приложения
После завершение сборки можно запустить проект.
Для запуска kafka внутри docker подготовлен [скрипт](https://github.com/i-kravchenko/order-service/blob/master/docker/docker-start.cmd)
Для запуска проекта нужно ввести следующую команду:
````shell
java -jar build/libs/order-status-service-0.0.1-SNAPSHOT-plain.jar
````

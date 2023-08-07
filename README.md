# java-explore-with-me
Учебный проект

Бэкэнд приложения - афиши событий. Основными сущностями являются пользователи и события. Пользователи могут обладать различными правами, и в зависимости от них выполнять с событиями различные действия - создавать, присоединяться к существующим событиям (оставлять запрос на участие), создавать подборки событий, оставлять к ним комментарии. События также имеют атрибуты - категория, локация, максимальное количество участников.

Архитектура приложения.
Приложение включает в себя два микросервиса: основной сервис и сервис статистики. Сервис статистики содержит модули client, dto и server. Модуль client является шлюзом между основным модудем и модулем статистики. Основной сервис ewm-service содержит основную логику, контроллеры, сервисы, а хранение данных происходит в базе данных.

Основной функционал приложения.
Основной сервис включает в себя функции, распределенные по категориям доступа.
Администраторы могут управлять категориями для событий, подборками мероприятий, осуществлять модерирование события, размещённых пользователями,
Пользователи могут осуществлять добавление, редактирование и просмотр мероприятий, оформление заявки на участие в мероприятиях, подтверждение заявки на свое мероприятие другим пользователям,
просмотр подробной информации о выбранном событии. Сервис статистики собирает информацию о количестве обращений пользователей к спискам событий.

Спецификация сервисов содержится в файлах ewm-main-service-spec.json и ewm-stats-service-spec.json

Запуск приложения.
В проекте используется 11 версия Java. Для запуска без Docker откройте его в среде разработки и запустите модули ewm-service и stats-server. Для запуска в контейнерах Docker откройте терминал и впишите команду mvn clean package. После сборки проекта запуск можно осуществить через команду docker compose up. 

Стек технологий:
Java 11, Spring Boot, Maven, REST API, JDBC, H2, PostgreSQL, SQL, Hibernate - ORM, Docker

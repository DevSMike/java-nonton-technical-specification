## Описание проекта - nonton-technical-specification

### Описание
Проект `nonton-technical-specification` представляет собой программу, разработанную для управления продуктами. Он включает в себя несколько пакетов, каждый из которых отвечает за определенные функциональные части программы.

### Пакеты
1. **model**: В этом пакете содержится основной класс `Product`, который представляет сущность "Продукт". Он включает конструктор, геттеры, сеттеры, а также методы `equals` и `hashCode`.
2. **repository**: Этот пакет содержит интерфейс `ProductsRepository`, который определяет сигнатуры методов для реализации хранилища продуктов. Он включает методы, такие как `addProduct`, `deleteProduct` и `getAllProducts`. Класс `ProductsRepositoryImpl` представляет реализацию хранения объектов в памяти с использованием структуры данных - хеш-таблицы.
3. **service**: В пакете `service` содержится интерфейс `ProductsService`, который определяет сигнатуры методов, соответствующих техническому заданию. Класс `ProductsServiceImpl` является реализацией описанного функционала в соответствии с техническим заданием.

### Тестирование
В классе `MainForTests` содержатся юнит-тесты для проверки функционала, реализованного в программе. Поскольку использование сторонних библиотек было запрещено, тестовое окружение было разработано самостоятельно.

### Копирование кода
Если вам необходимо скопировать код из данного репозитория, вы можете воспользоваться следующими командами:


git clone https://github.com/DevSMike/java-nonton-technical-specification


Эта команда скопирует полный репозиторий на ваше локальное устройство.

### Техническое задание

Задание необходимо выполнить на любом C-подобном языке программирования. В задаче запрещено использование баз данных или любых других библиотек. Вы не ограничены в выборе реализации, но должны использовать стандартные структуры данных SDK.

#### Структура Product

```c
структура Product, id - уникальный номер продукта, name - наименование
class Product {
late String id;
late String name;
}

class ProductsImpl {
    // Добавляет новый продукт
    // Возвращает true, если продукта с таким id еще не было
    // Возвращает false, если был такой id, вставка отменяется
    bool addProduct(struct Product product) {
        // Реализация
    }

    // Удаляет продукт
    // Возвращает true, если продукт с таким id был
    // Возвращает false, если id не было, удаление не происходит
    bool deleteProduct(struct Product product) {
        // Реализация
    }

    // Получает имя (name) продукта
    // Возвращает name продукта, у которого идентификатор равен (=) id
    // Если продукта нет, возвращает пустую строку ""
    String getName(String id) {
        // Реализация
    }

    // Возвращает массив (список) идентификаторов (id)
    // У которых наименование равно (=) name
    // Если таких нет, возвращает пустой массив (список)
    List<String> findByName(String name) {
        // Реализация
    }
};
// данный пример показан на языке dart
// Если вы будуте реализовывать на других языка - вы в праве поменять типы на аналогичные в вашей sdk
// Но только на аналогичные»




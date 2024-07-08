### Hexlet tests and linter status:
[![Actions Status](https://github.com/ean3ena/java-project-61/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ean3ena/java-project-61/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/f946299d6078e0eb0111/maintainability)](https://codeclimate.com/github/ean3ena/java-project-61/maintainability)

## Описание
«Игры разума» — набор из пяти консольных игр, построенных по принципу популярных мобильных приложений
для прокачки мозга. Каждая игра задает вопросы, на которые нужно дать правильные ответы. После трех
правильных ответов считается, что игра пройдена. Неправильные ответы завершают игру и предлагают пройти
ее заново.

Игры:

- Определение четного числа.
  Демонстрация - https://asciinema.org/a/iseXBZL8MftEUjqmn1cydcB7r

- Калькулятор. Арифметические выражения, которые необходимо вычислить.
  Демонстрация - https://asciinema.org/a/BDBfr7h3zDbqmFMN4NWRiiYeq

- Определение наибольшего общего делителя.
  Демонстрация - https://asciinema.org/a/yfdKNewNjUUUWbC7AWWQ4y6jB

- Прогрессия. Поиск пропущенных чисел в последовательности чисел.
  Демонстрация - https://asciinema.org/a/whTZEtPSg5FZl3N1Pl7oAFnSl

- Определение простого числа.
  Демонстрация - https://asciinema.org/a/7wwx3cWuGmvtB9zkXu0SkQDMY


## Сборка
Сборка приложения производится в Gradle, для этого необходимо выполнить задачу `installDist`.
В результате сборки приложение будет упаковано в jar файл и получен исполняемый файл, который
можно будет запустить в консоли.

## Запуск
После успешного выполения сборки для запуска приложения достаточно в терминале набрать `make run-dist`



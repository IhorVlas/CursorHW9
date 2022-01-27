package com.company;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 1 Реализуйте собственный функциональный интерфейс, используя лямбда-выражения.
        System.out.println("Задание №1: ");

        MyFunctionalInterface longFuncInterface = new MyFunctionalInterface() {
            @Override
            public void showText() {
                System.out.println("Функциональный интерфейс без лямбды");
            }
        };
        longFuncInterface.showText();

        MyFunctionalInterface lambdaFuncInterface = () -> System.out.println("Функциональный интерфейс через лямбду");
        lambdaFuncInterface.showText();

        // 2 Есть список пользователей (User {email, loginDate, team}). Отфильтруйте пользователей,
        // которые вошли в систему после недели назад, сгруппируйте по командам, где K - команда, V - электронная почта.

        System.out.println("--------------------------------------------------------------------\nЗадание №2: ");
        List<User> users = Arrays.asList(
                new User("user1@d.net", "11A", LocalDate.parse("2022-01-24")),
                new User("user2@d.net", "11A", LocalDate.parse("2022-01-23")),
                new User("user3@d.net", "11A", LocalDate.parse("2022-01-16")),
                new User("user4@d.net", "11A", LocalDate.parse("2022-01-18")),
                new User("user5@d.net", "11B", LocalDate.parse("2022-01-02")),
                new User("user6@d.net", "11B", LocalDate.parse("2022-01-15")),
                new User("user7@d.net", "11B", LocalDate.parse("2022-01-20")),
                new User("user8@d.net", "11B", LocalDate.parse("2022-01-19")),
                new User("user9@d.net", "11C", LocalDate.parse("2022-01-03")),
                new User("user10@d.net", "11C", LocalDate.parse("2022-01-24")),
                new User("user11@d.net", "11C", LocalDate.parse("2022-01-17")),
                new User("user12@d.net", "11C", LocalDate.parse("2022-01-20")));

        LocalDate locD = LocalDate.now().minusWeeks(1);
        var usersArr = users.stream()
                .filter(it -> locD.isBefore(it.getLoginDate()))
                .collect(Collectors.toList());

        System.out.println(usersArr);

        Map<String, List<String>> map = usersArr.stream()
                .collect(Collectors.groupingBy(User::getTeam,
                        Collectors.mapping(User::getEmail, Collectors.toList())));
        System.out.println(map);

//        for (User user : usersArr) {
//            String team = user.getTeam();
//            if (!map.containsKey(team)) {
//                List<User> userList = new ArrayList<>();
//                userList.add(user);
//                map.put(team, userList);
//            } else {
//                List<User> userList = map.get(team);
//                userList.add(user);
//            }
//        }
//           System.out.println(map);

        // 3 Есть 2 коллекции с фильмами. У каждого Фильма есть цена билета, жанр. По каждому жанру рассчитайте
        // среднюю цену билетов и подсчитайте фильмы определенного жанра.
        System.out.println("--------------------------------------------------------------------\nЗадание №3: ");

        ArrayList<Films> firstFilmCol = new ArrayList<Films>();
        firstFilmCol.add(new Films("firstFilmCol1", 100, "genre1"));
        firstFilmCol.add(new Films("firstFilmCol2", 110, "genre2"));
        firstFilmCol.add(new Films("firstFilmCol3", 140, "genre3"));
        firstFilmCol.add(new Films("firstFilmCol4", 130, "genre2"));
        firstFilmCol.add(new Films("firstFilmCol5", 120, "genre1"));

        ArrayList<Films> secondFilmCol = new ArrayList<Films>();
        secondFilmCol.add(new Films("secondFilmCol1", 105, "genre3"));
        secondFilmCol.add(new Films("secondFilmCol2", 115, "genre1"));
        secondFilmCol.add(new Films("secondFilmCol3", 145, "genre2"));
        secondFilmCol.add(new Films("secondFilmCol4", 135, "genre1"));
        secondFilmCol.add(new Films("secondFilmCol5", 125, "genre3"));

        ArrayList<List<Films>> allFilmsArr = new ArrayList<>();
        allFilmsArr.add(firstFilmCol);
        allFilmsArr.add(secondFilmCol);

        var midlTicketPrise = allFilmsArr.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Films::getGenreOfFilm, Collectors.averagingInt(Films::getTicketPrise)));
        System.out.println("Средние цены на билеты: " + midlTicketPrise);

        var numberOfGenre = allFilmsArr.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Films::getGenreOfFilm, Collectors.counting()));
        System.out.println("Количество фильмов каждого жанра: " + numberOfGenre);
    }
}

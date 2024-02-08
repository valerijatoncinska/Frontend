package pokemonProject;
import pokemonProject.pokedex.Pokemon;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoyEmulator {

    public static void main(String[] args) {

        Pokemon[] pokedex = new Pokemon[3];
        pokedex[0] = new Pokemon("Бульбазавр", 40, 10, 5, new String[]{"Зарастание"}, 30);
        pokedex[1] = new Pokemon ("Бидрилл", 30, 30, 5, new String[]{"Самобичевание"}, 50);
        pokedex[2] = new Pokemon("Алаказам", 40, 20, 8, new String[]{"Регенерация"}, 50);

        Scanner scanner = new Scanner(System.in);

        String yourPokemonChoice;
        String hostilePokemonChoice;
        do {
            System.out.println("Выберите своего покемона: \n" + "Бульбазавр\n" + pokedex[0].stats() + "Бидрилл\n"
                    + pokedex[1].stats() + "Алаказам\n" + pokedex[2].stats() +
                    "Или же введите ГЛОСАРИЙ для просмотра всех аббревиатур и специальных атак (Глосарий появится над списком покемонов)\n" +
                    "Если Вы желаете выйти из игры, то введите ВЫХОД");
            yourPokemonChoice = scanner.nextLine();

            Pokemon yourPokemon = null;

            if (yourPokemonChoice.contains("Бульбазавр") || yourPokemonChoice.contains("Бидрилл") || yourPokemonChoice.contains("Алаказам")) {
                switch (yourPokemonChoice) {
                    case "Бульбазавр":
                        yourPokemon = pokedex[0];
                        break;
                    case "Бидрилл":
                        yourPokemon = pokedex[1];
                        break;
                    case "Алаказам":
                        yourPokemon = pokedex[2];
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение, прошу, соблюдайте правильное написание имён и заглавные буквы");
                        continue;
                }
            } else if (yourPokemonChoice.equalsIgnoreCase("глоссарий")) {
                System.out.println(glossary());
                continue;
            } else if (yourPokemonChoice.equalsIgnoreCase("Выход")) {
                continue;
            } else {
                System.out.println("Вы ввели неверную команду, попробуйте снова!");
                continue;
            }
            System.out.println("Выберите своего противника! (Вы не можете выбрать идентичных покемонов)");
            hostilePokemonChoice = scanner.nextLine();

            Pokemon hostilePokemon = null;

            if (!hostilePokemonChoice.equalsIgnoreCase("выход") && (!hostilePokemonChoice.equals(yourPokemonChoice))) {
                switch (hostilePokemonChoice) {
                    case "Бульбазавр":
                        hostilePokemon = pokedex[0];
                        break;
                    case "Бидрилл":
                        hostilePokemon = pokedex[1];
                        break;
                    case "Алаказам":
                        hostilePokemon = pokedex[2];
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение, прошу, соблюдайте правильное написание имён и заглавные буквы");
                        continue;
                }
            } else {
                System.out.println("Вы ввели неверную команду или вы выбрали идентичных покемонов, попробуйте снова!");
            }

            assert yourPokemon != null;
            assert hostilePokemon != null;

            System.out.println("Вы выбрали покемона " + yourPokemon.pokemonName + "! Ваш противник - " + hostilePokemon.pokemonName + "!");

            do {
                Scanner battleScanner = new Scanner(System.in);
                String battleTurn;
                String battleTurnTwo;

                do {
                    if ((yourPokemon.speed >= hostilePokemon.speed) && yourPokemon.currentHp > 0 && hostilePokemon.currentHp > 0) {
                        System.out.println(
                                "\nВаш ход!\n" + "Ваши показатели " + yourPokemon.pokemonName + " " +
                                        yourPokemon.stats() + "\nПоказатели противника " + hostilePokemon.pokemonName + " " +
                                        hostilePokemon.stats() +
                                        "\nДоступные Вам действия: \n" +
                                        "Атака\n" +
                                        "Оборона\n" +
                                        "Передышка\n" +
                                        "Пропустить Ход\n" +
                                        "Спец Атака " +
                                        "(" + Arrays.toString(yourPokemon.specialAttackName) + ")\n\n");
                        battleTurn = battleScanner.nextLine();
                        switch (battleTurn) {
                            case "Атака":
                                yourPokemon.basicAttack();
                                int damage = yourPokemon.attack - hostilePokemon.defense;
                                if (damage < 0) {
                                    damage = 0;
                                }
                                hostilePokemon.currentHp -= damage;
                                break;
                            case "Оборона":
                                yourPokemon.defensiveStance();
                                break;
                            case "Передышка":
                                yourPokemon.sleep();
                                break;
                            case "Пропустить Ход":
                                yourPokemon.skipTurn();
                                break;
                            case "Спец Атака":
                                if (yourPokemon == pokedex[0]) {
                                    yourPokemon.overgrow();
                                } else if (yourPokemon == pokedex[1]) {
                                    yourPokemon.swarm();
                                } else {
                                    yourPokemon.innerFocus();
                                }
                                break;
                            default:
                                System.out.println("Вы ввели неверную команду, прошу, соблюдайте правильное написание имён и заглавные буквы." +
                                        "Боль и страдания - лучшие учителя. Из-за своей ошибки вы автоматически пропускаете ход");
                                continue;
                        }

                        if (!(yourPokemon.currentHp > 0) || !(hostilePokemon.currentHp > 0)) {
                            break;
                        } else {
                            System.out.println("\nХод противника!\n" + "Ваши показатели " + yourPokemon.pokemonName + " " +
                                    yourPokemon.stats() + "\nПоказатели противника " + hostilePokemon.pokemonName + " " +
                                    hostilePokemon.stats() +
                                    "\nДоступные ему действия: \n" +
                                    "Атака\n" +
                                    "Оборона\n" +
                                    "Передышка\n" +
                                    "Пропустить Ход\n" +
                                    "Спец Атака " +
                                    "(" + Arrays.toString(hostilePokemon.specialAttackName) + ")\n\n");
                            battleTurnTwo = battleScanner.nextLine();
                            switch (battleTurnTwo) {
                                case "Атака":
                                    hostilePokemon.basicAttack();
                                    int damage = hostilePokemon.attack - yourPokemon.defense;
                                    if (damage < 0) {
                                        damage = 0;
                                    }
                                    yourPokemon.currentHp -= damage;
                                    break;
                                case "Оборона":
                                    hostilePokemon.defensiveStance();
                                    break;
                                case "Передышка":
                                    hostilePokemon.sleep();
                                    break;
                                case "Пропустить Ход\n":
                                    hostilePokemon.skipTurn();
                                    break;
                                case "Спец Атака":
                                    if (hostilePokemon == pokedex[0]) {
                                        hostilePokemon.overgrow();
                                    } else if (hostilePokemon == pokedex[1]) {
                                        hostilePokemon.swarm();
                                    } else {
                                        hostilePokemon.innerFocus();
                                    }
                                    break;
                                default:
                                    System.out.println("Вы ввели неверную команду, прошу, соблюдайте правильное написание имён и заглавные буквы." +
                                            "Боль и страдания - лучшие учителя. Из-за своей ошибки вы автоматически пропускаете ход");
                                    continue;
                            }
                        }
                    } else if ((yourPokemon.currentHp <= 0) || hostilePokemon.currentHp <= 0) {
                        System.out.println("Вы не можете использовать одного из выбранных покемонов, т.к. их ОЗ ниже 0!");
                        break;
                    } else if (yourPokemon.currentHp > 0 && hostilePokemon.currentHp > 0) {
                        System.out.println("\nХод противника!\n" + "Ваши показатели " + yourPokemon.pokemonName + " " +
                                yourPokemon.stats() + "\nПоказатели противника " + hostilePokemon.pokemonName + " " +
                                hostilePokemon.stats() +
                                "\nДоступные ему действия: \n" +
                                "Атака\n" +
                                "Оборона\n" +
                                "Передышка\n" +
                                "Пропустить Ход\n" +
                                "Спец Атака " +
                                "(" + Arrays.toString(hostilePokemon.specialAttackName) + ")\n\n");
                        battleTurn = battleScanner.nextLine();
                        switch (battleTurn) {
                            case "Атака":
                                hostilePokemon.basicAttack();
                                int damage = hostilePokemon.attack - yourPokemon.defense;
                                if (damage < 0) {
                                    damage = 0;
                                }
                                yourPokemon.currentHp -= damage;
                                break;
                            case "Оборона":
                                hostilePokemon.defensiveStance();
                                break;
                            case "Передышка":
                                hostilePokemon.sleep();
                                break;
                            case "Пропустить Ход":
                                hostilePokemon.skipTurn();
                                break;
                            case "Спец Атака":
                                if (hostilePokemon == pokedex[0]) {
                                    hostilePokemon.overgrow();
                                } else if (hostilePokemon == pokedex[1]) {
                                    hostilePokemon.swarm();
                                } else {
                                    hostilePokemon.innerFocus();
                                }
                                break;
                            default:
                                System.out.println("Вы ввели неверную команду, прошу, соблюдайте правильное написание имён и заглавные буквы." +
                                        "Боль и страдания - лучшие учителя. Из-за своей ошибки вы автоматически пропускаете ход");
                                continue;

                        }

                        if (!(yourPokemon.currentHp > 0) || !(hostilePokemon.currentHp > 0)) {
                            break;
                        } else {
                            System.out.println("\nВаш ход!\n" + "Ваши показатели " + yourPokemon.pokemonName + " " +
                                    yourPokemon.stats() + "\nПоказатели противника " + hostilePokemon.pokemonName + " " +
                                    hostilePokemon.stats() +
                                    "\nДоступные Вам действия: \n" +
                                    "Атака\n" +
                                    "Оборона\n" +
                                    "Передышка\n" +
                                    "Пропустить Ход\n" +
                                    "Спец Атака " +
                                    "(" + Arrays.toString(yourPokemon.specialAttackName) + ")\n\n");
                            battleTurnTwo = battleScanner.nextLine();
                            switch (battleTurnTwo) {
                                case "Атака":
                                    yourPokemon.basicAttack();
                                    int damage = yourPokemon.attack - hostilePokemon.defense;
                                    if (damage < 0) {
                                        damage = 0;
                                    }
                                    hostilePokemon.currentHp -= damage;
                                    break;
                                case "Оборона":
                                    yourPokemon.defensiveStance();
                                    break;
                                case "Передышка":
                                    yourPokemon.sleep();
                                    break;
                                case "Пропустить Ход":
                                    yourPokemon.skipTurn();
                                    break;
                                case "Спец Атака":
                                    if (yourPokemon == pokedex[0]) {
                                        yourPokemon.overgrow();
                                    } else if (yourPokemon == pokedex[1]) {
                                        yourPokemon.swarm();
                                    } else {
                                        yourPokemon.innerFocus();
                                    }
                                    break;
                                default:
                                    System.out.println("Вы ввели неверную команду, прошу, соблюдайте правильное написание имён и заглавные буквы." +
                                            "Боль и страдания - лучшие учителя. Из-за своей ошибки вы автоматически пропускаете ход");
                                    continue;
                            }
                        }
                    }
                } while (!(yourPokemon.currentHp == 0) && !(hostilePokemon.currentHp == 0));

            } while ((yourPokemon.currentHp == 0) && !(hostilePokemon.currentHp == 0));
            {
                if (yourPokemon.currentHp <= 0) {
                    yourPokemon.kO();
                    System.out.println(hostilePokemon.pokemonName + " победил!\n\n");
                } else {
                    hostilePokemon.kO();
                    System.out.println(yourPokemon.pokemonName + " победил!\n\n");
                }
            }

        } while (!yourPokemonChoice.equalsIgnoreCase("выход"));
    }


    public static String glossary() {

        return "| ОЗ - Очки Здоровья |\n     Показатель того, как много сил осталось у вашего покемона." + "Каждый раз, когда покемон получает урон, число урона вычитается из его здоровья," + " если у того заканчиваются ОЗ, то покемон больше не может сражаться.\n" +

                "| Макс_ОЗ - Максимальные Очки Здоровья |\n     Показатель максимума здоровья вашего покемона," + " Каждый раз, когда покемон восполняет ОЗ, он не может вополнить их выше показателя Макс_ОЗ.\n" +

                "| АТК - Атака |\n     Показатель того, как сильно может атаковать Ваш покемон." + " Учитывайте, что показатель атаки всегда уменьшается на показатель обороны вышего врага.\n" +

                "| ОБР - Оборона |\n     Показатель того, как хорошо Ваш покемон обороняется." + " Каждый раз, когда Вы получаете урон, показатель Обороны вычитывается из базого показателя атаки противника.\n" +

                "| СКР - Скорость |\n     Показатель того, как быстр Ваш покемон." + " Каждый раз, когда Вы начинаете бой, показатели СКР Вашего покемона и противника сравниваются. " + "У кого больше скорости, тот и ходит первым, если показатели равны, то ходите первым_ой Вы.\n" +

                "| Спец_АТК  - Специальная Атака |\n     Особая способность вашего покемона, которая отличается от покемона " + "к покемону.\n" +

                "| OVERGROW | \n     Эту специальную атаку можно использовать только в том случае, если ОЗ вашего покемона ниже половины," + "ваш покемон получает вечный бонус к АТК равный половине АТК.\n" +

                "| SWARM | \n     Эта специальная атака наносит Вашему покемону урон равный половине его ОЗ, после перманентно повышая " + "АТК и ОБР вашего покемона на половину их базового значения.\n" +

                "| Inner Focus | \n     Эта специальная атака наносит урон противнику равный половине АТК покемона и " + "повышает ОБР на половину значения АТК.\n";
    }
}
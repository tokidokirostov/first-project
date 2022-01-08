import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput !=0) {

            switch (userInput) {
                case 1:
                System.out.println("Введите количество пройденых шагов");
                int numberOfSteps = scanner.nextInt();

                while (numberOfSteps<0) {
                    System.out.println("Количество шагов отрицательное");
                    System.out.println("Введите количество пройденых шагов");
                    numberOfSteps = scanner.nextInt();
                }

                System.out.println("Введите номер месяца:");
                int monthOfStep = scanner.nextInt();

                while ((monthOfStep<=0) || (monthOfStep>12)) {
                    System.out.println("Номер месяца неправильный");
                    System.out.println("Введите номер месяца");
                    monthOfStep = scanner.nextInt();
                }

                System.out.println("Введите номер дня в месяце");
                int dayOfStep = scanner.nextInt();

                while ((dayOfStep<=0) || (dayOfStep>30)) {
                    System.out.println("Номер дня неправильный");
                    System.out.println("Введите номер дня в месяце:");
                    dayOfStep = scanner.nextInt();
                }

                stepTracker.saveSteps(numberOfSteps, monthOfStep, dayOfStep);
                break;

                case 2:
                System.out.println("Введите номер месяца для вывода статистики");
                int monthStat = scanner.nextInt();

                while ((monthStat<=0) || (monthStat>12)) {
                    System.out.println("Номер месяца неправильный");
                    System.out.println("Введите номер месяца");
                    monthStat = scanner.nextInt();
                }

                stepTracker.PrintStatMonth(monthStat);
                break;

                case 3:
                System.out.println("Введите количество шагов за день до цели");
                int stepsGoal = scanner.nextInt();

                while (stepsGoal<0) {
                    System.out.println("количество шагов за день до цели должно быть больше нуля");
                    System.out.println("Введите количество шагов за день до цели");
                    stepsGoal = scanner.nextInt();
                }

                stepTracker.changeStepDay(stepsGoal);
                break;

                default:
                System.out.println("Такого пункта меню нет");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Выберите пункт меню:");
        System.out.println("1 - Ввод количества шагов за определенный день.");
        System.out.println("2 - Вывод статистики за определеный месяц.");
        System.out.println("3 - Изменение количества шагов за день до цели.");
        System.out.println("0 - Выход из приложения.");
    }
}

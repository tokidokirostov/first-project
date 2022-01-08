import java.util.HashMap;
import java.util.ArrayList;

public class StepTracker {
    Converter converter = new Converter();
    ArrayList<Integer> maxSeries = new ArrayList<>();
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    int stepsGoal = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    //сохранение шагов
    void saveSteps(int step, int month, int day) {
        monthToData.get(month-1).step.put(day-1, step);
        System.out.println();
    }

    /* Метод вывода статистики по следующим пунктам:
    - Количество пройденных шагов по дням за выбранный месяц;
    - Общее количество шагов за месяц;
    - Максимальное пройденное количество шагов в месяце;
    - Среднее количество шагов;
    - Пройденная дистанция (в км);
    - Количество сожжённых килокалорий;
    - Лучшая серия подряд идущих дней, в течение которых количество шагов за день было выше целевого.
     */
    void PrintStatMonth(int month) {
        int totallStepOfMonth = 0;
        int maxStepOfMonth = 0;
        int maxSeriesSteps = 0;

        for (int i=0; i<30; i++) {
            System.out.print((i+1) + " день: " + monthToData.get(month-1).step.get(i) + ", ");
            totallStepOfMonth = totallStepOfMonth + monthToData.get(month-1).step.get(i);
            if (maxStepOfMonth < monthToData.get(month-1).step.get(i)) {
                maxStepOfMonth = monthToData.get(month-1).step.get(i);
            }
            if (monthToData.get(month-1).step.get(i) > stepsGoal) {
                maxSeriesSteps++;
            } else {
                maxSeries.add(maxSeriesSteps);
                maxSeriesSteps = 0;
            }
        }

        System.out.println();
        System.out.println("Общее количество шагов за месяц - " + totallStepOfMonth);
        System.out.println("Максимально пройденное количество шагов за месяц - " + maxStepOfMonth);
        System.out.println("Среднее количество шагов за месяц - " + (totallStepOfMonth / 30));
        System.out.println("Пройденная дистанция - " + converter.SumDist(totallStepOfMonth) + " км.");
        System.out.println("Количество сожжённых килокалорий - " + converter.SumCal(totallStepOfMonth));

        maxSeriesSteps = 0;
        for (Integer days: maxSeries) {
            if (maxSeriesSteps < days) {
                maxSeriesSteps = days;
            }
        }
        maxSeries.clear();
        System.out.println("Лучшая серия  - " + maxSeriesSteps);
        System.out.println();
    }

    //изменение колличества шагов до цели
    void changeStepDay(int day) {
        stepsGoal = day;
        System.out.println();
    }
}



public class Converter {

    int SumDist(int step) {
        int distance  = (int) (step * 0.00075);
        return distance;
    }

    int SumCal(int step) {
        int numberOfCalories = (step * 50) / 1000;
        return numberOfCalories;

    }
}

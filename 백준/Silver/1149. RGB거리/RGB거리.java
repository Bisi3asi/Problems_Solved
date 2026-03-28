import java.util.*;
import java.io.IOException;

class House {
    int r, g, b;
    int minR, minG, minB;

    public House (int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setFirst (House house) {
        this.minR = this.r;
        this.minG = this.g;
        this.minB = this.b;
    }


    public void calculate(House prev) {
        minR = Math.min(prev.minG, prev.minB) + r;
        minG = Math.min(prev.minB, prev.minR) + g;
        minB = Math.min(prev.minR, prev.minG) + b;
    }
}


class Main {

    private int solution(List<House> houses) {
        houses.get(0).setFirst(houses.get(0));
        for (int i = 1; i < houses.size(); i++) {
            houses.get(i).calculate(houses.get(i-1));
        }
        House last = houses.get(houses.size() - 1);
        
        return Math.min(Math.min(last.minR, last.minG), last.minB);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<House> houses = new ArrayList<>();

        for (int i = 0; i < n; i ++ ){
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            houses.add(new House(r, g, b));
        }

        System.out.println(T.solution(houses));
        sc.close();
    }
}
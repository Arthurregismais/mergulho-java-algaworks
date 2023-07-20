public class CalculadoraCortisol{
    public static void main(String[] args) {
        double cortisol = 18.7;
    

        if (cortisol >= 6.0 && cortisol <= 18.6) {
            System.out.println("O seu cortisol está normal");
        }
        else if (cortisol < 6.0) {
            System.out.println("O seu cortisol está baixo");
        }
        else {
            System.out.println("O seu cortisol está alto");
        }
    }
}

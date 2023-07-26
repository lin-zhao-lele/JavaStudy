public class StudyFloat {

    public static void main(String... args)
    {

        System.out.println(0.1+0.2);
        System.out.println(1.0-0.42);
        System.out.println(4.015*1000);


        float num = 0;
        for(int i =0;i< 100;i++){
            num+= 0.1;
        }
        System.out.println(num);


        System.out.println("*******************************");


        double rawValue3 = -158.1 ;

        Integer results_old;
        Integer results_new;

        if (0.001 >= Math.abs(Math.round(rawValue3) - rawValue3))
        {
            results_new = (int) (Math.round(rawValue3));


            results_old = (int) (Math.round(rawValue3));
        }
        else
        {
            boolean negative = Double.doubleToLongBits(rawValue3) < 0;
            results_new = (int) Math.floor(Math.abs(rawValue3));
            results_new = negative ? - results_new : results_new;


            results_old = (int) Math.floor(rawValue3);
        }

        System.out.println("Before: ");
        System.out.println(rawValue3);

        System.out.println("After results_new: ");
        System.out.println(results_new);

        System.out.println("After results_old: ");
        System.out.println(results_old);

    }
}

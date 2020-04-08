package Vectors;



public class Main {

    public static void main(String[] args)
    {

        Vector3d a = new Vector3d(1,2,3);

        Vector3d b = new Vector3d(4,5,6);

        Vector2d two_d_1 = new Vector2d(1,2);
        Vector2d two_d_2 = new Vector2d(3,5);


        System.out.println("2d");
        System.out.println("Sum "+ two_d_1.add( two_d_2).getX()+" "+ two_d_1.add( two_d_2).getY()+" ");
        System.out.println("Subtract " +  two_d_1.subtract( two_d_2).getX()+" "+ two_d_1.subtract( two_d_2).getY());
        System.out.println("Scalar Multiple " + two_d_1.scalarMultiply(two_d_2));



        System.out.println("3d");
        System.out.println("Sum "+a.add(b).getX()+" "+a.add(b).getY()+" "+a.add(b).getZ()+" ");
        System.out.println("Subtract " + a.subtract(b).getX()+" "+a.subtract(b).getY()+" "+a.subtract(b).getZ()+" ");
        System.out.println("Scalar Multiple " + a.scalarMultiply(b));
        System.out.println("Vector Multiple " +a.vectorMultiply(b).getX()+" "+a.vectorMultiply(b).getY()+" "+a.vectorMultiply(b).getZ()+" ");
    }
}

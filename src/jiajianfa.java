public class jiajianfa {
    public static void main(String[] args) {
        for (int i=-14; i<15; i++) {
            for (int j=-14; j<15; j++){
                for (int a=-14; a<15; a++){
                    for (int b=-14; b<15; b++){
                        if (i+j==8 && i+a==14 && j+b==10 && a-b==6)
                            System.out.println(i+","+j+","+a+","+b);
                    }
                }
        }
        }
    }
}

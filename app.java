import java.io.IOException;
import java.util.Scanner;
class app{
    public static void main(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.print("\n");
        String[][] sistema = {{"3x","2y","-z","0"},{"x","3y","z","1"},{"2x","2y","-2z","2"}};
        showmatriz(sistema);
        String[][] coefficients = getCoefficients(sistema);
        showmatriz(sistema);
        determinant(coefficients);
        
    }
        public static String[][] determinant(String[][] matriz){

        System.out.println("\nCalculando determinante:\n");
        int sumDiagonal1 = Integer.parseInt(matriz[0][0])*
            Integer.parseInt(matriz[1][1])*
            Integer.parseInt(matriz[2][2]);
        int sumDiagonal2 = Integer.parseInt(matriz[0][1])*
            Integer.parseInt(matriz[1][2])*
            Integer.parseInt(matriz[2][0]);
        int sumDiagonal3 = Integer.parseInt(matriz[0][2])*
            Integer.parseInt(matriz[1][0])*
            Integer.parseInt(matriz[2][1]);
        
        int sumDiagonal4 = Integer.parseInt(matriz[0][1])*
            Integer.parseInt(matriz[1][0])*
            Integer.parseInt(matriz[2][2]);

        int sumDiagonal5 = Integer.parseInt(matriz[0][0])*
            Integer.parseInt(matriz[1][2])*
            Integer.parseInt(matriz[2][1]);
        
        int sumDiagonal6 = Integer.parseInt(matriz[0][2])*
            Integer.parseInt(matriz[1][1])*
            Integer.parseInt(matriz[2][0]);
        
        
        System.out.println(matriz[0][0]+" * "+matriz[1][1]+" * "+matriz[2][2]+" = "+sumDiagonal1);
        System.out.println(matriz[0][1]+" * "+matriz[1][2]+" * "+matriz[2][0]+" = "+sumDiagonal2);
        System.out.println(matriz[0][2]+" * "+matriz[1][0]+" * "+matriz[2][1]+" = "+sumDiagonal3);

        System.out.println("\nSoma das diagonais da esquerda para a direita:  "+String.valueOf(sumDiagonal1)+" + "+
        String.valueOf(sumDiagonal2)+" + "+String.valueOf(sumDiagonal3)+" = "+
        String.valueOf(sumDiagonal1+sumDiagonal2+sumDiagonal3)+'\n');

        System.out.println(matriz[0][1]+" * "+matriz[1][0]+" * "+matriz[2][2]+" = "+sumDiagonal4);
        System.out.println(matriz[0][0]+" * "+matriz[1][2]+" * "+matriz[2][1]+" = "+sumDiagonal5);
        System.out.println(matriz[0][2]+" * "+matriz[1][1]+" * "+matriz[2][0]+" = "+sumDiagonal6);
        System.out.println("\nSoma das diagonais da direita para a esquerda: "+String.valueOf(sumDiagonal4)+
        " + "+String.valueOf(sumDiagonal5)+" + "+
        String.valueOf(sumDiagonal6)+" = "+String.valueOf(sumDiagonal4+sumDiagonal5+sumDiagonal6)+'\n');
        int determinant = Integer.parseInt(String.valueOf((sumDiagonal1+sumDiagonal2+sumDiagonal3) - (sumDiagonal4+sumDiagonal5+sumDiagonal6))) + determinant;
        System.out.println("Determinante: "+(sumDiagonal1+sumDiagonal2+sumDiagonal3)+ " - " + (sumDiagonal4+sumDiagonal5+sumDiagonal6)+" = "+determinant);
        return matriz;
    }
    public static String[][] getCoefficients(String[][] matriz){

        String[] numbers = new String[] {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0;i<matriz.length;i++){
            for(int a = 0;a<matriz[i].length;a++){
                if (matriz[i][a].matches(".*[a-z].*")) { 
                    System.out.println(matriz[i][a]+" tem letra");
                    matriz[i][a] = matriz[i][a].replaceAll("([a-z])",""); 
                    if(matriz[i][a].matches("-")){
                        matriz[i][a] = matriz[i][a].replaceAll("-","-1");
                    }else if(matriz[i][a].matches("")){
                        matriz[i][a] = matriz[i][a].replaceAll("","1");
                    }
                }else{
                    System.out.println(matriz[i][a]+" não tem letra");
                }

            }
        }
        return matriz;
    }
    public static String[][] sistem(String[][] matriz){
        for(int i = 0;i<matriz.length;i++){
            System.out.print("{ ");
            for(int a=0;a<matriz[i].length;a++){
                if(a == 2){
                    System.out.print(matriz[i][a]+" = ");
                }else if(a == 3){
                    System.out.print(matriz[i][a]);

                }else{
                    System.out.print(matriz[i][a]+" + ");
                }
            }
            System.out.print("\n");
        }
        return  matriz;
    }

    
    public static void showmatriz(String[][] array){
        for(int i = 0;i<array.length;i++){
            System.out.print("[");
            for(int a = 0;a<array.length;a++){
                if(a == 2 || a==4 || a==6){
                    System.out.print(array[i][a]);
                }else{
                    System.out.print(array[i][a]+',');
                }
            }System.out.print("]\n");
        }
        System.out.print("\n");

    }
    public static String[][] getRow(String... arg) throws IOException, InterruptedException{
        String[][] row = new String[3][4];
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i<row.length;i++){
            for(int a = 0;a<row[i].length;a++){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                int posicao = 0;
                
                if(i==0){
                    posicao = a+1;
                }else if(i==1){
                    posicao = (i*3)+(a+2);
                }else if(i==2){
                    posicao = (i*3)+(a+3);
                }
                if(i==0 && i==a){

                    System.out.print("{(Posição 1) + (Posição 2) + (Posição 3) = (Posição 4)"+
                    "\n{(Posição 5) + (Posição 6) + (Posição 7) = (Posição 8)" + 
                    "\n{(Posição 9) + (Posição 10) + (Posição 11) = (Posição 12)\n");
                    System.out.print("Insira o elemento da posição 1"+ "\n");
                }else{
                    for(int l = 0;l<row.length;l++){
                            System.out.print("{");
                        for(int m = 0;m<row[l].length;m++){
                            if(row[l][m] == null){
                                
                            }else{
                                if(m == 3 || m == 6 ||m == 9){
                                    System.out.print("("+row[l][m]+")");
                                }else{
                                    if(m == 2){
                                        System.out.print("("+row[l][m]+") = ");
                                    }else{
                                        System.out.print("("+row[l][m]+") + ");

                                    }
                                }
                            }
                        }
                            System.out.print("\n");
                    }
                System.out.print("Insira o elemento da posicão "+posicao+ "\n");
                }
                row[i][a] = scan.next();
            }
        }
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        return row;
    }

}



//IDEIA: FAZER UM RELATÓRIO EM UM ARQUIVO TXT COM UM PASSO A PASSO DE COMO FAZER O CALCULO

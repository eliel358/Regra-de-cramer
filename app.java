import java.io.IOException;
import java.util.Scanner;
class app{
    public static void main(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // String[][] sistema = getRow();
        String[][] sistema = {{"2","3","4","71"},{"8","9","2","12"},{"3","4","3","31"}};
        sistem(sistema);
        System.out.print("\n");
        String[][] coefficients = getCoefficients(sistema);
        sistem(sistema);
        float determinantD = determinant(coefficients,"");
        float determinantX = determinant(replaceColumnnByResults(sistema, 0),"X");
        float determinantY = determinant(replaceColumnnByResults(sistema, 1),"Y");
        float determinantZ = determinant(replaceColumnnByResults(sistema, 2),"Z");
        System.out.println("\nd = "+ determinantD+"\n");
        System.out.println("dX = "+ determinantX+"\n");
        System.out.println("dY = "+ determinantY+"\n");
        System.out.println("dZ = "+ determinantZ+"\n");
        float x = determinantX/determinantD;
        float y = determinantY/determinantD;
        float z = determinantZ/determinantD;
        System.out.println("x = dX/d = "+x+"\n");
        System.out.println("y = dY/d = "+y+"\n");
        System.out.println("z = dZ/d = "+z+"\n");
    
    }

        public static float determinant(String[][] matrix,String matrixName){

        System.out.println("\nCalculando determinante "+matrixName+":\n");
        float sumDiagonal1 = Float.parseFloat(matrix[0][0])*
            Float.parseFloat(matrix[1][1])*
            Float.parseFloat(matrix[2][2]);
        float sumDiagonal2 = Float.parseFloat(matrix[0][1])*
            Float.parseFloat(matrix[1][2])*
            Float.parseFloat(matrix[2][0]);
        float sumDiagonal3 = Float.parseFloat(matrix[0][2])*
            Float.parseFloat(matrix[1][0])*
            Float.parseFloat(matrix[2][1]);
        
        float sumDiagonal4 = Float.parseFloat(matrix[0][1])*
            Float.parseFloat(matrix[1][0])*
            Float.parseFloat(matrix[2][2]);

        float sumDiagonal5 = Float.parseFloat(matrix[0][0])*
            Float.parseFloat(matrix[1][2])*
            Float.parseFloat(matrix[2][1]);
        
        float sumDiagonal6 = Float.parseFloat(matrix[0][2])*
            Float.parseFloat(matrix[1][1])*
            Float.parseFloat(matrix[2][0]);
        
        for(int i = 0;i<matrix.length;i++){
            System.out.print("[");
            for(int a = 0;a<matrix.length;a++){
                if(a == 2 || a==4 || a==6){
                    System.out.print(matrix[i][a]);
                }else{
                    System.out.print(matrix[i][a]+',');
                }
            }
            System.out.print("]");
            System.out.print("[");
            for(int a = 0;a<2;a++){
                if(a == 1){
                    System.out.print(matrix[i][a]+"]");
                }else{
                    System.out.print(matrix[i][a]+',');
                }
            }
        System.out.print("\n"   );
        }
        
        System.out.print("\n");



        System.out.println("\nSoma do produto dos elementos nas diagonais da esquerda para a direita:  \n");
        System.out.println(matrix[0][0]+" * "+matrix[1][1]+" * "+matrix[2][2]+" = "+sumDiagonal1);
        System.out.println(matrix[0][1]+" * "+matrix[1][2]+" * "+matrix[2][0]+" = "+sumDiagonal2);
        System.out.println(matrix[0][2]+" * "+matrix[1][0]+" * "+matrix[2][1]+" = "+sumDiagonal3+'\n');
        
        System.out.println(String.valueOf(sumDiagonal1)+" + "+
        String.valueOf(sumDiagonal2)+" + "+String.valueOf(sumDiagonal3)+" = "+
        String.valueOf(sumDiagonal1+sumDiagonal2+sumDiagonal3)+'\n');

        System.out.println("\nSoma do produto dos elementos nas diagonais da direita para a esquerda: \n");

        System.out.println(matrix[0][1]+" * "+matrix[1][0]+" * "+matrix[2][2]+" = "+sumDiagonal4);
        System.out.println(matrix[0][0]+" * "+matrix[1][2]+" * "+matrix[2][1]+" = "+sumDiagonal5);
        System.out.println(matrix[0][2]+" * "+matrix[1][1]+" * "+matrix[2][0]+" = "+sumDiagonal6+'\n');
        System.out.println(String.valueOf(sumDiagonal4)+
        " + "+String.valueOf(sumDiagonal5)+" + "+
        String.valueOf(sumDiagonal6)+" = "+String.valueOf(sumDiagonal4+sumDiagonal5+sumDiagonal6)+"\n");
        float determinant = Float.parseFloat(String.valueOf((sumDiagonal1+sumDiagonal2+sumDiagonal3) - (sumDiagonal4+sumDiagonal5+sumDiagonal6)));
        System.out.println("Determinante "+matrixName+": "+(sumDiagonal1+sumDiagonal2+sumDiagonal3)+ " - " + (sumDiagonal4+sumDiagonal5+sumDiagonal6)+" = "+determinant);
        return determinant;
    }
    public static String[][] getCoefficients(String[][] matrix){
        System.out.println("Obtendo os coeficientes: \n");
        String[] numbers = new String[] {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0;i<matrix.length;i++){
            for(int a = 0;a<matrix[i].length;a++){
                if (matrix[i][a].matches(".*[a-z].*")) {
                    matrix[i][a] = matrix[i][a].replaceAll("([a-z])",""); 
                    if(matrix[i][a].matches("-")){
                        matrix[i][a] = matrix[i][a].replaceAll("-","-1");
                    }else if(matrix[i][a].matches("")){
                        matrix[i][a] = matrix[i][a].replaceAll("","1");
                    }
                }

            }
        }
        return matrix;
    }
    public static String[][] sistem(String[][] matrix){
        for(int i = 0;i<matrix.length;i++){
            System.out.print("{ ");
            for(int a=0;a<matrix[i].length;a++){
                if(a == 2){
                    System.out.print(matrix[i][a]+" = ");
                }else if(a == 3){
                    System.out.print(matrix[i][a]);

                }else{
                    System.out.print(matrix[i][a]+" + ");
                }
            }
            System.out.print("\n");
        }
        return  matrix;
    }
    public static void showmatrix(String[][] array){
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
                float posicao = 0;
                
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
    public static String[][] replaceColumnnByResults(String[][] matrix,float columnIndex){
            
        String[][] newMatrix = new String[3][4];
        for(int i = 0;i<matrix.length;i++){
            for(int a = 0;a<matrix[i].length;a++){
                if (a == columnIndex){
                    newMatrix[i][a] = matrix[i][3];
                }else{
                    newMatrix[i][a] = matrix[i][a];
                }
            }
        }
        
        return newMatrix;

    }

}


//IDEIA: FAZER UM RELATÓRIO EM UM ARQUIVO TXT COM UM PASSO A PASSO DE COMO FAZER O CALCULO

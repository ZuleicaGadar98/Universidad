//import java.util.Scanner;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Busca_Minas {
   
    public static void main(String[] args) {
      
        int n, opt, resDiscover = 0;
        char[][] game;
        char[][] bombs;
       
        n = Integer.parseInt(JOptionPane.showInputDialog("Escribe las dimension del tablero nxn"));
        while (n <= 0) {
            
            n = Integer.parseInt(JOptionPane.showInputDialog("Opción invalida, ingresa nuevamente un número positivo del 0-9"));
        }

        game = createLayout(n, '?');
        bombs = createLayout(n, '?');
        placeBombs(bombs, n, n);
        System.out.println(printLayout(game, n));
        System.out.println("Hay " + n + " bombas, ENCUETRALAS!!");

    
        opt = Integer.parseInt(JOptionPane.showInputDialog("Elige la opcion correspondiente: \n 1.-Marcar posible bomba \n 2.-Descubrir casilla \n 3.-Imprimir tablero \n 4.-Resolver \n 5.-Salir del juego") );
       
        while (opt != 5) {
            switch (opt) {
                case 1:

                    betBomb(game, n);

                    break;
                case 2:

                    resDiscover = discoverCellAndCheckNeighborhood(game, bombs, n);
                    break;

                case 3:
                    System.out.println(printLayout(game, n));
                    break;

                case 4:
                    
                    resolve(game, bombs, n);
                    break;

                case 5:
                    System.out.println("GAME OVER");
                    break;
                default:
                    System.out.println("Opción no valida. Intenta de nuevo con un numero correspondiente en el menú.");
            }
            //Este if y la variable resDiscover los agrego para tener una forma de salir del bucle sin tener que recurrir a cosas como System.exit()
            if (resDiscover == -1) {
                System.out.println(printLayout(game, n));
                System.out.println("GAME OVER:(");
                opt = 5;
            } else {
               // printMenu();
                opt = Integer.parseInt(JOptionPane.showInputDialog("Elige la opcion correspondiente: \n 1.-Marcar posible bomba \n 2.-Descubrir casilla \n 3.-Imprimir tablero \n 4.-Resolver \n 5.-Salir del juego") );
               
            }


        }

    }

   

    private static int[] checkIndexes(int i, int j, int n) {
        

        int[] vector = new int[2];
        while (!(i >= 0 && i < n && j >= 0 && j < n)) {
       
            i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la fila"));
         
            j = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la columna"));
        }
        vector[0] = i;
        vector[1] = j;
        return vector;

    }

    private static void betBomb(char[][] layout, int n) {
        /*Este método toma un array bidimensional, la dimensión n del array nxn y un
        objeto Scanner, sc, como entrada. Entonces pide al usuario dos índices
        para marcar una celda como celda con bomba. Tenga en cuenta que no
        puede tener más apuestas de bomba que número de bombas y que ha
        de asegurar que la consulta al array bidimensional se hace dentro de los límites
        definidos (de 0 a n-1 en ambas dimensiones). Use el método
        checkIndexes (), definido abajo, para hacer esto.*/

        //Primero tengo que comprobar cuantas betbombs ya hay en el tablero
        int maxBetBomb = 0, i, j;
        int[] pos;
        for (int k = 0; k < layout.length; k++) {
            for (int l = 0; l < layout.length; l++) {
                if (layout[k][l] == 'B')
                    maxBetBomb++;

            }
        }

        if (maxBetBomb >=n) {
            System.out.println("Número maximo de banderas que puede poner alcanzado");
        } else {
           
            i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la fila"));
           
            j = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la columna"));
            pos = checkIndexes(i, j, n);

            layout[pos[0]][pos[1]] = 'F';
        }


    }

    private static void placeBombs(char[][] layout, int n, int numBombs) {
        /*Este método toma un array bidimensional (que representa el tablero), la
        dimensión n del array y el número de bombas que debemos colocar en el array,
        numBombs, y devuelve un array bidimensional numBombs bombas colocadas
        aleatoriamente. Tenga en cuenta que cada celda del array puede tener, como
        mucho, una bomba*/
        //Las bombas estan representadas con una "B"
        int i = 0, numA, numB, min = 0, max = n - 1;

        while (i < numBombs) {//Este se encaga del nbombas
            numA = ThreadLocalRandom.current().nextInt(min, max + 1);
            numB = ThreadLocalRandom.current().nextInt(min, max + 1);
            if (layout[numA][numB] != 'B') {//Esto se encarga de no repetir el proceso
                layout[numA][numB] = 'B';
                i++;
            }
        }
    }

    private static char[][] createLayout(int n, char c) {
        /*Este método devolverá un array bidimensional de tipo char, de dimensión nxn
        donde cada celda colocará el carácter c pasado por parámetro.*/
        char[][] matriz = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = c;
            }
        }
        return matriz;
    }

    private static int discoverCellAndCheckNeighborhood(char[][] layout, char[][] bombs, int n) {
        /* Este método toma un array bidimensional, layout, la dimensión n y un objeto Scanner, sc. Pedirá al usuario dos índices para descubrir una
        celda. Si la celda seleccionada contiene una bomba, eche un mensaje indicando que se ha perdido y finalice el programa. Si no contiene una bomba, cuente el
        número de bombas que están las 8 celdas inmediatamente contiguas (las 4 a en vertical y horizontal, y las 4 en diagonal) y colocará este número a la
         celda seleccionada. Tengais en cuenta que debe asegurarse que los índices solicitados se encuentran dentro de los límites del array bidimensional. Use el método
         checkIndexes (), definido abajo, para hacer esto. */

        int i, j, fila, col, numBombas = 0;
        int[] pos;

        //Esta parte del codigo se encarga de obtener unas coordenadas cons sentido del usuario
    
        i = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la fila"));
     
        j = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de la columna"));
        pos = checkIndexes(i, j, n);
        fila = pos[0];
        col = pos[1];

        //Primero en el caso que el usuario haya pisado una bomba retorno un valor que si es =-1 el programa terminara,tambien para que el usuario lo sepa cuando esto pase en el main llamaremos a printLayout
        if (bombs[fila][col] == 'B') {
            layout[fila][col] = 'B';
            return -1;
        }
        //Y para contar el numero de bombas alrededor solo hacemos un bucle de 3x3(la variables x,y se toman ese rol) en el que sumaremos 1 a numBombas por cada bomba
        //Para controlar que no se salga de rango las variables encargadas de las coordenadas(k y l) solo tomamos los valores donde tienen sentido osea mayor a 0  y menor a n
        else {
            for (int k = fila - 1, x = 0; x < 3; k++, x++) {
                for (int l = col - 1, y = 0; y < 3; l++, y++) {
                    if (k >= 0 && k < n && l >= 0 && l < n) {
                        if (bombs[k][l] == 'B')
                            numBombas++;
                    }

                }
            }
        }
        //Finalmente convierto el int a char
        layout[fila][col] = (char) (numBombas + '0');
        return 0;
    }


    private static void resolve(char[][] layout, char[][] bombs, int n) {
        /* Este método toma dos arrays bidimensionales, layout y bombs, y la dimensión n de los arrays nxn como entrada. Comprobará si en el primer array bidimensional
         se han marcado correctamente todas las casillas como bomba, comparándolo con el segundo array bidimensional (que contiene las bombas). */

        int bombasCubiertas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombs[i][j] == 'B') {
                    if (bombs[i][j] == layout[i][j])
                        bombasCubiertas++;

                }
            }
        }
        if (bombasCubiertas == n)
            System.out.println("VICTORIA!! :) (Elija la opcion salir)");
        else
            System.out.println("Aun hay bombas por descubrir, continua");
    }

    private static String printLayout(char[][] layout, int n) {
        int i, j;
        String output = "  | ";
        for (i = 0; i < n; i++) {
            output += i + " ";
        }
        output += '\n' + "  ";
        for (i = 0; i <= n; i++) {
            output += "- ";
        }
        output += '\n';
        for (i = 0; i < n; i++) {
            output += i + " | ";
            for (j = 0; j < n; j++) {
                output += layout[i][j] + " ";
            }
            output += '\n';
        }
        return output;
    }
}
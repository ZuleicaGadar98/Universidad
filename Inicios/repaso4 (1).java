//Programa para el método 4

//Autor: Zuleica Gadar
//Fecha; 3 de diciembre de 2017

import java.util.Scanner;

class repaso4
{
	//Método main
		public static void main (String arg[])
	{

		//CHARS
			char re=' ';

			//Scanner
				Scanner a=new Scanner (System.in);
				System.out.println("Hola...");
				System.out.println("¿Vas a ingresar una palabra? Si=S, No=N");
				re=a.next().charAt(0);

				//While
					while (re=='s' || re=='S')
					{
						palin.pal();
						System.out.println("\nIngresa una palabra (S/N)");
						re=a.next().charAt(0);
					}

					System.out.println("Adios, gracias por utilizar este programa");
		}
}

class palin
{
	public static void pal()
	{
		//Variables

			String pal,pall="";
			boolean f=true;

			//Entrada
				Scanner a=new Scanner (System.in);
				System.out.println("Escribe una frase, todo en minúscula porfavor y sin acentos");
				pal=a.nextLine();
				f=true;

					//Ciclo for

						for (int n=0; n<pal.length(); n++)
						{
							//Condición

								if (pal.charAt(n)!= ' ')
								{
									pall+=pal.charAt(n);
								}
						}

					//Ciclo for

						for (int i=0, j=pall.length()-1; i<j; i++, j--)
						{
							//Condición
								if (pall.charAt(i)!=pall.charAt(j))
								{
									f=false;
								}
						}

					//Condición

						if (f==true)
						{
							System.out.println("\nLa frase "+ pal + ", es un palindromo");
						}
						else
						{
							System.out.println("\nLa frase " + pal+ ", no es palindromo");
						}
		}
}

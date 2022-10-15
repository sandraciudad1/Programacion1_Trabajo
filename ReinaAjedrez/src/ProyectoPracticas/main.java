//SANDRA CIUDAD MORENO 1.B, LA REINA DEL AJEDREZ.

package ProyectoPracticas;
	import java.io.File;
	import java.util.Scanner;

	public class main {
	     public static void main(String args[]) throws Exception{
	     
	          char[][] M=null;
	          int d=0, contR=0;
	          
	          //Introducir y crear la matriz vacia.
	          while(d<=0) d=leerEntero("Introduzca la dimensi�n de la matriz:");
              M=new char[d][d];
              inicializar(M);
              System.out.println("Se ha creado la siguiente matriz:");
              System.out.println(mostrar(M));
              System.out.println("Debe tenerse en cuenta que las filas y las columnas comienzan a contarse en 0, no en 1.\n");
              
              //Rellenar la matriz anterior con x dependiendo del lugar que ocupe la reina R y mostrarla.
              while(M!=null && !completa(M)){
                        int fila=leerEntero("Introduzca la FILA:");
                        int col=leerEntero("Introduzca la COLUMNA:");
                        String s=colocar(M,fila,col);
                        if(s.equals("Dato correcto")) contR++;
                        System.out.println("");
                        System.out.println(s+ "\nSe han introducido "+contR+ " reinas.");
                        System.out.println(mostrar(M));
                    }
              if(completa(M)==true) {
            	  System.out.println("La matriz ya est� completa.");
              }
	     }
	          
	      	     
	     //LEER ENTERO.
	     public static int leerEntero(String s){
	           Scanner lector=new Scanner(System.in);
	           System.out.println(s);
	           return lector.nextInt();
	      }
	      
	      //INICIALIZAR MATRIZ.
	      public static void inicializar(char[][] M){
	    	  for (int filas=0; filas<M.length; filas++)
	              for(int columnas=0; columnas <M[0].length; columnas++)
	                  M[filas][columnas]='o';
	      }
	     
	      
	      //COLOCAR LAS REINAS.
	      public static String colocar(char[][] M,int filas, int columnas){
	          String s="Dato correcto";
	          if (filas<0 || filas>=M.length || columnas<0 || columnas>=M[0].length)
	              s = "La casilla seleccionada se encuentra fuera de los l�mites del tablero. \n";
	          else{
	              if(M[filas][columnas]=='x' || M[filas][columnas]=='R' ) 
	            	  s = "El lugar seleccionado ya est� ocupado. \n";
	              else{
	                  M[filas][columnas]='R';
	                  rellenarH(M,filas);
	                  rellenarV(M,columnas);
	                  rellenarDDerecha(M,filas,columnas);
	                  rellenarDIzquierda(M,filas,columnas);
	              }
	          }
	          return s;
	      }
	      
	      
	      //RELLENAR LAS CASILLAS HORIZONTALES.
	      private static void rellenarH(char[][] M,int filas){
	          for(int columnas=0; columnas<M[0].length; columnas++)
	              if(M[filas][columnas]=='o') 
	            	  M[filas][columnas]='x';
	      }
	      
	      
	      //RELLENAR LAS CASILLAS VERTICALES.
	        private static void rellenarV(char[][] M,int columnas){
	          for(int filas=0; filas <M.length; filas++)
	              if(M[filas][columnas]=='o') 
	            	  M[filas][columnas]='x';
	      }
	        
	        
	      //RELLENAR LAS CASILLAS EN LA DIAGONAL DERECHA.
	      private static void rellenarDDerecha(char[][] M, int filas, int columnas){
	          for (int i=0; filas +i <M.length && columnas +i<M[0].length; i++)
	                  if(M[filas+i][columnas+i]=='o') 
	                	  M[filas+i][columnas+i]='x';
	           for (int i=0;filas-i>=0 && columnas-i>=0; i++)
	                  if(M[filas-i][columnas-i]=='o') 
	                	  M[filas-i][columnas-i]='x';
	      }
	      
	      
	      //RELLENAR LAS CASILLAS EN LA DIAGONAL INZQUIERDA.
	       private static void rellenarDIzquierda(char[][] M, int filas, int columnas){
	          for (int i=0; filas+i <M.length && columnas-i>=0; i++)
	                  if(M[filas+i][columnas-i]=='o') 
	                	  M[filas+i][columnas-i]='x';
	           for (int i=0; filas-i>=0 && columnas+i<M[0].length; i++)
	                  if(M[filas-i][columnas+i]=='o') 
	                	  M[filas-i][columnas+i]='x';
	      }
	       
	       
	       //MOSTRAR MATRIZ.
	       public static String mostrar(char[][] d){
	        String s = "\n";
	        for(int n=0; n <d.length; n++){
	            for(int c=0; c <d[0].length; c++) 
	            	s = s+" "+d[n][c];
	            	s = s+"\n";
	        }
	        return s;
	    }
	       
	       
	       //COMPROBAR SI LA MATRIZ EST� COMPLETA.
	       private static boolean completa(char[][] m){
	           boolean completa=true;
	           for(int filas=0; filas <m.length && completa ; filas++)
	               for(int columnas=0; columnas <m[0].length && completa; columnas++)
	                   if(m[filas][columnas]=='o') 
	                	   completa=false;
	           return completa;
	       }
	}
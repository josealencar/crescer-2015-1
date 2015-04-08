
/**
 * Write a description of class ContadorDeNumeros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContadorDeNumeros
{
    public void contadorAte3(){
        for(int i=0;i<3;i++){
            System.out.println(i+1);
        }
    }
    
    public void contadorAte(int valor){
        for(int i=0;i<valor;i++){
            System.out.println(i+1);
        }
    }
    
    public void contadorRegressivamenteAte(int valor){
        for(int i=valor;i>0;i--){
            System.out.println(i);
        }
    }
}

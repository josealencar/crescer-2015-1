
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    /**
     * Cria um elfo informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        umOrc.recebeAtaque();
    }
    
<<<<<<< HEAD
    public String getNome(){
        return this.nome;
    }
    
    public int getFlechas(){
        return this.flechas;
    }

    public int getExperiencia(){
        return this.experiencia;
    }
    
    /*public void setNome(String novoNome) {
        nome = novoNome;
    }*/


=======
    public String getNome() {
        return this.nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
>>>>>>> 48edd962379c28721428de9fe01092bd5fc74457
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    
    
    
    
    
}

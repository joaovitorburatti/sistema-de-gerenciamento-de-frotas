public class Carro extends Veiculo {
    private int nPortas;

    public int getNumeroPortas() {
        return nPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.nPortas = numeroPortas;
    }

   
    @Override
    public String toString() {
        return super.toString() + ", Número de Portas: " + nPortas;
    }
}

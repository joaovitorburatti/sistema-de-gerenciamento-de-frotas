public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

   
    @Override
    public String toString() {
        return super.toString() + ", Partida Elétrica: " + (partidaEletrica ? "Sim" : "Não");
    }
}

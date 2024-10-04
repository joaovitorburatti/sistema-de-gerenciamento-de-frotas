import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public Veiculo adicionar(Veiculo veiculo) {
       
        frota.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> pesquisarTodos() {
       
        return frota;
    }

    public Veiculo pesquisarPorPlaca(String placa) {
       
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerPorPlaca(String placa) throws Exception {
      
        Veiculo veiculo = pesquisarPorPlaca(placa);
        if (veiculo == null) {
            throw new Exception("Veículo não encontrado.");
        }
        frota.remove(veiculo);
    }
}

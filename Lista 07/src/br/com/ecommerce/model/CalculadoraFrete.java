import br.com.ecommerce.exception.TipoFreteInvalidoException;

package br.com.ecommerce.model;
public class CalculadoraFrete {

    public double processarFrete(double valorPedido, EstrategiaFrete estrategiaFrete) throws TipoFreteInvalidoException {
     if(estrategiaFrete == null){
        throw new TipoFreteInvalidoException("Estratégia de frete inválida.");
     }
     return estrategiaFrete.calcular(valorPedido);
    }

}
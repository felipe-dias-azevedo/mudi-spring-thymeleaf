package felipe.mudi.dto;

import felipe.mudi.model.Pedido;
import felipe.mudi.model.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PedidoNovoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String urlImagem;

    @NotBlank
    private String urlProduto;

    private String descricao;

    public Pedido toPedido() {
        var pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNome(nome);
        pedido.setUrlImagem(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}

package felipe.mudi.controller;

import felipe.mudi.dto.PedidoNovoRequest;
import felipe.mudi.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private PedidoRepository repository;

    @GetMapping("formulario")
    public String formulario(PedidoNovoRequest novoPedido) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid PedidoNovoRequest novoPedido, BindingResult result) {

        if (result.hasErrors()) {
            return "pedido/formulario";
        }

        var pedido = novoPedido.toPedido();
        repository.save(pedido);

        return "redirect:/home";
    }
}

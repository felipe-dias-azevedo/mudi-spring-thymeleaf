package felipe.mudi.controller;

import felipe.mudi.model.StatusPedido;
import felipe.mudi.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("home")
@AllArgsConstructor
public class HomeController {

    private PedidoRepository repository;

    @GetMapping
    public String home(Model model) {
        var pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("{status}")
    public String porStatus(@PathVariable String status, Model model) {
        var pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}

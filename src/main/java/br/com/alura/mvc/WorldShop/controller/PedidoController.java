package br.com.alura.mvc.WorldShop.controller;

import br.com.alura.mvc.WorldShop.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.WorldShop.model.Pedido;
import br.com.alura.mvc.WorldShop.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result, Model model){
        Pedido pedido = new Pedido();
        pedido.cadastrar(requisicao);

        if(result.hasErrors()){
            return "/pedido/formulario";
        } else {
            repository.save(pedido);
            model.addAttribute("/");
            return "redirect:/";
        }
    }
}

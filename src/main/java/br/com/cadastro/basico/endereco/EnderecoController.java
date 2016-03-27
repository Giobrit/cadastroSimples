package br.com.cadastro.basico.endereco;

import br.com.cadastro.basico.utils.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ModelMapper mapeador;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco enderecoRecebido = mapeador.map(enderecoDTO, Endereco.class);

        Endereco endereco = enderecoService.criarEndereco(enderecoRecebido);

        EnderecoDTO retorno = mapeador.map(endereco, EnderecoDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }

    @RequestMapping(value = "/{idEndereco}", method = RequestMethod.PUT)
    public void editarEndereco(@PathVariable Long idEndereco, @RequestBody EnderecoDTO enderecoDTO) {
        Endereco endereco = mapeador.map(enderecoDTO, Endereco.class);

        enderecoService.editarEndereco(endereco);
    }

    @RequestMapping(value = "/{idEndereco}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> localizarEndereco(@PathVariable Long idEndereco) {
        Endereco endereco = enderecoService.localizarEndereco(idEndereco);

        EnderecoDTO retorno = mapeador.map(endereco, EnderecoDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }

    @RequestMapping(value = "/{idEndereco}", method = RequestMethod.DELETE)
    public void criarEndereco(@PathVariable Long idEndereco) {
        enderecoService.excluirEndereco(idEndereco);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> listarEndereco() {
        List<Endereco> enderecos = enderecoService.listarEndereco();

        Type listType = new TypeToken<List<EnderecoListagemDTO>>() {
        }.getType();

        List<EnderecoListagemDTO> retorno = mapeador.map(enderecos, listType);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(retorno));
    }
}

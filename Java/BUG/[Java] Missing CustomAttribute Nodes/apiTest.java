import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExemploController {

    @GetMapping("/exemplo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Requisição inválida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    public ResponseEntity<String> exemplo() {
        // Lógica do endpoint
        return new ResponseEntity<>("Exemplo de resposta da API", HttpStatus.OK);
    }


	@Operation(summary = "Get thing", responses = {
      	@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
      	@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
     	 	@ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
	@RequestMapping(path = "/testme", method = RequestMethod.GET)
	ResponseEntity<String> testme() {
  	 return ResponseEntity.ok("Hello");
	}

	
	@GetMapping("/exemplo")
	@ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
      @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	public ResponseEntity<String> getExampleData() {
        try {
            // Code to retrieve example data
            String exampleData = "This is an example response";
            return ResponseEntity.ok(exampleData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



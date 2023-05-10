package mx.gapsi.restfulservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.gapsi.restfulservice.exception.BadRequestException;
import mx.gapsi.restfulservice.v1.dto.ArticleDto;
import mx.gapsi.restfulservice.v1.dto.ArticleUpdateDto;
import mx.gapsi.restfulservice.v1.dto.ResponseDto;
import mx.gapsi.restfulservice.v1.services.IArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Yamel Alvarez Chacón
 * @Creation 10/05/2023
 */

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1")
@Tag(name = "API-GAPSI", description = "Examen práctico Servicios RESTful - Springboot - GAPSI")
public class ArticleController {

    private final IArticleService articleService;

    @Operation(summary = "Buscar un artículo por el identificador", description = "Retorna un solo artículo",
            tags = {"API-GAPSI"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content =
            @Content(mediaType = APPLICATION_JSON_VALUE, schema =
            @Schema(implementation = ArticleDto.class)))})
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ArticleDto> getArticleById(
            @Parameter(in = PATH, description = "Un valor único identificando este artículo", required = true)
            @PathVariable("id")
            String id) throws Exception {
        log.info("[GAPSI] - method:GET, url:/v1/{} ", id);

        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @PostMapping(path = "", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Crear un nuevo artículo", description = "Crear un nuevo artículo",
            tags = {"API-GAPSI"})
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    ResponseEntity<ResponseDto> createArticle(@Valid @RequestBody ArticleDto articleDto, BindingResult result) {
        log.info("[GAPSI] - method:POST, url:/v1, parameters:{ "
                        + "Body: {}}",
                articleDto);

        if (result.hasErrors())
            throw new BadRequestException(result.toString());

        ResponseDto response = articleService.createArticle(articleDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un artículo dado el identificador",
            description = "Actualizar un artículo dado el identificador",
            tags = {"API-GAPSI"})
    public ResponseEntity<ArticleDto> updateArticle(
            @Parameter(in = QUERY,
                    description = "Identificador de artículo a actualizar")
            @PathVariable(value = "id") String articleId,
            @Valid @RequestBody ArticleUpdateDto articleDto, BindingResult result) {
        log.info("[GAPSI] - method:PUT, url:/v1/{}, " + "body:{}", articleId, articleDto);

        if (result.hasErrors())
            throw new BadRequestException(result.toString());

        return ResponseEntity.ok(articleService.updateArticle(articleDto, articleId));
    }

}
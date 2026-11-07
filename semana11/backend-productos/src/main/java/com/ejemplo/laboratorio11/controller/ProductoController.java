package com.ejemplo.laboratorio11.controller;

import com.ejemplo.laboratorio11.model.Producto;
import com.ejemplo.laboratorio11.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones del catálogo de productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Listar productos paginados",
               description = "Devuelve una página de productos usando page, size y sort")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Página obtenida correctamente")
    })
    @GetMapping("/pagina")
    public Page<Producto> listarPaginado(
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return productoService.listarPaginado(pageable);
    }

    @Operation(summary = "Buscar productos por nombre")
    @GetMapping("/pagina/buscar")
    public Page<Producto> buscar(
            @Parameter(description = "Texto contenido en el nombre")
            @RequestParam String nombre,
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return productoService.buscarPorNombre(nombre, pageable);
    }
}


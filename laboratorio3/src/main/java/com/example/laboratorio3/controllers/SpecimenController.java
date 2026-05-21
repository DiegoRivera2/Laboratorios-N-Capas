package com.example.laboratorio3.controllers;

import com.example.laboratorio3.dto.request.CreateSpecimenRequest;
import com.example.laboratorio3.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio3.dto.response.GeneralResponse;
import com.example.laboratorio3.dto.response.PageableResponse;
import com.example.laboratorio3.dto.response.SpecimenResponse;
import com.example.laboratorio3.services.SpecimenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specimens")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenService specimenService;

    @PostMapping
    public ResponseEntity<GeneralResponse<SpecimenResponse>> createSpecimen(
            @Valid @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpRequest
    ) {
        SpecimenResponse response = specimenService.createSpecimen(request);

        return buildResponse(
                "Specimen created successfully",
                HttpStatus.CREATED,
                httpRequest.getRequestURI(),
                response
        );
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<PageableResponse<SpecimenResponse>>> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest httpRequest
    ) {
        PageableResponse<SpecimenResponse> response =
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder);

        return buildResponse(
                "Specimens retrieved successfully",
                HttpStatus.OK,
                httpRequest.getRequestURI(),
                response
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> getSpecimenById(
            @PathVariable String id,
            HttpServletRequest httpRequest
    ) {
        SpecimenResponse response = specimenService.getSpecimenById(java.util.UUID.fromString(id));

        return buildResponse(
                "Specimen retrieved successfully",
                HttpStatus.OK,
                httpRequest.getRequestURI(),
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> updateSpecimen(
            @PathVariable String id,
            @RequestBody UpdateSpecimenRequest request,
            HttpServletRequest httpRequest
    ) {
        SpecimenResponse response = specimenService.updateSpecimen(
                java.util.UUID.fromString(id),
                request
        );

        return buildResponse(
                "Specimen updated successfully",
                HttpStatus.OK,
                httpRequest.getRequestURI(),
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse<SpecimenResponse>> deleteSpecimen(
            @PathVariable String id,
            HttpServletRequest httpRequest
    ) {
        SpecimenResponse response = specimenService.deleteSpecimen(java.util.UUID.fromString(id));

        return buildResponse(
                "Specimen deleted successfully",
                HttpStatus.OK,
                httpRequest.getRequestURI(),
                response
        );
    }

    private <T> ResponseEntity<GeneralResponse<T>> buildResponse(
            String message,
            HttpStatus status,
            String path,
            T data
    ) {
        GeneralResponse<T> response = GeneralResponse.<T>builder()
                .message(message)
                .status(status.value())
                .timestamp(java.time.LocalDateTime.now())
                .path(path)
                .data(data)
                .build();

        return new ResponseEntity<>(response, status);
    }
}
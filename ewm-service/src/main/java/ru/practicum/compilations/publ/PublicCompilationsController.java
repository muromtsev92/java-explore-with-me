package ru.practicum.compilations.publ;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.compilations.dto.CompilationDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PublicCompilationsController {
    private final PublicCompilationsService publicCompilationsService;

    @GetMapping(path = "/compilations")
    public List<CompilationDto> getCompilations(@RequestParam(name = "pinned", required = false) String pinned,
                                                @RequestParam(name = "from", defaultValue = "0") int from,
                                                @RequestParam(name = "size", defaultValue = "10") int size) {
        log.debug("public compilations GET: /compilations");
        return publicCompilationsService.getCompilations(pinned, from, size);
    }

    @GetMapping(path = "/compilations/{compilationId}")
    public CompilationDto getCompilationsById(@PathVariable(name = "compilationId") Long compilationId) {
        log.debug("public compilations GET: /compilations/{}", compilationId);
        return publicCompilationsService.getCompilationById(compilationId);
    }
}

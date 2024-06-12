package com.example.game_service.controller;

import com.example.game_service.commons.constants.ApiPathVariables;
import com.example.game_service.commons.entities.Game;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameAPI {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameByID(@PathVariable String id);
    @PutMapping("/{id}")
    ResponseEntity<Game> updateGame(@PathVariable String id, @RequestBody Game game);
}

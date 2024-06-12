package com.example.game_service.controller.implementation;
import com.example.game_service.commons.entities.Game;
import com.example.game_service.controller.GameAPI;
import com.example.game_service.services.GameService;
import com.example.game_service.services.implementation.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GameController implements GameAPI {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        Game gameCreated = gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameByID(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGame(String id, @RequestBody Game game) {
        Game gameUpdated = gameService.updateGame(game);
        return ResponseEntity.ok(gameUpdated);
    }
}

package com.example.game_service.services.implementation;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.commons.exceptions.GameException;
import com.example.game_service.repositories.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest){
        Game gameCreated = gameRepository.save(gameRequest);
        return gameCreated;
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id)).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Not found game"));
    }

    @Override
    public Game updateGame(Game gameRequest){
        Game gameUpdated = gameRepository.save(gameRequest);
        return gameUpdated;
    };


}

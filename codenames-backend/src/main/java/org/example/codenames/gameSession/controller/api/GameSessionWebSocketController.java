package org.example.codenames.gameSession.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.codenames.gameSession.entity.CreateGameRequest;
import org.example.codenames.gameSession.entity.HintRequest;
import org.example.codenames.gameSession.entity.VoteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.UUID;

/**
 * Interface for the GameSessionWebSocketController
 * This controller is used to manage the game sessions and the players connected to them
 */
public interface GameSessionWebSocketController {
    ResponseEntity<Map<String, String>> createGameSession(@RequestBody CreateGameRequest request) throws JsonProcessingException;

    ResponseEntity<Void> connectPlayer(@PathVariable UUID gameId, @RequestParam String userId, @RequestParam String teamIndex);

    ResponseEntity<Void> disconnectPlayer(@PathVariable UUID gameId, @RequestParam String userId);

    ResponseEntity<Void> startGame(@PathVariable UUID id) throws JsonProcessingException;

    ResponseEntity<Void> finishGame(@PathVariable UUID id) throws JsonProcessingException;

    ResponseEntity<?>  getGameSessions();

    ResponseEntity<?> sendHint(@PathVariable UUID gameId, @RequestBody HintRequest hintRequest) throws JsonProcessingException;

    ResponseEntity<?> changeTurn(@PathVariable UUID id) throws JsonProcessingException;

    ResponseEntity<?> revealCard(@PathVariable UUID gameId, @RequestBody String cardIndex) throws JsonProcessingException;

    ResponseEntity<?> submitVote(@PathVariable UUID id, @RequestBody VoteRequest voteRequest) throws JsonProcessingException;
}
